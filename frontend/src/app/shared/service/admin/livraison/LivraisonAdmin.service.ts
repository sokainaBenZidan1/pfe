import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {LivraisonDto} from 'src/app/shared/model/livraison/Livraison.model';
import {LivraisonCriteria} from 'src/app/shared/criteria/livraison/LivraisonCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class LivraisonAdminService extends AbstractService<LivraisonDto, LivraisonCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): LivraisonDto {
        return new LivraisonDto();
    }

    public constrcutCriteria(): LivraisonCriteria {
        return new LivraisonCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/livraison/';
    }
}
