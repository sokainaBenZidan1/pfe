import {Component, OnInit} from '@angular/core';
import {ExpressionBesoinAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinAdmin.service';
import {ExpressionBesoinDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoin.model';
import {ExpressionBesoinCriteria} from 'src/app/shared/criteria/expressionbesion/ExpressionBesoinCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {EtatDto} from 'src/app/shared/model/expressionbesion/Etat.model';
import {EtatAdminService} from 'src/app/shared/service/admin/expressionbesion/EtatAdmin.service';
import {ExpressionBesoinDetailDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoinDetail.model';
import {ExpressionBesoinDetailAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinDetailAdmin.service';
import {EmployeDto} from 'src/app/shared/model/commun/Employe.model';
import {EmployeAdminService} from 'src/app/shared/service/admin/commun/EmployeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';


@Component({
  selector: 'app-expression-besoin-list-admin',
  templateUrl: './expression-besoin-list-admin.component.html'
})
export class ExpressionBesoinListAdminComponent extends AbstractListController<ExpressionBesoinDto, ExpressionBesoinCriteria, ExpressionBesoinAdminService>  implements OnInit {

    override fileName = 'ExpressionBesoin';


    employes: Array<EmployeDto>;
    entiteAdmins: Array<EntiteAdminDto>;
    etats: Array<EtatDto>;


    constructor( private expressionBesoinService: ExpressionBesoinAdminService  , private entiteAdminService: EntiteAdminAdminService, private etatService: EtatAdminService, private expressionBesoinDetailService: ExpressionBesoinDetailAdminService, private employeService: EmployeAdminService, private produitService: ProduitAdminService) {
        super(expressionBesoinService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('ExpressionBesoin').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEmploye();
                this.loadEntiteAdmin();
                this.loadEtat();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'employe?.nom', header: 'Employe'},
            {field: 'entiteAdmin?.libelle', header: 'Entite admin'},
            {field: 'dateExpression', header: 'Date expression'},
            {field: 'etat?.libelle', header: 'Etat'},
        ];
    }


    public async loadEmploye(){
       this.employeService.findAllOptimized().subscribe(employes => this.employes = employes, error => console.log(error))
    }
    public async loadEntiteAdmin(){
       this.entiteAdminService.findAllOptimized().subscribe(entiteAdmins => this.entiteAdmins = entiteAdmins, error => console.log(error))
    }
    public async loadEtat(){
       this.etatService.findAllOptimized().subscribe(etats => this.etats = etats, error => console.log(error))
    }

	public override initDuplicate(res: ExpressionBesoinDto) {
        if (res.expressionBesoinDetails != null) {
             res.expressionBesoinDetails.forEach(d => { d.expressionBesoin = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Employe': e.employe?.nom ,
                'Entite admin': e.entiteAdmin?.libelle ,
                 'Description': e.description ,
                'Date expression': this.datePipe.transform(e.dateExpression , 'dd/MM/yyyy hh:mm'),
                'Etat': e.etat?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Employe': this.criteria.employe?.nom ? this.criteria.employe?.nom : environment.emptyForExport ,
        //'Entite admin': this.criteria.entiteAdmin?.libelle ? this.criteria.entiteAdmin?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Date expression Min': this.criteria.dateExpressionFrom ? this.datePipe.transform(this.criteria.dateExpressionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date expression Max': this.criteria.dateExpressionTo ? this.datePipe.transform(this.criteria.dateExpressionTo , this.dateFormat) : environment.emptyForExport ,
        //'Etat': this.criteria.etat?.libelle ? this.criteria.etat?.libelle : environment.emptyForExport ,
        }];
      }
}
