import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ResponsabiliteAdminService} from 'src/app/shared/service/admin/mandat/ResponsabiliteAdmin.service';
import {ResponsabiliteDto} from 'src/app/shared/model/mandat/Responsabilite.model';
import {ResponsabiliteCriteria} from 'src/app/shared/criteria/mandat/ResponsabiliteCriteria.model';



@Component({
  selector: 'app-responsabilite-edit-admin',
  templateUrl: './responsabilite-edit-admin.component.html'
})
export class ResponsabiliteEditAdminComponent extends AbstractEditController<ResponsabiliteDto, ResponsabiliteCriteria, ResponsabiliteAdminService>   implements OnInit {


    private _validResponsabiliteLibelle = true;
    private _validResponsabiliteCode = true;




    constructor( private responsabiliteService: ResponsabiliteAdminService ) {
        super(responsabiliteService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validResponsabiliteLibelle = value;
        this.validResponsabiliteCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateResponsabiliteLibelle();
        this.validateResponsabiliteCode();
    }
    public validateResponsabiliteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validResponsabiliteLibelle = false;
        } else {
            this.validResponsabiliteLibelle = true;
        }
    }
    public validateResponsabiliteCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validResponsabiliteCode = false;
        } else {
            this.validResponsabiliteCode = true;
        }
    }






    get validResponsabiliteLibelle(): boolean {
        return this._validResponsabiliteLibelle;
    }
    set validResponsabiliteLibelle(value: boolean) {
        this._validResponsabiliteLibelle = value;
    }
    get validResponsabiliteCode(): boolean {
        return this._validResponsabiliteCode;
    }
    set validResponsabiliteCode(value: boolean) {
        this._validResponsabiliteCode = value;
    }

}
