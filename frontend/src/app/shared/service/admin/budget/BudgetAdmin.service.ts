import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetCriteria} from 'src/app/shared/criteria/budget/BudgetCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BudgetAdminService extends AbstractService<BudgetDto, BudgetCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): BudgetDto {
        return new BudgetDto();
    }

    public constrcutCriteria(): BudgetCriteria {
        return new BudgetCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/budget/';
    }
}
