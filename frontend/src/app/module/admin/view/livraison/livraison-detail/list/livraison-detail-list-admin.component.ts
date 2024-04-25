import {Component, OnInit} from '@angular/core';
import {LivraisonDetailAdminService} from 'src/app/shared/service/admin/livraison/LivraisonDetailAdmin.service';
import {LivraisonDetailDto} from 'src/app/shared/model/livraison/LivraisonDetail.model';
import {LivraisonDetailCriteria} from 'src/app/shared/criteria/livraison/LivraisonDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {LivraisonDto} from 'src/app/shared/model/livraison/Livraison.model';
import {LivraisonAdminService} from 'src/app/shared/service/admin/livraison/LivraisonAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-livraison-detail-list-admin',
  templateUrl: './livraison-detail-list-admin.component.html'
})
export class LivraisonDetailListAdminComponent extends AbstractListController<LivraisonDetailDto, LivraisonDetailCriteria, LivraisonDetailAdminService>  implements OnInit {

    override fileName = 'LivraisonDetail';


    magasins: Array<MagasinDto>;
    produits: Array<ProduitDto>;
    livraisons: Array<LivraisonDto>;


    constructor( private livraisonDetailService: LivraisonDetailAdminService  , private magasinService: MagasinAdminService, private livraisonService: LivraisonAdminService, private produitService: ProduitAdminService) {
        super(livraisonDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('LivraisonDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadMagasin();
                this.loadProduit();
                this.loadLivraison();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'qte', header: 'Qte'},
            {field: 'magasin?.id', header: 'Magasin'},
            {field: 'produit?.libelle', header: 'Produit'},
            {field: 'livraison?.ref', header: 'Livraison'},
        ];
    }


    public async loadMagasin(){
       this.magasinService.findAll().subscribe(magasins => this.magasins = magasins, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadLivraison(){
       this.livraisonService.findAllOptimized().subscribe(livraisons => this.livraisons = livraisons, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Qte': e.qte ,
                'Magasin': e.magasin?.id ,
                'Produit': e.produit?.libelle ,
                'Livraison': e.livraison?.ref ,
            }
        });

        this.criteriaData = [{
            'Qte Min': this.criteria.qteMin ? this.criteria.qteMin : environment.emptyForExport ,
            'Qte Max': this.criteria.qteMax ? this.criteria.qteMax : environment.emptyForExport ,
        //'Magasin': this.criteria.magasin?.id ? this.criteria.magasin?.id : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        //'Livraison': this.criteria.livraison?.ref ? this.criteria.livraison?.ref : environment.emptyForExport ,
        }];
      }
}
