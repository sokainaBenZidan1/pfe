import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailCriteria} from 'src/app/shared/criteria/stock/OperationStockDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class OperationStockDetailAdminService extends AbstractService<OperationStockDetailDto, OperationStockDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): OperationStockDetailDto {
        return new OperationStockDetailDto();
    }

    public constrcutCriteria(): OperationStockDetailCriteria {
        return new OperationStockDetailCriteria();
    }

    get API() {
        return environment.apiUrlStockyservice + 'admin/operationStockDetail/';
    }
}
