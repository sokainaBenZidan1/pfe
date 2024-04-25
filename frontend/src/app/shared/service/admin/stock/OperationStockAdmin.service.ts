import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockCriteria} from 'src/app/shared/criteria/stock/OperationStockCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class OperationStockAdminService extends AbstractService<OperationStockDto, OperationStockCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): OperationStockDto {
        return new OperationStockDto();
    }

    public constrcutCriteria(): OperationStockCriteria {
        return new OperationStockCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/operationStock/';
    }
}
