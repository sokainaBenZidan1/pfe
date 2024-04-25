import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {LivraisonDetailDto} from 'src/app/shared/model/livraison/LivraisonDetail.model';
import {LivraisonDetailCriteria} from 'src/app/shared/criteria/livraison/LivraisonDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class LivraisonDetailAdminService extends AbstractService<LivraisonDetailDto, LivraisonDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): LivraisonDetailDto {
        return new LivraisonDetailDto();
    }

    public constrcutCriteria(): LivraisonDetailCriteria {
        return new LivraisonDetailCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/livraisonDetail/';
    }
}
