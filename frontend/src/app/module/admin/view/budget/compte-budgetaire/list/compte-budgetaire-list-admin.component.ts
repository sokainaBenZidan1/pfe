import {Component, OnInit} from '@angular/core';
import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';
import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/CompteBudgetaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-compte-budgetaire-list-admin',
  templateUrl: './compte-budgetaire-list-admin.component.html'
})
export class CompteBudgetaireListAdminComponent extends AbstractListController<CompteBudgetaireDto, CompteBudgetaireCriteria, CompteBudgetaireAdminService>  implements OnInit {

    override fileName = 'CompteBudgetaire';




    constructor( private compteBudgetaireService: CompteBudgetaireAdminService  ) {
        super(compteBudgetaireService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CompteBudgetaire').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'montantMax', header: 'Montant max'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                 'Montant max': e.montantMax ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Montant max Min': this.criteria.montantMaxMin ? this.criteria.montantMaxMin : environment.emptyForExport ,
            'Montant max Max': this.criteria.montantMaxMax ? this.criteria.montantMaxMax : environment.emptyForExport ,
        }];
      }
}
