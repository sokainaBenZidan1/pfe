import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {MandatDto} from 'src/app/shared/model/mandat/Mandat.model';
import {MandatCriteria} from 'src/app/shared/criteria/mandat/MandatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class MandatAdminService extends AbstractService<MandatDto, MandatCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): MandatDto {
        return new MandatDto();
    }

    public constrcutCriteria(): MandatCriteria {
        return new MandatCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/mandat/';
    }
}
