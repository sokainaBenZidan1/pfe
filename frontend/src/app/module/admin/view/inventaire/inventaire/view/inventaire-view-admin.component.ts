import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InventaireAdminService} from 'src/app/shared/service/admin/inventaire/InventaireAdmin.service';
import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireCriteria} from 'src/app/shared/criteria/inventaire/InventaireCriteria.model';

import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireAdminService} from 'src/app/shared/service/admin/inventaire/ResponsableInventaireAdmin.service';
import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailAdminService} from 'src/app/shared/service/admin/inventaire/InventaireDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-inventaire-view-admin',
  templateUrl: './inventaire-view-admin.component.html'
})
export class InventaireViewAdminComponent extends AbstractViewController<InventaireDto, InventaireCriteria, InventaireAdminService> implements OnInit {

    inventaireDetails = new InventaireDetailDto();
    inventaireDetailss: Array<InventaireDetailDto> = [];

    constructor(private inventaireService: InventaireAdminService, private responsableInventaireService: ResponsableInventaireAdminService, private inventaireDetailService: InventaireDetailAdminService, private produitService: ProduitAdminService){
        super(inventaireService);
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
    get responsableInv(): ResponsableInventaireDto {
       return this.responsableInventaireService.item;
    }
    set responsableInv(value: ResponsableInventaireDto) {
        this.responsableInventaireService.item = value;
    }
    get responsableInvs(): Array<ResponsableInventaireDto> {
       return this.responsableInventaireService.items;
    }
    set responsableInvs(value: Array<ResponsableInventaireDto>) {
        this.responsableInventaireService.items = value;
    }


}
