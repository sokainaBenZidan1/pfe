import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EtatDto} from 'src/app/shared/model/expressionbesion/Etat.model';
import {EtatCriteria} from 'src/app/shared/criteria/expressionbesion/EtatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatAdminService extends AbstractService<EtatDto, EtatCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EtatDto {
        return new EtatDto();
    }

    public constrcutCriteria(): EtatCriteria {
        return new EtatCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/etat/';
    }
}
