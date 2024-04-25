import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminCriteria} from 'src/app/shared/criteria/commun/EntiteAdminCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EntiteAdminAdminService extends AbstractService<EntiteAdminDto, EntiteAdminCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EntiteAdminDto {
        return new EntiteAdminDto();
    }

    public constrcutCriteria(): EntiteAdminCriteria {
        return new EntiteAdminCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/entiteAdmin/';
    }
}
