import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ExpressionBesoinDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoin.model';
import {ExpressionBesoinCriteria} from 'src/app/shared/criteria/expressionbesion/ExpressionBesoinCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ExpressionBesoinAdminService extends AbstractService<ExpressionBesoinDto, ExpressionBesoinCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): ExpressionBesoinDto {
        return new ExpressionBesoinDto();
    }

    public constrcutCriteria(): ExpressionBesoinCriteria {
        return new ExpressionBesoinCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/expressionBesoin/';
    }
}
