import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReceptionDetailAdminService} from 'src/app/shared/service/admin/reception/ReceptionDetailAdmin.service';
import {ReceptionDetailDto} from 'src/app/shared/model/reception/ReceptionDetail.model';
import {ReceptionDetailCriteria} from 'src/app/shared/criteria/reception/ReceptionDetailCriteria.model';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-reception-detail-view-admin',
  templateUrl: './reception-detail-view-admin.component.html'
})
export class ReceptionDetailViewAdminComponent extends AbstractViewController<ReceptionDetailDto, ReceptionDetailCriteria, ReceptionDetailAdminService> implements OnInit {


    constructor(private receptionDetailService: ReceptionDetailAdminService, private magasinService: MagasinAdminService, private receptionService: ReceptionAdminService, private produitService: ProduitAdminService){
        super(receptionDetailService);
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
    get reception(): ReceptionDto {
       return this.receptionService.item;
    }
    set reception(value: ReceptionDto) {
        this.receptionService.item = value;
    }
    get receptions(): Array<ReceptionDto> {
       return this.receptionService.items;
    }
    set receptions(value: Array<ReceptionDto>) {
        this.receptionService.items = value;
    }
    get magasin(): MagasinDto {
       return this.magasinService.item;
    }
    set magasin(value: MagasinDto) {
        this.magasinService.item = value;
    }
    get magasins(): Array<MagasinDto> {
       return this.magasinService.items;
    }
    set magasins(value: Array<MagasinDto>) {
        this.magasinService.items = value;
    }


}
