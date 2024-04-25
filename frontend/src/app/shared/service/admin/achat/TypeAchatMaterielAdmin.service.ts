import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielCriteria} from 'src/app/shared/criteria/achat/TypeAchatMaterielCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeAchatMaterielAdminService extends AbstractService<TypeAchatMaterielDto, TypeAchatMaterielCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): TypeAchatMaterielDto {
        return new TypeAchatMaterielDto();
    }

    public constrcutCriteria(): TypeAchatMaterielCriteria {
        return new TypeAchatMaterielCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/typeAchatMateriel/';
    }
}
