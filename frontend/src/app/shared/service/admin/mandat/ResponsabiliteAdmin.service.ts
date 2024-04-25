import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ResponsabiliteDto} from 'src/app/shared/model/mandat/Responsabilite.model';
import {ResponsabiliteCriteria} from 'src/app/shared/criteria/mandat/ResponsabiliteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ResponsabiliteAdminService extends AbstractService<ResponsabiliteDto, ResponsabiliteCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): ResponsabiliteDto {
        return new ResponsabiliteDto();
    }

    public constrcutCriteria(): ResponsabiliteCriteria {
        return new ResponsabiliteCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/responsabilite/';
    }
}
