import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ExpressionBesoinDetailAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinDetailAdmin.service';
import {ExpressionBesoinDetailDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoinDetail.model';
import {ExpressionBesoinDetailCriteria} from 'src/app/shared/criteria/expressionbesion/ExpressionBesoinDetailCriteria.model';

import {ExpressionBesoinDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoin.model';
import {ExpressionBesoinAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-expression-besoin-detail-view-admin',
  templateUrl: './expression-besoin-detail-view-admin.component.html'
})
export class ExpressionBesoinDetailViewAdminComponent extends AbstractViewController<ExpressionBesoinDetailDto, ExpressionBesoinDetailCriteria, ExpressionBesoinDetailAdminService> implements OnInit {


    constructor(private expressionBesoinDetailService: ExpressionBesoinDetailAdminService, private expressionBesoinService: ExpressionBesoinAdminService, private produitService: ProduitAdminService){
        super(expressionBesoinDetailService);
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
    get expressionBesoin(): ExpressionBesoinDto {
       return this.expressionBesoinService.item;
    }
    set expressionBesoin(value: ExpressionBesoinDto) {
        this.expressionBesoinService.item = value;
    }
    get expressionBesoins(): Array<ExpressionBesoinDto> {
       return this.expressionBesoinService.items;
    }
    set expressionBesoins(value: Array<ExpressionBesoinDto>) {
        this.expressionBesoinService.items = value;
    }


}
