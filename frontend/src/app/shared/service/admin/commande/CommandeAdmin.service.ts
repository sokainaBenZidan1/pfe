import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeCriteria} from 'src/app/shared/criteria/commande/CommandeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CommandeAdminService extends AbstractService<CommandeDto, CommandeCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): CommandeDto {
        return new CommandeDto();
    }

    public constrcutCriteria(): CommandeCriteria {
        return new CommandeCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/commande/';
    }
}
