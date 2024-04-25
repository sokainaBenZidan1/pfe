import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielCriteria} from 'src/app/shared/criteria/achat/AchatMaterielCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class AchatMaterielAdminService extends AbstractService<AchatMaterielDto, AchatMaterielCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): AchatMaterielDto {
        return new AchatMaterielDto();
    }

    public constrcutCriteria(): AchatMaterielCriteria {
        return new AchatMaterielCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/achatMateriel/';
    }
}
