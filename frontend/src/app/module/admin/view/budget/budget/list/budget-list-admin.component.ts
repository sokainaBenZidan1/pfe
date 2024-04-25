import {Component, OnInit} from '@angular/core';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetCriteria} from 'src/app/shared/criteria/budget/BudgetCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {BudgetEntiteAdminDto} from 'src/app/shared/model/budget/BudgetEntiteAdmin.model';
import {BudgetEntiteAdminAdminService} from 'src/app/shared/service/admin/budget/BudgetEntiteAdminAdmin.service';


@Component({
  selector: 'app-budget-list-admin',
  templateUrl: './budget-list-admin.component.html'
})
export class BudgetListAdminComponent extends AbstractListController<BudgetDto, BudgetCriteria, BudgetAdminService>  implements OnInit {

    override fileName = 'Budget';




    constructor( private budgetService: BudgetAdminService  , private entiteAdminService: EntiteAdminAdminService, private budgetEntiteAdminService: BudgetEntiteAdminAdminService) {
        super(budgetService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Budget').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'dateBudget', header: 'Date budget'},
            {field: 'montant', header: 'Montant'},
            {field: 'montantInvestissement', header: 'Montant investissement'},
            {field: 'montantFonction', header: 'Montant fonction'},
        ];
    }



	public override initDuplicate(res: BudgetDto) {
        if (res.budgetEntiteAdmins != null) {
             res.budgetEntiteAdmins.forEach(d => { d.budget = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Date budget': this.datePipe.transform(e.dateBudget , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                 'Montant investissement': e.montantInvestissement ,
                 'Montant fonction': e.montantFonction ,
            }
        });

        this.criteriaData = [{
            'Date budget Min': this.criteria.dateBudgetFrom ? this.datePipe.transform(this.criteria.dateBudgetFrom , this.dateFormat) : environment.emptyForExport ,
            'Date budget Max': this.criteria.dateBudgetTo ? this.datePipe.transform(this.criteria.dateBudgetTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
            'Montant investissement Min': this.criteria.montantInvestissementMin ? this.criteria.montantInvestissementMin : environment.emptyForExport ,
            'Montant investissement Max': this.criteria.montantInvestissementMax ? this.criteria.montantInvestissementMax : environment.emptyForExport ,
            'Montant fonction Min': this.criteria.montantFonctionMin ? this.criteria.montantFonctionMin : environment.emptyForExport ,
            'Montant fonction Max': this.criteria.montantFonctionMax ? this.criteria.montantFonctionMax : environment.emptyForExport ,
        }];
      }
}
