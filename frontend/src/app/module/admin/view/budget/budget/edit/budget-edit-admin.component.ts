import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetCriteria} from 'src/app/shared/criteria/budget/BudgetCriteria.model';


import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {BudgetEntiteAdminDto} from 'src/app/shared/model/budget/BudgetEntiteAdmin.model';
import {BudgetEntiteAdminAdminService} from 'src/app/shared/service/admin/budget/BudgetEntiteAdminAdmin.service';

@Component({
  selector: 'app-budget-edit-admin',
  templateUrl: './budget-edit-admin.component.html'
})
export class BudgetEditAdminComponent extends AbstractEditController<BudgetDto, BudgetCriteria, BudgetAdminService>   implements OnInit {

    private _budgetEntiteAdminsElement = new BudgetEntiteAdminDto();





    constructor( private budgetService: BudgetAdminService , private entiteAdminService: EntiteAdminAdminService, private budgetEntiteAdminService: BudgetEntiteAdminAdminService) {
        super(budgetService);
    }

    ngOnInit(): void {
        this.budgetEntiteAdminsElement.entiteAdmin = new EntiteAdminDto();
        this.entiteAdminService.findAll().subscribe((data) => this.entiteAdmins = data);

    }
    public override prepareEdit() {
        this.item.dateBudget = this.budgetService.format(this.item.dateBudget);
    }



    public validateBudgetEntiteAdmins(){
        this.errorMessages = new Array();
    }
    public override setValidation(value: boolean){
        }
   public addBudgetEntiteAdmins() {
        if( this.item.budgetEntiteAdmins == null )
            this.item.budgetEntiteAdmins = new Array<BudgetEntiteAdminDto>();
       this.validateBudgetEntiteAdmins();
       if (this.errorMessages.length === 0) {
            if(this.budgetEntiteAdminsElement.id == null){
                this.item.budgetEntiteAdmins.push(this.budgetEntiteAdminsElement);
            }else{
                const index = this.item.budgetEntiteAdmins.findIndex(e => e.id == this.budgetEntiteAdminsElement.id);
                this.item.budgetEntiteAdmins[index] = this.budgetEntiteAdminsElement;
            }
          this.budgetEntiteAdminsElement = new BudgetEntiteAdminDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteBudgetEntiteAdmins(p: BudgetEntiteAdminDto) {
        this.item.budgetEntiteAdmins.forEach((element, index) => {
            if (element === p) { this.item.budgetEntiteAdmins.splice(index, 1); }
        });
    }

    public editBudgetEntiteAdmins(p: BudgetEntiteAdminDto) {
        this.budgetEntiteAdminsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
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

    get budgetEntiteAdminsElement(): BudgetEntiteAdminDto {
        if( this._budgetEntiteAdminsElement == null )
            this._budgetEntiteAdminsElement = new BudgetEntiteAdminDto();
         return this._budgetEntiteAdminsElement;
    }

    set budgetEntiteAdminsElement(value: BudgetEntiteAdminDto) {
        this._budgetEntiteAdminsElement = value;
    }


}
