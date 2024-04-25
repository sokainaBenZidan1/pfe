import {Component, OnInit} from '@angular/core';
import {AchatMaterielDetailAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielDetailAdmin.service';
import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailCriteria} from 'src/app/shared/criteria/achat/AchatMaterielDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielAdmin.service';


@Component({
  selector: 'app-achat-materiel-detail-list-admin',
  templateUrl: './achat-materiel-detail-list-admin.component.html'
})
export class AchatMaterielDetailListAdminComponent extends AbstractListController<AchatMaterielDetailDto, AchatMaterielDetailCriteria, AchatMaterielDetailAdminService>  implements OnInit {

    override fileName = 'AchatMaterielDetail';


    produits: Array<ProduitDto>;
    achatMateriels: Array<AchatMaterielDto>;


    constructor( private achatMaterielDetailService: AchatMaterielDetailAdminService  , private produitService: ProduitAdminService, private achatMaterielService: AchatMaterielAdminService) {
        super(achatMaterielDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('AchatMaterielDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadProduit();
                this.loadAchatMateriel();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'produit?.libelle', header: 'Produit'},
            {field: 'qteAchetee', header: 'Qte achetee'},
            {field: 'qteRecue', header: 'Qte recue'},
            {field: 'qteLivree', header: 'Qte livree'},
            {field: 'achatMateriel?.id', header: 'Achat materiel'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadAchatMateriel(){
       this.achatMaterielService.findAll().subscribe(achatMateriels => this.achatMateriels = achatMateriels, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.libelle ,
                 'Qte achetee': e.qteAchetee ,
                 'Qte recue': e.qteRecue ,
                 'Qte livree': e.qteLivree ,
                'Achat materiel': e.achatMateriel?.id ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
            'Qte achetee Min': this.criteria.qteAcheteeMin ? this.criteria.qteAcheteeMin : environment.emptyForExport ,
            'Qte achetee Max': this.criteria.qteAcheteeMax ? this.criteria.qteAcheteeMax : environment.emptyForExport ,
            'Qte recue Min': this.criteria.qteRecueMin ? this.criteria.qteRecueMin : environment.emptyForExport ,
            'Qte recue Max': this.criteria.qteRecueMax ? this.criteria.qteRecueMax : environment.emptyForExport ,
            'Qte livree Min': this.criteria.qteLivreeMin ? this.criteria.qteLivreeMin : environment.emptyForExport ,
            'Qte livree Max': this.criteria.qteLivreeMax ? this.criteria.qteLivreeMax : environment.emptyForExport ,
        //'Achat materiel': this.criteria.achatMateriel?.id ? this.criteria.achatMateriel?.id : environment.emptyForExport ,
        }];
      }
}
