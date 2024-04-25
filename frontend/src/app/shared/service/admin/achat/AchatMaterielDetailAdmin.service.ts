import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailCriteria} from 'src/app/shared/criteria/achat/AchatMaterielDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class AchatMaterielDetailAdminService extends AbstractService<AchatMaterielDetailDto, AchatMaterielDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): AchatMaterielDetailDto {
        return new AchatMaterielDetailDto();
    }

    public constrcutCriteria(): AchatMaterielDetailCriteria {
        return new AchatMaterielDetailCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/achatMaterielDetail/';
    }
}
