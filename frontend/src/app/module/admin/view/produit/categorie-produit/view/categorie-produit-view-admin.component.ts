import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieProduitAdminService} from 'src/app/shared/service/admin/produit/CategorieProduitAdmin.service';
import {CategorieProduitDto} from 'src/app/shared/model/produit/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/shared/criteria/produit/CategorieProduitCriteria.model';

import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';
@Component({
  selector: 'app-categorie-produit-view-admin',
  templateUrl: './categorie-produit-view-admin.component.html'
})
export class CategorieProduitViewAdminComponent extends AbstractViewController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitAdminService> implements OnInit {


    constructor(private categorieProduitService: CategorieProduitAdminService, private compteBudgetaireService: CompteBudgetaireAdminService){
        super(categorieProduitService);
    }

    ngOnInit(): void {
    }


    get compteBudgetaire(): CompteBudgetaireDto {
       return this.compteBudgetaireService.item;
    }
    set compteBudgetaire(value: CompteBudgetaireDto) {
        this.compteBudgetaireService.item = value;
    }
    get compteBudgetaires(): Array<CompteBudgetaireDto> {
       return this.compteBudgetaireService.items;
    }
    set compteBudgetaires(value: Array<CompteBudgetaireDto>) {
        this.compteBudgetaireService.items = value;
    }


}
