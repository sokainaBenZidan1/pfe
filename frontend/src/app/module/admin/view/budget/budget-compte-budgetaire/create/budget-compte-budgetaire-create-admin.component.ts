import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BudgetCompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/BudgetCompteBudgetaireAdmin.service';
import {BudgetCompteBudgetaireDto} from 'src/app/shared/model/budget/BudgetCompteBudgetaire.model';
import {BudgetCompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/BudgetCompteBudgetaireCriteria.model';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';
@Component({
  selector: 'app-budget-compte-budgetaire-create-admin',
  templateUrl: './budget-compte-budgetaire-create-admin.component.html'
})
export class BudgetCompteBudgetaireCreateAdminComponent extends AbstractCreateController<BudgetCompteBudgetaireDto, BudgetCompteBudgetaireCriteria, BudgetCompteBudgetaireAdminService>  implements OnInit {



    private _validCompteBudgetaireLibelle = true;
    private _validCompteBudgetaireCode = true;

    constructor( private budgetCompteBudgetaireService: BudgetCompteBudgetaireAdminService , private budgetService: BudgetAdminService, private compteBudgetaireService: CompteBudgetaireAdminService) {
        super(budgetCompteBudgetaireService);
    }

    ngOnInit(): void {
        this.budget = new BudgetDto();
        this.budgetService.findAll().subscribe((data) => this.budgets = data);
        this.compteBudgetaire = new CompteBudgetaireDto();
        this.compteBudgetaireService.findAll().subscribe((data) => this.compteBudgetaires = data);
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateCompteBudgetaire(compteBudgetaire: string) {
    const isPermistted = await this.roleService.isPermitted('CompteBudgetaire', 'add');
    if(isPermistted) {
         this.compteBudgetaire = new CompteBudgetaireDto();
         this.createCompteBudgetaireDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateBudget(budget: string) {
    const isPermistted = await this.roleService.isPermitted('Budget', 'add');
    if(isPermistted) {
         this.budget = new BudgetDto();
         this.createBudgetDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createCompteBudgetaireDialog(): boolean {
       return this.compteBudgetaireService.createDialog;
    }
    set createCompteBudgetaireDialog(value: boolean) {
        this.compteBudgetaireService.createDialog= value;
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
    get createBudgetDialog(): boolean {
       return this.budgetService.createDialog;
    }
    set createBudgetDialog(value: boolean) {
        this.budgetService.createDialog= value;
    }




    get validCompteBudgetaireLibelle(): boolean {
        return this._validCompteBudgetaireLibelle;
    }
    set validCompteBudgetaireLibelle(value: boolean) {
        this._validCompteBudgetaireLibelle = value;
    }
    get validCompteBudgetaireCode(): boolean {
        return this._validCompteBudgetaireCode;
    }
    set validCompteBudgetaireCode(value: boolean) {
        this._validCompteBudgetaireCode = value;
    }


}
