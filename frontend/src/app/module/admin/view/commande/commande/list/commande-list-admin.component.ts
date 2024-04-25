import {Component, OnInit} from '@angular/core';
import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeCriteria} from 'src/app/shared/criteria/commande/CommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {CommandeDetailDto} from 'src/app/shared/model/commande/CommandeDetail.model';
import {CommandeDetailAdminService} from 'src/app/shared/service/admin/commande/CommandeDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-commande-list-admin',
  templateUrl: './commande-list-admin.component.html'
})
export class CommandeListAdminComponent extends AbstractListController<CommandeDto, CommandeCriteria, CommandeAdminService>  implements OnInit {

    override fileName = 'Commande';


    entiteAdmins: Array<EntiteAdminDto>;


    constructor( private commandeService: CommandeAdminService  , private entiteAdminService: EntiteAdminAdminService, private commandeDetailService: CommandeDetailAdminService, private produitService: ProduitAdminService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Commande').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEntiteAdmin();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'total', header: 'Total'},
            {field: 'totalPaye', header: 'Total paye'},
            {field: 'dateCommande', header: 'Date commande'},
            {field: 'entiteAdmin?.libelle', header: 'Entite admin'},
        ];
    }


    public async loadEntiteAdmin(){
       this.entiteAdminService.findAllOptimized().subscribe(entiteAdmins => this.entiteAdmins = entiteAdmins, error => console.log(error))
    }

	public override initDuplicate(res: CommandeDto) {
        if (res.commandeDetails != null) {
             res.commandeDetails.forEach(d => { d.commande = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                 'Total': e.total ,
                 'Total paye': e.totalPaye ,
                'Date commande': this.datePipe.transform(e.dateCommande , 'dd/MM/yyyy hh:mm'),
                'Entite admin': e.entiteAdmin?.libelle ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Total paye Min': this.criteria.totalPayeMin ? this.criteria.totalPayeMin : environment.emptyForExport ,
            'Total paye Max': this.criteria.totalPayeMax ? this.criteria.totalPayeMax : environment.emptyForExport ,
            'Date commande Min': this.criteria.dateCommandeFrom ? this.datePipe.transform(this.criteria.dateCommandeFrom , this.dateFormat) : environment.emptyForExport ,
            'Date commande Max': this.criteria.dateCommandeTo ? this.datePipe.transform(this.criteria.dateCommandeTo , this.dateFormat) : environment.emptyForExport ,
        //'Entite admin': this.criteria.entiteAdmin?.libelle ? this.criteria.entiteAdmin?.libelle : environment.emptyForExport ,
        }];
      }
}
