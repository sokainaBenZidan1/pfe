import {Component, OnInit} from '@angular/core';
import {CategorieProduitAdminService} from 'src/app/shared/service/admin/produit/CategorieProduitAdmin.service';
import {CategorieProduitDto} from 'src/app/shared/model/produit/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/shared/criteria/produit/CategorieProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';


@Component({
  selector: 'app-categorie-produit-list-admin',
  templateUrl: './categorie-produit-list-admin.component.html'
})
export class CategorieProduitListAdminComponent extends AbstractListController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitAdminService>  implements OnInit {

    override fileName = 'CategorieProduit';


    compteBudgetaires: Array<CompteBudgetaireDto>;


    constructor( private categorieProduitService: CategorieProduitAdminService  , private compteBudgetaireService: CompteBudgetaireAdminService) {
        super(categorieProduitService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CategorieProduit').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCompteBudgetaire();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'compteBudgetaire?.libelle', header: 'Compte budgetaire'},
        ];
    }


    public async loadCompteBudgetaire(){
       this.compteBudgetaireService.findAllOptimized().subscribe(compteBudgetaires => this.compteBudgetaires = compteBudgetaires, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                'Compte budgetaire': e.compteBudgetaire?.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Compte budgetaire': this.criteria.compteBudgetaire?.libelle ? this.criteria.compteBudgetaire?.libelle : environment.emptyForExport ,
        }];
      }
}
