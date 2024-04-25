import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';
import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/CompteBudgetaireCriteria.model';



@Component({
  selector: 'app-compte-budgetaire-edit-admin',
  templateUrl: './compte-budgetaire-edit-admin.component.html'
})
export class CompteBudgetaireEditAdminComponent extends AbstractEditController<CompteBudgetaireDto, CompteBudgetaireCriteria, CompteBudgetaireAdminService>   implements OnInit {


    private _validCompteBudgetaireLibelle = true;
    private _validCompteBudgetaireCode = true;




    constructor( private compteBudgetaireService: CompteBudgetaireAdminService ) {
        super(compteBudgetaireService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validCompteBudgetaireLibelle = value;
        this.validCompteBudgetaireCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCompteBudgetaireLibelle();
        this.validateCompteBudgetaireCode();
    }
    public validateCompteBudgetaireLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validCompteBudgetaireLibelle = false;
        } else {
            this.validCompteBudgetaireLibelle = true;
        }
    }
    public validateCompteBudgetaireCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validCompteBudgetaireCode = false;
        } else {
            this.validCompteBudgetaireCode = true;
        }
    }






    get validCompteBudgetaireLibelle(): boolean {
        return this._validCompteBudgetaireLibelle;
    }
    set validCompteBudgetaireLibelle(value: boolean) {
        this._validCompteBudgetaireLibelle = value;
    }
    get validCompteBudgetaireCode(): boolean {
        return this._validCompteBudgetaireCode;
    }
    set validCompteBudgetaireCode(value: boolean) {
        this._validCompteBudgetaireCode = value;
    }

}
