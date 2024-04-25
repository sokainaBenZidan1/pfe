import {Component, OnInit} from '@angular/core';
import {OperationStockAdminService} from 'src/app/shared/service/admin/stock/OperationStockAdmin.service';
import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockCriteria} from 'src/app/shared/criteria/stock/OperationStockCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailAdminService} from 'src/app/shared/service/admin/stock/OperationStockDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-operation-stock-list-admin',
  templateUrl: './operation-stock-list-admin.component.html'
})
export class OperationStockListAdminComponent extends AbstractListController<OperationStockDto, OperationStockCriteria, OperationStockAdminService>  implements OnInit {

    override fileName = 'OperationStock';


    magasinSources: Array<MagasinDto>;
    magasinDests: Array<MagasinDto>;


    constructor( private operationStockService: OperationStockAdminService  , private magasinService: MagasinAdminService, private operationStockDetailService: OperationStockDetailAdminService, private produitService: ProduitAdminService) {
        super(operationStockService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('OperationStock').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadMagasinSource();
                this.loadMagasinDest();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'dateOS', header: 'Date o s'},
            {field: 'discription', header: 'Discription'},
            {field: 'magasinSource?.id', header: 'Magasin source'},
            {field: 'magasinDest?.id', header: 'Magasin dest'},
        ];
    }


    public async loadMagasinSource(){
       this.magasinService.findAll().subscribe(magasinSources => this.magasinSources = magasinSources, error => console.log(error))
    }
    public async loadMagasinDest(){
       this.magasinService.findAll().subscribe(magasinDests => this.magasinDests = magasinDests, error => console.log(error))
    }

	public override initDuplicate(res: OperationStockDto) {
        if (res.operationStockDetails != null) {
             res.operationStockDetails.forEach(d => { d.operationStock = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                'Date o s': this.datePipe.transform(e.dateOS , 'dd/MM/yyyy hh:mm'),
                 'Discription': e.discription ,
                'Magasin source': e.magasinSource?.id ,
                'Magasin dest': e.magasinDest?.id ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Date o s Min': this.criteria.dateOSFrom ? this.datePipe.transform(this.criteria.dateOSFrom , this.dateFormat) : environment.emptyForExport ,
            'Date o s Max': this.criteria.dateOSTo ? this.datePipe.transform(this.criteria.dateOSTo , this.dateFormat) : environment.emptyForExport ,
            'Discription': this.criteria.discription ? this.criteria.discription : environment.emptyForExport ,
        //'Magasin source': this.criteria.magasinSource?.id ? this.criteria.magasinSource?.id : environment.emptyForExport ,
        //'Magasin dest': this.criteria.magasinDest?.id ? this.criteria.magasinDest?.id : environment.emptyForExport ,
        }];
      }
}
