import {Component, OnInit} from '@angular/core';
import {AchatMaterielAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielAdmin.service';
import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielCriteria} from 'src/app/shared/criteria/achat/AchatMaterielCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielAdminService} from 'src/app/shared/service/admin/achat/TypeAchatMaterielAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-achat-materiel-list-admin',
  templateUrl: './achat-materiel-list-admin.component.html'
})
export class AchatMaterielListAdminComponent extends AbstractListController<AchatMaterielDto, AchatMaterielCriteria, AchatMaterielAdminService>  implements OnInit {

    override fileName = 'AchatMateriel';


    budgets: Array<BudgetDto>;
    typeAchatMateriels: Array<TypeAchatMaterielDto>;


    constructor( private achatMaterielService: AchatMaterielAdminService  , private typeAchatMaterielService: TypeAchatMaterielAdminService, private budgetService: BudgetAdminService, private achatMaterielDetailService: AchatMaterielDetailAdminService, private produitService: ProduitAdminService) {
        super(achatMaterielService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('AchatMateriel').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadBudget();
                this.loadTypeAchatMateriel();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'budget?.id', header: 'Budget'},
            {field: 'montantTotal', header: 'Montant total'},
            {field: 'dateAchat', header: 'Date achat'},
            {field: 'typeAchatMateriel?.libelle', header: 'Type achat materiel'},
        ];
    }


    public async loadBudget(){
       this.budgetService.findAll().subscribe(budgets => this.budgets = budgets, error => console.log(error))
    }
    public async loadTypeAchatMateriel(){
       this.typeAchatMaterielService.findAllOptimized().subscribe(typeAchatMateriels => this.typeAchatMateriels = typeAchatMateriels, error => console.log(error))
    }

	public override initDuplicate(res: AchatMaterielDto) {
        if (res.achatMaterielDetails != null) {
             res.achatMaterielDetails.forEach(d => { d.achatMateriel = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Budget': e.budget?.id ,
                 'Montant total': e.montantTotal ,
                'Date achat': this.datePipe.transform(e.dateAchat , 'dd/MM/yyyy hh:mm'),
                'Type achat materiel': e.typeAchatMateriel?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Budget': this.criteria.budget?.id ? this.criteria.budget?.id : environment.emptyForExport ,
            'Montant total Min': this.criteria.montantTotalMin ? this.criteria.montantTotalMin : environment.emptyForExport ,
            'Montant total Max': this.criteria.montantTotalMax ? this.criteria.montantTotalMax : environment.emptyForExport ,
            'Date achat Min': this.criteria.dateAchatFrom ? this.datePipe.transform(this.criteria.dateAchatFrom , this.dateFormat) : environment.emptyForExport ,
            'Date achat Max': this.criteria.dateAchatTo ? this.datePipe.transform(this.criteria.dateAchatTo , this.dateFormat) : environment.emptyForExport ,
        //'Type achat materiel': this.criteria.typeAchatMateriel?.libelle ? this.criteria.typeAchatMateriel?.libelle : environment.emptyForExport ,
        }];
      }
}
