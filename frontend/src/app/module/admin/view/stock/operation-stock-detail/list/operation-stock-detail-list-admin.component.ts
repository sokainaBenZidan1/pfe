import {Component, OnInit} from '@angular/core';
import {OperationStockDetailAdminService} from 'src/app/shared/service/admin/stock/OperationStockDetailAdmin.service';
import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailCriteria} from 'src/app/shared/criteria/stock/OperationStockDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockAdminService} from 'src/app/shared/service/admin/stock/OperationStockAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-operation-stock-detail-list-admin',
  templateUrl: './operation-stock-detail-list-admin.component.html'
})
export class OperationStockDetailListAdminComponent extends AbstractListController<OperationStockDetailDto, OperationStockDetailCriteria, OperationStockDetailAdminService>  implements OnInit {

    override fileName = 'OperationStockDetail';


    produits: Array<ProduitDto>;
    operationStocks: Array<OperationStockDto>;


    constructor( private operationStockDetailService: OperationStockDetailAdminService  , private operationStockService: OperationStockAdminService, private produitService: ProduitAdminService) {
        super(operationStockDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('OperationStockDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadProduit();
                this.loadOperationStock();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'qte', header: 'Qte'},
            {field: 'produit?.libelle', header: 'Produit'},
            {field: 'operationStock?.ref', header: 'Operation stock'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadOperationStock(){
       this.operationStockService.findAllOptimized().subscribe(operationStocks => this.operationStocks = operationStocks, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Qte': e.qte ,
                'Produit': e.produit?.libelle ,
                'Operation stock': e.operationStock?.ref ,
            }
        });

        this.criteriaData = [{
            'Qte Min': this.criteria.qteMin ? this.criteria.qteMin : environment.emptyForExport ,
            'Qte Max': this.criteria.qteMax ? this.criteria.qteMax : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        //'Operation stock': this.criteria.operationStock?.ref ? this.criteria.operationStock?.ref : environment.emptyForExport ,
        }];
      }
}
