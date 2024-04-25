import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {OperationStockAdminService} from 'src/app/shared/service/admin/stock/OperationStockAdmin.service';
import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockCriteria} from 'src/app/shared/criteria/stock/OperationStockCriteria.model';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailAdminService} from 'src/app/shared/service/admin/stock/OperationStockDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-operation-stock-view-admin',
  templateUrl: './operation-stock-view-admin.component.html'
})
export class OperationStockViewAdminComponent extends AbstractViewController<OperationStockDto, OperationStockCriteria, OperationStockAdminService> implements OnInit {

    operationStockDetails = new OperationStockDetailDto();
    operationStockDetailss: Array<OperationStockDetailDto> = [];

    constructor(private operationStockService: OperationStockAdminService, private magasinService: MagasinAdminService, private operationStockDetailService: OperationStockDetailAdminService, private produitService: ProduitAdminService){
        super(operationStockService);
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
    get magasinDest(): MagasinDto {
       return this.magasinService.item;
    }
    set magasinDest(value: MagasinDto) {
        this.magasinService.item = value;
    }
    get magasinDests(): Array<MagasinDto> {
       return this.magasinService.items;
    }
    set magasinDests(value: Array<MagasinDto>) {
        this.magasinService.items = value;
    }
    get magasinSource(): MagasinDto {
       return this.magasinService.item;
    }
    set magasinSource(value: MagasinDto) {
        this.magasinService.item = value;
    }
    get magasinSources(): Array<MagasinDto> {
       return this.magasinService.items;
    }
    set magasinSources(value: Array<MagasinDto>) {
        this.magasinService.items = value;
    }


}
