import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BudgetCompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/BudgetCompteBudgetaireAdmin.service';
import {BudgetCompteBudgetaireDto} from 'src/app/shared/model/budget/BudgetCompteBudgetaire.model';
import {BudgetCompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/BudgetCompteBudgetaireCriteria.model';

import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';
@Component({
  selector: 'app-budget-compte-budgetaire-view-admin',
  templateUrl: './budget-compte-budgetaire-view-admin.component.html'
})
export class BudgetCompteBudgetaireViewAdminComponent extends AbstractViewController<BudgetCompteBudgetaireDto, BudgetCompteBudgetaireCriteria, BudgetCompteBudgetaireAdminService> implements OnInit {


    constructor(private budgetCompteBudgetaireService: BudgetCompteBudgetaireAdminService, private budgetService: BudgetAdminService, private compteBudgetaireService: CompteBudgetaireAdminService){
        super(budgetCompteBudgetaireService);
    }

    ngOnInit(): void {
    }


    get compteBudgetaire(): CompteBudgetaireDto {
       return this.compteBudgetaireService.item;
    }
    set compteBudgetaire(value: CompteBudgetaireDto) {
        this.compteBudgetaireService.item = value;
    }
    get compteBudgetaires(): Array<CompteBudgetaireDto> {
       return this.compteBudgetaireService.items;
    }
    set compteBudgetaires(value: Array<CompteBudgetaireDto>) {
        this.compteBudgetaireService.items = value;
    }
    get budget(): BudgetDto {
       return this.budgetService.item;
    }
    set budget(value: BudgetDto) {
        this.budgetService.item = value;
    }
    get budgets(): Array<BudgetDto> {
       return this.budgetService.items;
    }
    set budgets(value: Array<BudgetDto>) {
        this.budgetService.items = value;
    }


}
