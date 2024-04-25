import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BudgetEntiteAdminAdminService} from 'src/app/shared/service/admin/budget/BudgetEntiteAdminAdmin.service';
import {BudgetEntiteAdminDto} from 'src/app/shared/model/budget/BudgetEntiteAdmin.model';
import {BudgetEntiteAdminCriteria} from 'src/app/shared/criteria/budget/BudgetEntiteAdminCriteria.model';
import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
@Component({
  selector: 'app-budget-entite-admin-create-admin',
  templateUrl: './budget-entite-admin-create-admin.component.html'
})
export class BudgetEntiteAdminCreateAdminComponent extends AbstractCreateController<BudgetEntiteAdminDto, BudgetEntiteAdminCriteria, BudgetEntiteAdminAdminService>  implements OnInit {



    private _validEntiteAdminCode = true;
    private _validEntiteAdminLibelle = true;

    constructor( private budgetEntiteAdminService: BudgetEntiteAdminAdminService , private entiteAdminService: EntiteAdminAdminService, private budgetService: BudgetAdminService) {
        super(budgetEntiteAdminService);
    }

    ngOnInit(): void {
        this.entiteAdmin = new EntiteAdminDto();
        this.entiteAdminService.findAll().subscribe((data) => this.entiteAdmins = data);
        this.budget = new BudgetDto();
        this.budgetService.findAll().subscribe((data) => this.budgets = data);
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
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

    get entiteAdmin(): EntiteAdminDto {
        return this.entiteAdminService.item;
    }
    set entiteAdmin(value: EntiteAdminDto) {
        this.entiteAdminService.item = value;
    }
    get entiteAdmins(): Array<EntiteAdminDto> {
        return this.entiteAdminService.items;
    }
    set entiteAdmins(value: Array<EntiteAdminDto>) {
        this.entiteAdminService.items = value;
    }
    get createEntiteAdminDialog(): boolean {
       return this.entiteAdminService.createDialog;
    }
    set createEntiteAdminDialog(value: boolean) {
        this.entiteAdminService.createDialog= value;
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




    get validEntiteAdminCode(): boolean {
        return this._validEntiteAdminCode;
    }
    set validEntiteAdminCode(value: boolean) {
        this._validEntiteAdminCode = value;
    }
    get validEntiteAdminLibelle(): boolean {
        return this._validEntiteAdminLibelle;
    }
    set validEntiteAdminLibelle(value: boolean) {
        this._validEntiteAdminLibelle = value;
    }


}
