import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/CompteBudgetaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CompteBudgetaireAdminService extends AbstractService<CompteBudgetaireDto, CompteBudgetaireCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): CompteBudgetaireDto {
        return new CompteBudgetaireDto();
    }

    public constrcutCriteria(): CompteBudgetaireCriteria {
        return new CompteBudgetaireCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/compteBudgetaire/';
    }
}
