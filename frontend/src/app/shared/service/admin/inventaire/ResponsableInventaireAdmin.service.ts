import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireCriteria} from 'src/app/shared/criteria/inventaire/ResponsableInventaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ResponsableInventaireAdminService extends AbstractService<ResponsableInventaireDto, ResponsableInventaireCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): ResponsableInventaireDto {
        return new ResponsableInventaireDto();
    }

    public constrcutCriteria(): ResponsableInventaireCriteria {
        return new ResponsableInventaireCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/responsableInventaire/';
    }
}
