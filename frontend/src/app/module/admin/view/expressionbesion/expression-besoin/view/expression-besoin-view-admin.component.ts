import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ExpressionBesoinAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinAdmin.service';
import {ExpressionBesoinDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoin.model';
import {ExpressionBesoinCriteria} from 'src/app/shared/criteria/expressionbesion/ExpressionBesoinCriteria.model';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {EtatDto} from 'src/app/shared/model/expressionbesion/Etat.model';
import {EtatAdminService} from 'src/app/shared/service/admin/expressionbesion/EtatAdmin.service';
import {ExpressionBesoinDetailDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoinDetail.model';
import {ExpressionBesoinDetailAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinDetailAdmin.service';
import {EmployeDto} from 'src/app/shared/model/commun/Employe.model';
import {EmployeAdminService} from 'src/app/shared/service/admin/commun/EmployeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-expression-besoin-view-admin',
  templateUrl: './expression-besoin-view-admin.component.html'
})
export class ExpressionBesoinViewAdminComponent extends AbstractViewController<ExpressionBesoinDto, ExpressionBesoinCriteria, ExpressionBesoinAdminService> implements OnInit {

    expressionBesoinDetails = new ExpressionBesoinDetailDto();
    expressionBesoinDetailss: Array<ExpressionBesoinDetailDto> = [];

    constructor(private expressionBesoinService: ExpressionBesoinAdminService, private entiteAdminService: EntiteAdminAdminService, private etatService: EtatAdminService, private expressionBesoinDetailService: ExpressionBesoinDetailAdminService, private employeService: EmployeAdminService, private produitService: ProduitAdminService){
        super(expressionBesoinService);
    }

    ngOnInit(): void {
    }


    get entiteAdmin(): EntiteAdminDto {
       return this.entiteAdminService.item;
    }
    set entiteAdmin(value: EntiteAdminDto) {
        this.entiteAdminService.item = value;
    }
    get entiteAdmins(): Array<EntiteAdminDto> {
       return this.entiteAdminService.items;
    }
    set entiteAdmins(value: Array<EntiteAdminDto>) {
        this.entiteAdminService.items = value;
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
    get etat(): EtatDto {
       return this.etatService.item;
    }
    set etat(value: EtatDto) {
        this.etatService.item = value;
    }
    get etats(): Array<EtatDto> {
       return this.etatService.items;
    }
    set etats(value: Array<EtatDto>) {
        this.etatService.items = value;
    }
    get employe(): EmployeDto {
       return this.employeService.item;
    }
    set employe(value: EmployeDto) {
        this.employeService.item = value;
    }
    get employes(): Array<EmployeDto> {
       return this.employeService.items;
    }
    set employes(value: Array<EmployeDto>) {
        this.employeService.items = value;
    }


}
