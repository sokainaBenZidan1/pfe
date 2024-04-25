import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {StockDto} from 'src/app/shared/model/stock/Stock.model';
import {StockCriteria} from 'src/app/shared/criteria/stock/StockCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class StockAdminService extends AbstractService<StockDto, StockCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): StockDto {
        return new StockDto();
    }

    public constrcutCriteria(): StockCriteria {
        return new StockCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/stock/';
    }
}
