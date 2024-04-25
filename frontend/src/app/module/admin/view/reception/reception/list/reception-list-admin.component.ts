import {Component, OnInit} from '@angular/core';
import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionCriteria} from 'src/app/shared/criteria/reception/ReceptionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {ReceptionDetailDto} from 'src/app/shared/model/reception/ReceptionDetail.model';
import {ReceptionDetailAdminService} from 'src/app/shared/service/admin/reception/ReceptionDetailAdmin.service';


@Component({
  selector: 'app-reception-list-admin',
  templateUrl: './reception-list-admin.component.html'
})
export class ReceptionListAdminComponent extends AbstractListController<ReceptionDto, ReceptionCriteria, ReceptionAdminService>  implements OnInit {

    override fileName = 'Reception';


    commandes: Array<CommandeDto>;


    constructor( private receptionService: ReceptionAdminService  , private magasinService: MagasinAdminService, private commandeService: CommandeAdminService, private produitService: ProduitAdminService, private receptionDetailService: ReceptionDetailAdminService) {
        super(receptionService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Reception').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCommande();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'dateReception', header: 'Date reception'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'commande?.ref', header: 'Commande'},
        ];
    }


    public async loadCommande(){
       this.commandeService.findAllOptimized().subscribe(commandes => this.commandes = commandes, error => console.log(error))
    }

	public override initDuplicate(res: ReceptionDto) {
        if (res.receptionDetails != null) {
             res.receptionDetails.forEach(d => { d.reception = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                'Date reception': this.datePipe.transform(e.dateReception , 'dd/MM/yyyy hh:mm'),
                 'Libelle': e.libelle ,
                'Commande': e.commande?.ref ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Date reception Min': this.criteria.dateReceptionFrom ? this.datePipe.transform(this.criteria.dateReceptionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date reception Max': this.criteria.dateReceptionTo ? this.datePipe.transform(this.criteria.dateReceptionTo , this.dateFormat) : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Commande': this.criteria.commande?.ref ? this.criteria.commande?.ref : environment.emptyForExport ,
        }];
      }
}
