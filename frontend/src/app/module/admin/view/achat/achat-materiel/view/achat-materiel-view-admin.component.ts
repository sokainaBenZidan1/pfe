import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AchatMaterielAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielAdmin.service';
import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielCriteria} from 'src/app/shared/criteria/achat/AchatMaterielCriteria.model';

import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielAdminService} from 'src/app/shared/service/admin/achat/TypeAchatMaterielAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-achat-materiel-view-admin',
  templateUrl: './achat-materiel-view-admin.component.html'
})
export class AchatMaterielViewAdminComponent extends AbstractViewController<AchatMaterielDto, AchatMaterielCriteria, AchatMaterielAdminService> implements OnInit {

    achatMaterielDetails = new AchatMaterielDetailDto();
    achatMaterielDetailss: Array<AchatMaterielDetailDto> = [];

    constructor(private achatMaterielService: AchatMaterielAdminService, private typeAchatMaterielService: TypeAchatMaterielAdminService, private budgetService: BudgetAdminService, private achatMaterielDetailService: AchatMaterielDetailAdminService, private produitService: ProduitAdminService){
        super(achatMaterielService);
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
    get typeAchatMateriel(): TypeAchatMaterielDto {
       return this.typeAchatMaterielService.item;
    }
    set typeAchatMateriel(value: TypeAchatMaterielDto) {
        this.typeAchatMaterielService.item = value;
    }
    get typeAchatMateriels(): Array<TypeAchatMaterielDto> {
       return this.typeAchatMaterielService.items;
    }
    set typeAchatMateriels(value: Array<TypeAchatMaterielDto>) {
        this.typeAchatMaterielService.items = value;
    }
    get budget(): BudgetDto {
       return this.budgetService.item;
    }
    set budget(value: BudgetDto) {
        this.budgetService.item = value;
    }
    get budgets(): Array<BudgetDto> {
       return this.budgetService.items;
    }
    set budgets(value: Array<BudgetDto>) {
        this.budgetService.items = value;
    }


}
