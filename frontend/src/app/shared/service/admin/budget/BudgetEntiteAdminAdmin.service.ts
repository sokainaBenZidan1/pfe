import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {BudgetEntiteAdminDto} from 'src/app/shared/model/budget/BudgetEntiteAdmin.model';
import {BudgetEntiteAdminCriteria} from 'src/app/shared/criteria/budget/BudgetEntiteAdminCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BudgetEntiteAdminAdminService extends AbstractService<BudgetEntiteAdminDto, BudgetEntiteAdminCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): BudgetEntiteAdminDto {
        return new BudgetEntiteAdminDto();
    }

    public constrcutCriteria(): BudgetEntiteAdminCriteria {
        return new BudgetEntiteAdminCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/budgetEntiteAdmin/';
    }
}
