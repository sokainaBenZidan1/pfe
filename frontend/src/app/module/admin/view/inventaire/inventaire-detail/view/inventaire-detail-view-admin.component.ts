import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InventaireDetailAdminService} from 'src/app/shared/service/admin/inventaire/InventaireDetailAdmin.service';
import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailCriteria} from 'src/app/shared/criteria/inventaire/InventaireDetailCriteria.model';

import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireAdminService} from 'src/app/shared/service/admin/inventaire/InventaireAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-inventaire-detail-view-admin',
  templateUrl: './inventaire-detail-view-admin.component.html'
})
export class InventaireDetailViewAdminComponent extends AbstractViewController<InventaireDetailDto, InventaireDetailCriteria, InventaireDetailAdminService> implements OnInit {


    constructor(private inventaireDetailService: InventaireDetailAdminService, private inventaireService: InventaireAdminService, private produitService: ProduitAdminService){
        super(inventaireDetailService);
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
    get inventaire(): InventaireDto {
       return this.inventaireService.item;
    }
    set inventaire(value: InventaireDto) {
        this.inventaireService.item = value;
    }
    get inventaires(): Array<InventaireDto> {
       return this.inventaireService.items;
    }
    set inventaires(value: Array<InventaireDto>) {
        this.inventaireService.items = value;
    }


}
