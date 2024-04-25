import {Component, OnInit} from '@angular/core';
import {LivraisonAdminService} from 'src/app/shared/service/admin/livraison/LivraisonAdmin.service';
import {LivraisonDto} from 'src/app/shared/model/livraison/Livraison.model';
import {LivraisonCriteria} from 'src/app/shared/criteria/livraison/LivraisonCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {LivraisonDetailDto} from 'src/app/shared/model/livraison/LivraisonDetail.model';
import {LivraisonDetailAdminService} from 'src/app/shared/service/admin/livraison/LivraisonDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-livraison-list-admin',
  templateUrl: './livraison-list-admin.component.html'
})
export class LivraisonListAdminComponent extends AbstractListController<LivraisonDto, LivraisonCriteria, LivraisonAdminService>  implements OnInit {

    override fileName = 'Livraison';


    receptions: Array<ReceptionDto>;


    constructor( private livraisonService: LivraisonAdminService  , private magasinService: MagasinAdminService, private receptionService: ReceptionAdminService, private livraisonDetailService: LivraisonDetailAdminService, private produitService: ProduitAdminService) {
        super(livraisonService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Livraison').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadReception();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'datelivraison', header: 'Datelivraison'},
            {field: 'reception?.ref', header: 'Reception'},
        ];
    }


    public async loadReception(){
       this.receptionService.findAllOptimized().subscribe(receptions => this.receptions = receptions, error => console.log(error))
    }

	public override initDuplicate(res: LivraisonDto) {
        if (res.livraisonDetails != null) {
             res.livraisonDetails.forEach(d => { d.livraison = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                'Datelivraison': this.datePipe.transform(e.datelivraison , 'dd/MM/yyyy hh:mm'),
                'Reception': e.reception?.ref ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Datelivraison Min': this.criteria.datelivraisonFrom ? this.datePipe.transform(this.criteria.datelivraisonFrom , this.dateFormat) : environment.emptyForExport ,
            'Datelivraison Max': this.criteria.datelivraisonTo ? this.datePipe.transform(this.criteria.datelivraisonTo , this.dateFormat) : environment.emptyForExport ,
        //'Reception': this.criteria.reception?.ref ? this.criteria.reception?.ref : environment.emptyForExport ,
        }];
      }
}
