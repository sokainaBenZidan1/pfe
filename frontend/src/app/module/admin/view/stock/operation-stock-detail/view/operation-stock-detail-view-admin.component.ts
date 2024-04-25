import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {OperationStockDetailAdminService} from 'src/app/shared/service/admin/stock/OperationStockDetailAdmin.service';
import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailCriteria} from 'src/app/shared/criteria/stock/OperationStockDetailCriteria.model';

import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockAdminService} from 'src/app/shared/service/admin/stock/OperationStockAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-operation-stock-detail-view-admin',
  templateUrl: './operation-stock-detail-view-admin.component.html'
})
export class OperationStockDetailViewAdminComponent extends AbstractViewController<OperationStockDetailDto, OperationStockDetailCriteria, OperationStockDetailAdminService> implements OnInit {


    constructor(private operationStockDetailService: OperationStockDetailAdminService, private operationStockService: OperationStockAdminService, private produitService: ProduitAdminService){
        super(operationStockDetailService);
    }

    ngOnInit(): void {
    }


    get produit(): ProduitDto {
       return this.produitService.item;
    }
    set produit(value: ProduitDto) {
        this.produitService.item = value;
    }
    get produits(): Array<ProduitDto> {
       return this.produitService.items;
    }
    set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
    }
    get operationStock(): OperationStockDto {
       return this.operationStockService.item;
    }
    set operationStock(value: OperationStockDto) {
        this.operationStockService.item = value;
    }
    get operationStocks(): Array<OperationStockDto> {
       return this.operationStockService.items;
    }
    set operationStocks(value: Array<OperationStockDto>) {
        this.operationStockService.items = value;
    }


}
