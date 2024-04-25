import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetCriteria} from 'src/app/shared/criteria/budget/BudgetCriteria.model';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {BudgetEntiteAdminDto} from 'src/app/shared/model/budget/BudgetEntiteAdmin.model';
import {BudgetEntiteAdminAdminService} from 'src/app/shared/service/admin/budget/BudgetEntiteAdminAdmin.service';
@Component({
  selector: 'app-budget-view-admin',
  templateUrl: './budget-view-admin.component.html'
})
export class BudgetViewAdminComponent extends AbstractViewController<BudgetDto, BudgetCriteria, BudgetAdminService> implements OnInit {

    budgetEntiteAdmins = new BudgetEntiteAdminDto();
    budgetEntiteAdminss: Array<BudgetEntiteAdminDto> = [];

    constructor(private budgetService: BudgetAdminService, private entiteAdminService: EntiteAdminAdminService, private budgetEntiteAdminService: BudgetEntiteAdminAdminService){
        super(budgetService);
    }

    ngOnInit(): void {
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


}
