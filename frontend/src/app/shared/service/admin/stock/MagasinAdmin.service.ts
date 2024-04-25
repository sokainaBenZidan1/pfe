import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinCriteria} from 'src/app/shared/criteria/stock/MagasinCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class MagasinAdminService extends AbstractService<MagasinDto, MagasinCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): MagasinDto {
        return new MagasinDto();
    }

    public constrcutCriteria(): MagasinCriteria {
        return new MagasinCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/magasin/';
    }
}
