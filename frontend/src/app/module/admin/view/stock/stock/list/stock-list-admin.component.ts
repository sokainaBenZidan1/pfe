import {Component, OnInit} from '@angular/core';
import {StockAdminService} from 'src/app/shared/service/admin/stock/StockAdmin.service';
import {StockDto} from 'src/app/shared/model/stock/Stock.model';
import {StockCriteria} from 'src/app/shared/criteria/stock/StockCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-stock-list-admin',
  templateUrl: './stock-list-admin.component.html'
})
export class StockListAdminComponent extends AbstractListController<StockDto, StockCriteria, StockAdminService>  implements OnInit {

    override fileName = 'Stock';


    magasins: Array<MagasinDto>;
    produits: Array<ProduitDto>;


    constructor( private stockService: StockAdminService  , private magasinService: MagasinAdminService, private produitService: ProduitAdminService) {
        super(stockService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Stock').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadMagasin();
                this.loadProduit();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'qte', header: 'Qte'},
            {field: 'qteDeffectueuse', header: 'Qte deffectueuse'},
            {field: 'magasin?.id', header: 'Magasin'},
            {field: 'produit?.libelle', header: 'Produit'},
        ];
    }


    public async loadMagasin(){
       this.magasinService.findAll().subscribe(magasins => this.magasins = magasins, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Qte': e.qte ,
                 'Qte deffectueuse': e.qteDeffectueuse ,
                'Magasin': e.magasin?.id ,
                'Produit': e.produit?.libelle ,
            }
        });

        this.criteriaData = [{
            'Qte Min': this.criteria.qteMin ? this.criteria.qteMin : environment.emptyForExport ,
            'Qte Max': this.criteria.qteMax ? this.criteria.qteMax : environment.emptyForExport ,
            'Qte deffectueuse Min': this.criteria.qteDeffectueuseMin ? this.criteria.qteDeffectueuseMin : environment.emptyForExport ,
            'Qte deffectueuse Max': this.criteria.qteDeffectueuseMax ? this.criteria.qteDeffectueuseMax : environment.emptyForExport ,
        //'Magasin': this.criteria.magasin?.id ? this.criteria.magasin?.id : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        }];
      }
}
