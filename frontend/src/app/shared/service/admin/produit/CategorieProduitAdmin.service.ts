import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategorieProduitDto} from 'src/app/shared/model/produit/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/shared/criteria/produit/CategorieProduitCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategorieProduitAdminService extends AbstractService<CategorieProduitDto, CategorieProduitCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): CategorieProduitDto {
        return new CategorieProduitDto();
    }

    public constrcutCriteria(): CategorieProduitCriteria {
        return new CategorieProduitCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/categorieProduit/';
    }
}
