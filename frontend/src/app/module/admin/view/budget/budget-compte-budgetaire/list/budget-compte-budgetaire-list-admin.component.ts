import {Component, OnInit} from '@angular/core';
import {BudgetCompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/BudgetCompteBudgetaireAdmin.service';
import {BudgetCompteBudgetaireDto} from 'src/app/shared/model/budget/BudgetCompteBudgetaire.model';
import {BudgetCompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/BudgetCompteBudgetaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';


@Component({
  selector: 'app-budget-compte-budgetaire-list-admin',
  templateUrl: './budget-compte-budgetaire-list-admin.component.html'
})
export class BudgetCompteBudgetaireListAdminComponent extends AbstractListController<BudgetCompteBudgetaireDto, BudgetCompteBudgetaireCriteria, BudgetCompteBudgetaireAdminService>  implements OnInit {

    override fileName = 'BudgetCompteBudgetaire';


    budgets: Array<BudgetDto>;
    compteBudgetaires: Array<CompteBudgetaireDto>;


    constructor( private budgetCompteBudgetaireService: BudgetCompteBudgetaireAdminService  , private budgetService: BudgetAdminService, private compteBudgetaireService: CompteBudgetaireAdminService) {
        super(budgetCompteBudgetaireService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('BudgetCompteBudgetaire').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadBudget();
                this.loadCompteBudgetaire();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'budget?.id', header: 'Budget'},
            {field: 'compteBudgetaire?.libelle', header: 'Compte budgetaire'},
            {field: 'montant', header: 'Montant'},
        ];
    }


    public async loadBudget(){
       this.budgetService.findAll().subscribe(budgets => this.budgets = budgets, error => console.log(error))
    }
    public async loadCompteBudgetaire(){
       this.compteBudgetaireService.findAllOptimized().subscribe(compteBudgetaires => this.compteBudgetaires = compteBudgetaires, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Budget': e.budget?.id ,
                'Compte budgetaire': e.compteBudgetaire?.libelle ,
                 'Montant': e.montant ,
            }
        });

        this.criteriaData = [{
        //'Budget': this.criteria.budget?.id ? this.criteria.budget?.id : environment.emptyForExport ,
        //'Compte budgetaire': this.criteria.compteBudgetaire?.libelle ? this.criteria.compteBudgetaire?.libelle : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        }];
      }
}
