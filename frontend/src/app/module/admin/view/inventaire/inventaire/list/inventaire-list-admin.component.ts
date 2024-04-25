import {Component, OnInit} from '@angular/core';
import {InventaireAdminService} from 'src/app/shared/service/admin/inventaire/InventaireAdmin.service';
import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireCriteria} from 'src/app/shared/criteria/inventaire/InventaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireAdminService} from 'src/app/shared/service/admin/inventaire/ResponsableInventaireAdmin.service';
import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailAdminService} from 'src/app/shared/service/admin/inventaire/InventaireDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-inventaire-list-admin',
  templateUrl: './inventaire-list-admin.component.html'
})
export class InventaireListAdminComponent extends AbstractListController<InventaireDto, InventaireCriteria, InventaireAdminService>  implements OnInit {

    override fileName = 'Inventaire';


    responsableInvs: Array<ResponsableInventaireDto>;


    constructor( private inventaireService: InventaireAdminService  , private responsableInventaireService: ResponsableInventaireAdminService, private inventaireDetailService: InventaireDetailAdminService, private produitService: ProduitAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Inventaire').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadResponsableInv();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'dateDebut', header: 'Date debut'},
            {field: 'dateFin', header: 'Date fin'},
            {field: 'responsableInv?.id', header: 'Responsable inv'},
        ];
    }


    public async loadResponsableInv(){
       this.responsableInventaireService.findAll().subscribe(responsableInvs => this.responsableInvs = responsableInvs, error => console.log(error))
    }

	public override initDuplicate(res: InventaireDto) {
        if (res.inventaireDetails != null) {
             res.inventaireDetails.forEach(d => { d.inventaire = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Date debut': this.datePipe.transform(e.dateDebut , 'dd/MM/yyyy hh:mm'),
                'Date fin': this.datePipe.transform(e.dateFin , 'dd/MM/yyyy hh:mm'),
                'Responsable inv': e.responsableInv?.id ,
            }
        });

        this.criteriaData = [{
            'Date debut Min': this.criteria.dateDebutFrom ? this.datePipe.transform(this.criteria.dateDebutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut Max': this.criteria.dateDebutTo ? this.datePipe.transform(this.criteria.dateDebutTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin Min': this.criteria.dateFinFrom ? this.datePipe.transform(this.criteria.dateFinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin Max': this.criteria.dateFinTo ? this.datePipe.transform(this.criteria.dateFinTo , this.dateFormat) : environment.emptyForExport ,
        //'Responsable inv': this.criteria.responsableInv?.id ? this.criteria.responsableInv?.id : environment.emptyForExport ,
        }];
      }
}
