import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireCriteria} from 'src/app/shared/criteria/inventaire/InventaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InventaireAdminService extends AbstractService<InventaireDto, InventaireCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): InventaireDto {
        return new InventaireDto();
    }

    public constrcutCriteria(): InventaireCriteria {
        return new InventaireCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/inventaire/';
    }
}
