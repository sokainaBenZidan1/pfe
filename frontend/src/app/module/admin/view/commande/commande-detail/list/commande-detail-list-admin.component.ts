import {Component, OnInit} from '@angular/core';
import {CommandeDetailAdminService} from 'src/app/shared/service/admin/commande/CommandeDetailAdmin.service';
import {CommandeDetailDto} from 'src/app/shared/model/commande/CommandeDetail.model';
import {CommandeDetailCriteria} from 'src/app/shared/criteria/commande/CommandeDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-commande-detail-list-admin',
  templateUrl: './commande-detail-list-admin.component.html'
})
export class CommandeDetailListAdminComponent extends AbstractListController<CommandeDetailDto, CommandeDetailCriteria, CommandeDetailAdminService>  implements OnInit {

    override fileName = 'CommandeDetail';


    commandes: Array<CommandeDto>;
    produits: Array<ProduitDto>;


    constructor( private commandeDetailService: CommandeDetailAdminService  , private commandeService: CommandeAdminService, private produitService: ProduitAdminService) {
        super(commandeDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CommandeDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCommande();
                this.loadProduit();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'prix', header: 'Prix'},
            {field: 'qte', header: 'Qte'},
            {field: 'commande?.ref', header: 'Commande'},
            {field: 'produit?.libelle', header: 'Produit'},
        ];
    }


    public async loadCommande(){
       this.commandeService.findAllOptimized().subscribe(commandes => this.commandes = commandes, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Prix': e.prix ,
                 'Qte': e.qte ,
                'Commande': e.commande?.ref ,
                'Produit': e.produit?.libelle ,
            }
        });

        this.criteriaData = [{
            'Prix Min': this.criteria.prixMin ? this.criteria.prixMin : environment.emptyForExport ,
            'Prix Max': this.criteria.prixMax ? this.criteria.prixMax : environment.emptyForExport ,
            'Qte Min': this.criteria.qteMin ? this.criteria.qteMin : environment.emptyForExport ,
            'Qte Max': this.criteria.qteMax ? this.criteria.qteMax : environment.emptyForExport ,
        //'Commande': this.criteria.commande?.ref ? this.criteria.commande?.ref : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        }];
      }
}
