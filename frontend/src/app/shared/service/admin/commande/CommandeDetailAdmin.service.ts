import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CommandeDetailDto} from 'src/app/shared/model/commande/CommandeDetail.model';
import {CommandeDetailCriteria} from 'src/app/shared/criteria/commande/CommandeDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CommandeDetailAdminService extends AbstractService<CommandeDetailDto, CommandeDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): CommandeDetailDto {
        return new CommandeDetailDto();
    }

    public constrcutCriteria(): CommandeDetailCriteria {
        return new CommandeDetailCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/commandeDetail/';
    }
}
