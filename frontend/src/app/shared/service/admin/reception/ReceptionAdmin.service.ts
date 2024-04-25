import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionCriteria} from 'src/app/shared/criteria/reception/ReceptionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ReceptionAdminService extends AbstractService<ReceptionDto, ReceptionCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): ReceptionDto {
        return new ReceptionDto();
    }

    public constrcutCriteria(): ReceptionCriteria {
        return new ReceptionCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/reception/';
    }
}
