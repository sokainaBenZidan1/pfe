import {Component, OnInit} from '@angular/core';
import {InventaireDetailAdminService} from 'src/app/shared/service/admin/inventaire/InventaireDetailAdmin.service';
import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailCriteria} from 'src/app/shared/criteria/inventaire/InventaireDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireAdminService} from 'src/app/shared/service/admin/inventaire/InventaireAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-inventaire-detail-list-admin',
  templateUrl: './inventaire-detail-list-admin.component.html'
})
export class InventaireDetailListAdminComponent extends AbstractListController<InventaireDetailDto, InventaireDetailCriteria, InventaireDetailAdminService>  implements OnInit {

    override fileName = 'InventaireDetail';


    produits: Array<ProduitDto>;
    inventaires: Array<InventaireDto>;


    constructor( private inventaireDetailService: InventaireDetailAdminService  , private inventaireService: InventaireAdminService, private produitService: ProduitAdminService) {
        super(inventaireDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('InventaireDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadProduit();
                this.loadInventaire();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'qteCalculee', header: 'Qte calculee'},
            {field: 'qteStock', header: 'Qte stock'},
            {field: 'ecart', header: 'Ecart'},
            {field: 'magasin', header: 'Magasin'},
            {field: 'produit?.libelle', header: 'Produit'},
            {field: 'inventaire?.id', header: 'Inventaire'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadInventaire(){
       this.inventaireService.findAll().subscribe(inventaires => this.inventaires = inventaires, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Qte calculee': e.qteCalculee ,
                 'Qte stock': e.qteStock ,
                 'Ecart': e.ecart ,
                 'Magasin': e.magasin ,
                'Produit': e.produit?.libelle ,
                'Inventaire': e.inventaire?.id ,
            }
        });

        this.criteriaData = [{
            'Qte calculee Min': this.criteria.qteCalculeeMin ? this.criteria.qteCalculeeMin : environment.emptyForExport ,
            'Qte calculee Max': this.criteria.qteCalculeeMax ? this.criteria.qteCalculeeMax : environment.emptyForExport ,
            'Qte stock Min': this.criteria.qteStockMin ? this.criteria.qteStockMin : environment.emptyForExport ,
            'Qte stock Max': this.criteria.qteStockMax ? this.criteria.qteStockMax : environment.emptyForExport ,
            'Ecart Min': this.criteria.ecartMin ? this.criteria.ecartMin : environment.emptyForExport ,
            'Ecart Max': this.criteria.ecartMax ? this.criteria.ecartMax : environment.emptyForExport ,
            'Magasin': this.criteria.magasin ? this.criteria.magasin : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        //'Inventaire': this.criteria.inventaire?.id ? this.criteria.inventaire?.id : environment.emptyForExport ,
        }];
      }
}
