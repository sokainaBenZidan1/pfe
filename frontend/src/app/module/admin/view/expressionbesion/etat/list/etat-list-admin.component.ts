import {Component, OnInit} from '@angular/core';
import {EtatAdminService} from 'src/app/shared/service/admin/expressionbesion/EtatAdmin.service';
import {EtatDto} from 'src/app/shared/model/expressionbesion/Etat.model';
import {EtatCriteria} from 'src/app/shared/criteria/expressionbesion/EtatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-list-admin',
  templateUrl: './etat-list-admin.component.html'
})
export class EtatListAdminComponent extends AbstractListController<EtatDto, EtatCriteria, EtatAdminService>  implements OnInit {

    override fileName = 'Etat';




    constructor( private etatService: EtatAdminService  ) {
        super(etatService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Etat').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
