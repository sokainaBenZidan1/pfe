import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ResponsableInventaireAdminService} from 'src/app/shared/service/admin/inventaire/ResponsableInventaireAdmin.service';
import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireCriteria} from 'src/app/shared/criteria/inventaire/ResponsableInventaireCriteria.model';
@Component({
  selector: 'app-responsable-inventaire-create-admin',
  templateUrl: './responsable-inventaire-create-admin.component.html'
})
export class ResponsableInventaireCreateAdminComponent extends AbstractCreateController<ResponsableInventaireDto, ResponsableInventaireCriteria, ResponsableInventaireAdminService>  implements OnInit {



   private _validResponsableInventaireNom = true;
   private _validResponsableInventairePrenom = true;
   private _validResponsableInventaireLogin = true;
   private _validResponsableInventaireMdp = true;

    constructor( private responsableInventaireService: ResponsableInventaireAdminService ) {
        super(responsableInventaireService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validResponsableInventaireNom = value;
        this.validResponsableInventairePrenom = value;
        this.validResponsableInventaireLogin = value;
        this.validResponsableInventaireMdp = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateResponsableInventaireNom();
        this.validateResponsableInventairePrenom();
        this.validateResponsableInventaireLogin();
        this.validateResponsableInventaireMdp();
    }

    public validateResponsableInventaireNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validResponsableInventaireNom = false;
        } else {
            this.validResponsableInventaireNom = true;
        }
    }
    public validateResponsableInventairePrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
        this.errorMessages.push('Prenom non valide');
        this.validResponsableInventairePrenom = false;
        } else {
            this.validResponsableInventairePrenom = true;
        }
    }
    public validateResponsableInventaireLogin(){
        if (this.stringUtilService.isEmpty(this.item.login)) {
        this.errorMessages.push('Login non valide');
        this.validResponsableInventaireLogin = false;
        } else {
            this.validResponsableInventaireLogin = true;
        }
    }
    public validateResponsableInventaireMdp(){
        if (this.stringUtilService.isEmpty(this.item.mdp)) {
        this.errorMessages.push('Mdp non valide');
        this.validResponsableInventaireMdp = false;
        } else {
            this.validResponsableInventaireMdp = true;
        }
    }






    get validResponsableInventaireNom(): boolean {
        return this._validResponsableInventaireNom;
    }

    set validResponsableInventaireNom(value: boolean) {
         this._validResponsableInventaireNom = value;
    }
    get validResponsableInventairePrenom(): boolean {
        return this._validResponsableInventairePrenom;
    }

    set validResponsableInventairePrenom(value: boolean) {
         this._validResponsableInventairePrenom = value;
    }
    get validResponsableInventaireLogin(): boolean {
        return this._validResponsableInventaireLogin;
    }

    set validResponsableInventaireLogin(value: boolean) {
         this._validResponsableInventaireLogin = value;
    }
    get validResponsableInventaireMdp(): boolean {
        return this._validResponsableInventaireMdp;
    }

    set validResponsableInventaireMdp(value: boolean) {
         this._validResponsableInventaireMdp = value;
    }



}
