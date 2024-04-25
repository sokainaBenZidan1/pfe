import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitCriteria} from 'src/app/shared/criteria/produit/ProduitCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ProduitAdminService extends AbstractService<ProduitDto, ProduitCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): ProduitDto {
        return new ProduitDto();
    }

    public constrcutCriteria(): ProduitCriteria {
        return new ProduitCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/produit/';
    }
}
