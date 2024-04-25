import {Component, OnInit} from '@angular/core';
import {MandatAdminService} from 'src/app/shared/service/admin/mandat/MandatAdmin.service';
import {MandatDto} from 'src/app/shared/model/mandat/Mandat.model';
import {MandatCriteria} from 'src/app/shared/criteria/mandat/MandatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {ResponsabiliteDto} from 'src/app/shared/model/mandat/Responsabilite.model';
import {ResponsabiliteAdminService} from 'src/app/shared/service/admin/mandat/ResponsabiliteAdmin.service';
import {EmployeDto} from 'src/app/shared/model/commun/Employe.model';
import {EmployeAdminService} from 'src/app/shared/service/admin/commun/EmployeAdmin.service';


@Component({
  selector: 'app-mandat-list-admin',
  templateUrl: './mandat-list-admin.component.html'
})
export class MandatListAdminComponent extends AbstractListController<MandatDto, MandatCriteria, MandatAdminService>  implements OnInit {

    override fileName = 'Mandat';


    employes: Array<EmployeDto>;
    responsabilites: Array<ResponsabiliteDto>;
    entiteAdmins: Array<EntiteAdminDto>;


    constructor( private mandatService: MandatAdminService  , private entiteAdminService: EntiteAdminAdminService, private responsabiliteService: ResponsabiliteAdminService, private employeService: EmployeAdminService) {
        super(mandatService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Mandat').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEmploye();
                this.loadResponsabilite();
                this.loadEntiteAdmin();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'employe?.nom', header: 'Employe'},
            {field: 'dateDebut', header: 'Date debut'},
            {field: 'dateFin', header: 'Date fin'},
            {field: 'responsabilite?.libelle', header: 'Responsabilite'},
            {field: 'entiteAdmin?.libelle', header: 'Entite admin'},
        ];
    }


    public async loadEmploye(){
       this.employeService.findAllOptimized().subscribe(employes => this.employes = employes, error => console.log(error))
    }
    public async loadResponsabilite(){
       this.responsabiliteService.findAllOptimized().subscribe(responsabilites => this.responsabilites = responsabilites, error => console.log(error))
    }
    public async loadEntiteAdmin(){
       this.entiteAdminService.findAllOptimized().subscribe(entiteAdmins => this.entiteAdmins = entiteAdmins, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Employe': e.employe?.nom ,
                'Date debut': this.datePipe.transform(e.dateDebut , 'dd/MM/yyyy hh:mm'),
                'Date fin': this.datePipe.transform(e.dateFin , 'dd/MM/yyyy hh:mm'),
                'Responsabilite': e.responsabilite?.libelle ,
                'Entite admin': e.entiteAdmin?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Employe': this.criteria.employe?.nom ? this.criteria.employe?.nom : environment.emptyForExport ,
            'Date debut Min': this.criteria.dateDebutFrom ? this.datePipe.transform(this.criteria.dateDebutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut Max': this.criteria.dateDebutTo ? this.datePipe.transform(this.criteria.dateDebutTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin Min': this.criteria.dateFinFrom ? this.datePipe.transform(this.criteria.dateFinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin Max': this.criteria.dateFinTo ? this.datePipe.transform(this.criteria.dateFinTo , this.dateFormat) : environment.emptyForExport ,
        //'Responsabilite': this.criteria.responsabilite?.libelle ? this.criteria.responsabilite?.libelle : environment.emptyForExport ,
        //'Entite admin': this.criteria.entiteAdmin?.libelle ? this.criteria.entiteAdmin?.libelle : environment.emptyForExport ,
        }];
      }
}
