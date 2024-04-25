import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {BudgetCompteBudgetaireDto} from 'src/app/shared/model/budget/BudgetCompteBudgetaire.model';
import {BudgetCompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/BudgetCompteBudgetaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BudgetCompteBudgetaireAdminService extends AbstractService<BudgetCompteBudgetaireDto, BudgetCompteBudgetaireCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): BudgetCompteBudgetaireDto {
        return new BudgetCompteBudgetaireDto();
    }

    public constrcutCriteria(): BudgetCompteBudgetaireCriteria {
        return new BudgetCompteBudgetaireCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/budgetCompteBudgetaire/';
    }
}
