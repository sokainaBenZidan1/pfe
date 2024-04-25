import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatAdminService} from 'src/app/shared/service/admin/expressionbesion/EtatAdmin.service';
import {EtatDto} from 'src/app/shared/model/expressionbesion/Etat.model';
import {EtatCriteria} from 'src/app/shared/criteria/expressionbesion/EtatCriteria.model';



@Component({
  selector: 'app-etat-edit-admin',
  templateUrl: './etat-edit-admin.component.html'
})
export class EtatEditAdminComponent extends AbstractEditController<EtatDto, EtatCriteria, EtatAdminService>   implements OnInit {


    private _validEtatCode = true;
    private _validEtatLibelle = true;




    constructor( private etatService: EtatAdminService ) {
        super(etatService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validEtatCode = value;
        this.validEtatLibelle = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatCode();
        this.validateEtatLibelle();
    }
    public validateEtatCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEtatCode = false;
        } else {
            this.validEtatCode = true;
        }
    }
    public validateEtatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatLibelle = false;
        } else {
            this.validEtatLibelle = true;
        }
    }






    get validEtatCode(): boolean {
        return this._validEtatCode;
    }
    set validEtatCode(value: boolean) {
        this._validEtatCode = value;
    }
    get validEtatLibelle(): boolean {
        return this._validEtatLibelle;
    }
    set validEtatLibelle(value: boolean) {
        this._validEtatLibelle = value;
    }

}
