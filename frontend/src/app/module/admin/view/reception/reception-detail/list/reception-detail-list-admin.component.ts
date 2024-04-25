import {Component, OnInit} from '@angular/core';
import {ReceptionDetailAdminService} from 'src/app/shared/service/admin/reception/ReceptionDetailAdmin.service';
import {ReceptionDetailDto} from 'src/app/shared/model/reception/ReceptionDetail.model';
import {ReceptionDetailCriteria} from 'src/app/shared/criteria/reception/ReceptionDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-reception-detail-list-admin',
  templateUrl: './reception-detail-list-admin.component.html'
})
export class ReceptionDetailListAdminComponent extends AbstractListController<ReceptionDetailDto, ReceptionDetailCriteria, ReceptionDetailAdminService>  implements OnInit {

    override fileName = 'ReceptionDetail';


    magasins: Array<MagasinDto>;
    produits: Array<ProduitDto>;
    receptions: Array<ReceptionDto>;


    constructor( private receptionDetailService: ReceptionDetailAdminService  , private magasinService: MagasinAdminService, private receptionService: ReceptionAdminService, private produitService: ProduitAdminService) {
        super(receptionDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('ReceptionDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadMagasin();
                this.loadProduit();
                this.loadReception();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'qte', header: 'Qte'},
            {field: 'magasin?.id', header: 'Magasin'},
            {field: 'produit?.libelle', header: 'Produit'},
            {field: 'reception?.ref', header: 'Reception'},
        ];
    }


    public async loadMagasin(){
       this.magasinService.findAll().subscribe(magasins => this.magasins = magasins, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadReception(){
       this.receptionService.findAllOptimized().subscribe(receptions => this.receptions = receptions, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Qte': e.qte ,
                'Magasin': e.magasin?.id ,
                'Produit': e.produit?.libelle ,
                'Reception': e.reception?.ref ,
            }
        });

        this.criteriaData = [{
            'Qte Min': this.criteria.qteMin ? this.criteria.qteMin : environment.emptyForExport ,
            'Qte Max': this.criteria.qteMax ? this.criteria.qteMax : environment.emptyForExport ,
        //'Magasin': this.criteria.magasin?.id ? this.criteria.magasin?.id : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        //'Reception': this.criteria.reception?.ref ? this.criteria.reception?.ref : environment.emptyForExport ,
        }];
      }
}
