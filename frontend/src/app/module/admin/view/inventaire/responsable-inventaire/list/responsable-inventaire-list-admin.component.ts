import {Component, OnInit} from '@angular/core';
import {ResponsableInventaireAdminService} from 'src/app/shared/service/admin/inventaire/ResponsableInventaireAdmin.service';
import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireCriteria} from 'src/app/shared/criteria/inventaire/ResponsableInventaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-responsable-inventaire-list-admin',
  templateUrl: './responsable-inventaire-list-admin.component.html'
})
export class ResponsableInventaireListAdminComponent extends AbstractListController<ResponsableInventaireDto, ResponsableInventaireCriteria, ResponsableInventaireAdminService>  implements OnInit {

    override fileName = 'ResponsableInventaire';




    constructor( private responsableInventaireService: ResponsableInventaireAdminService  ) {
        super(responsableInventaireService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('ResponsableInventaire').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
            {field: 'login', header: 'Login'},
            {field: 'mdp', header: 'Mdp'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
                 'Login': e.login ,
                 'Mdp': e.mdp ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
            'Login': this.criteria.login ? this.criteria.login : environment.emptyForExport ,
            'Mdp': this.criteria.mdp ? this.criteria.mdp : environment.emptyForExport ,
        }];
      }
}
