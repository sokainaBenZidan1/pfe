import {Component, OnInit} from '@angular/core';
import {TypeAchatMaterielAdminService} from 'src/app/shared/service/admin/achat/TypeAchatMaterielAdmin.service';
import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielCriteria} from 'src/app/shared/criteria/achat/TypeAchatMaterielCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-type-achat-materiel-list-admin',
  templateUrl: './type-achat-materiel-list-admin.component.html'
})
export class TypeAchatMaterielListAdminComponent extends AbstractListController<TypeAchatMaterielDto, TypeAchatMaterielCriteria, TypeAchatMaterielAdminService>  implements OnInit {

    override fileName = 'TypeAchatMateriel';




    constructor( private typeAchatMaterielService: TypeAchatMaterielAdminService  ) {
        super(typeAchatMaterielService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('TypeAchatMateriel').subscribe(() => {
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
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
