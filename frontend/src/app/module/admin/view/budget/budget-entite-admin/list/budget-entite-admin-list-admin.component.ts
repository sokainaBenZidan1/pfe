import {Component, OnInit} from '@angular/core';
import {BudgetEntiteAdminAdminService} from 'src/app/shared/service/admin/budget/BudgetEntiteAdminAdmin.service';
import {BudgetEntiteAdminDto} from 'src/app/shared/model/budget/BudgetEntiteAdmin.model';
import {BudgetEntiteAdminCriteria} from 'src/app/shared/criteria/budget/BudgetEntiteAdminCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';


@Component({
  selector: 'app-budget-entite-admin-list-admin',
  templateUrl: './budget-entite-admin-list-admin.component.html'
})
export class BudgetEntiteAdminListAdminComponent extends AbstractListController<BudgetEntiteAdminDto, BudgetEntiteAdminCriteria, BudgetEntiteAdminAdminService>  implements OnInit {

    override fileName = 'BudgetEntiteAdmin';


    entiteAdmins: Array<EntiteAdminDto>;
    budgets: Array<BudgetDto>;


    constructor( private budgetEntiteAdminService: BudgetEntiteAdminAdminService  , private entiteAdminService: EntiteAdminAdminService, private budgetService: BudgetAdminService) {
        super(budgetEntiteAdminService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('BudgetEntiteAdmin').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEntiteAdmin();
                this.loadBudget();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'entiteAdmin?.libelle', header: 'Entite admin'},
            {field: 'montantEntite', header: 'Montant entite'},
            {field: 'montantInvEntite', header: 'Montant inv entite'},
            {field: 'montantFctEntite', header: 'Montant fct entite'},
            {field: 'budget?.id', header: 'Budget'},
        ];
    }


    public async loadEntiteAdmin(){
       this.entiteAdminService.findAllOptimized().subscribe(entiteAdmins => this.entiteAdmins = entiteAdmins, error => console.log(error))
    }
    public async loadBudget(){
       this.budgetService.findAll().subscribe(budgets => this.budgets = budgets, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entite admin': e.entiteAdmin?.libelle ,
                 'Montant entite': e.montantEntite ,
                 'Montant inv entite': e.montantInvEntite ,
                 'Montant fct entite': e.montantFctEntite ,
                'Budget': e.budget?.id ,
            }
        });

        this.criteriaData = [{
        //'Entite admin': this.criteria.entiteAdmin?.libelle ? this.criteria.entiteAdmin?.libelle : environment.emptyForExport ,
            'Montant entite Min': this.criteria.montantEntiteMin ? this.criteria.montantEntiteMin : environment.emptyForExport ,
            'Montant entite Max': this.criteria.montantEntiteMax ? this.criteria.montantEntiteMax : environment.emptyForExport ,
            'Montant inv entite Min': this.criteria.montantInvEntiteMin ? this.criteria.montantInvEntiteMin : environment.emptyForExport ,
            'Montant inv entite Max': this.criteria.montantInvEntiteMax ? this.criteria.montantInvEntiteMax : environment.emptyForExport ,
            'Montant fct entite Min': this.criteria.montantFctEntiteMin ? this.criteria.montantFctEntiteMin : environment.emptyForExport ,
            'Montant fct entite Max': this.criteria.montantFctEntiteMax ? this.criteria.montantFctEntiteMax : environment.emptyForExport ,
        //'Budget': this.criteria.budget?.id ? this.criteria.budget?.id : environment.emptyForExport ,
        }];
      }
}
