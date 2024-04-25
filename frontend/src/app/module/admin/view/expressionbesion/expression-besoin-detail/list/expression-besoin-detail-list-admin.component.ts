import {Component, OnInit} from '@angular/core';
import {ExpressionBesoinDetailAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinDetailAdmin.service';
import {ExpressionBesoinDetailDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoinDetail.model';
import {ExpressionBesoinDetailCriteria} from 'src/app/shared/criteria/expressionbesion/ExpressionBesoinDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ExpressionBesoinDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoin.model';
import {ExpressionBesoinAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-expression-besoin-detail-list-admin',
  templateUrl: './expression-besoin-detail-list-admin.component.html'
})
export class ExpressionBesoinDetailListAdminComponent extends AbstractListController<ExpressionBesoinDetailDto, ExpressionBesoinDetailCriteria, ExpressionBesoinDetailAdminService>  implements OnInit {

    override fileName = 'ExpressionBesoinDetail';


    expressionBesoins: Array<ExpressionBesoinDto>;
    produits: Array<ProduitDto>;


    constructor( private expressionBesoinDetailService: ExpressionBesoinDetailAdminService  , private expressionBesoinService: ExpressionBesoinAdminService, private produitService: ProduitAdminService) {
        super(expressionBesoinDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('ExpressionBesoinDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadExpressionBesoin();
                this.loadProduit();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'qteDemandee', header: 'Qte demandee'},
            {field: 'qteAccordee', header: 'Qte accordee'},
            {field: 'qteLivre', header: 'Qte livre'},
            {field: 'expressionBesoin?.id', header: 'Expression besoin'},
            {field: 'produit?.libelle', header: 'Produit'},
        ];
    }


    public async loadExpressionBesoin(){
       this.expressionBesoinService.findAll().subscribe(expressionBesoins => this.expressionBesoins = expressionBesoins, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Qte demandee': e.qteDemandee ,
                 'Qte accordee': e.qteAccordee ,
                 'Qte livre': e.qteLivre ,
                'Expression besoin': e.expressionBesoin?.id ,
                'Produit': e.produit?.libelle ,
            }
        });

        this.criteriaData = [{
            'Qte demandee Min': this.criteria.qteDemandeeMin ? this.criteria.qteDemandeeMin : environment.emptyForExport ,
            'Qte demandee Max': this.criteria.qteDemandeeMax ? this.criteria.qteDemandeeMax : environment.emptyForExport ,
            'Qte accordee Min': this.criteria.qteAccordeeMin ? this.criteria.qteAccordeeMin : environment.emptyForExport ,
            'Qte accordee Max': this.criteria.qteAccordeeMax ? this.criteria.qteAccordeeMax : environment.emptyForExport ,
            'Qte livre Min': this.criteria.qteLivreMin ? this.criteria.qteLivreMin : environment.emptyForExport ,
            'Qte livre Max': this.criteria.qteLivreMax ? this.criteria.qteLivreMax : environment.emptyForExport ,
        //'Expression besoin': this.criteria.expressionBesoin?.id ? this.criteria.expressionBesoin?.id : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        }];
      }
}
