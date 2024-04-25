import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionCriteria} from 'src/app/shared/criteria/reception/ReceptionCriteria.model';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {ReceptionDetailDto} from 'src/app/shared/model/reception/ReceptionDetail.model';
import {ReceptionDetailAdminService} from 'src/app/shared/service/admin/reception/ReceptionDetailAdmin.service';
@Component({
  selector: 'app-reception-view-admin',
  templateUrl: './reception-view-admin.component.html'
})
export class ReceptionViewAdminComponent extends AbstractViewController<ReceptionDto, ReceptionCriteria, ReceptionAdminService> implements OnInit {

    receptionDetails = new ReceptionDetailDto();
    receptionDetailss: Array<ReceptionDetailDto> = [];

    constructor(private receptionService: ReceptionAdminService, private magasinService: MagasinAdminService, private commandeService: CommandeAdminService, private produitService: ProduitAdminService, private receptionDetailService: ReceptionDetailAdminService){
        super(receptionService);
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
    get commande(): CommandeDto {
       return this.commandeService.item;
    }
    set commande(value: CommandeDto) {
        this.commandeService.item = value;
    }
    get commandes(): Array<CommandeDto> {
       return this.commandeService.items;
    }
    set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
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
