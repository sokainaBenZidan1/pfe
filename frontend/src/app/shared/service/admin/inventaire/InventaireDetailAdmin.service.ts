import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailCriteria} from 'src/app/shared/criteria/inventaire/InventaireDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InventaireDetailAdminService extends AbstractService<InventaireDetailDto, InventaireDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): InventaireDetailDto {
        return new InventaireDetailDto();
    }

    public constrcutCriteria(): InventaireDetailCriteria {
        return new InventaireDetailCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/inventaireDetail/';
    }
}
