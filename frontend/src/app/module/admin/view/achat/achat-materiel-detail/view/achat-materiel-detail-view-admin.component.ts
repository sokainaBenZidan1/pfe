import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AchatMaterielDetailAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielDetailAdmin.service';
import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailCriteria} from 'src/app/shared/criteria/achat/AchatMaterielDetailCriteria.model';

import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielAdmin.service';
@Component({
  selector: 'app-achat-materiel-detail-view-admin',
  templateUrl: './achat-materiel-detail-view-admin.component.html'
})
export class AchatMaterielDetailViewAdminComponent extends AbstractViewController<AchatMaterielDetailDto, AchatMaterielDetailCriteria, AchatMaterielDetailAdminService> implements OnInit {


    constructor(private achatMaterielDetailService: AchatMaterielDetailAdminService, private produitService: ProduitAdminService, private achatMaterielService: AchatMaterielAdminService){
        super(achatMaterielDetailService);
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
    get achatMateriel(): AchatMaterielDto {
       return this.achatMaterielService.item;
    }
    set achatMateriel(value: AchatMaterielDto) {
        this.achatMaterielService.item = value;
    }
    get achatMateriels(): Array<AchatMaterielDto> {
       return this.achatMaterielService.items;
    }
    set achatMateriels(value: Array<AchatMaterielDto>) {
        this.achatMaterielService.items = value;
    }


}
