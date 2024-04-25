import {Component, OnInit} from '@angular/core';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinCriteria} from 'src/app/shared/criteria/stock/MagasinCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-magasin-list-admin',
  templateUrl: './magasin-list-admin.component.html'
})
export class MagasinListAdminComponent extends AbstractListController<MagasinDto, MagasinCriteria, MagasinAdminService>  implements OnInit {

    override fileName = 'Magasin';




    constructor( private magasinService: MagasinAdminService  ) {
        super(magasinService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Magasin').subscribe(() => {
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
            {field: 'adresse', header: 'Adresse'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Adresse': e.adresse ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
        }];
      }
}
