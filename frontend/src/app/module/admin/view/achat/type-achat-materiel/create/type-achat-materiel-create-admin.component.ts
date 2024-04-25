import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TypeAchatMaterielAdminService} from 'src/app/shared/service/admin/achat/TypeAchatMaterielAdmin.service';
import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielCriteria} from 'src/app/shared/criteria/achat/TypeAchatMaterielCriteria.model';
@Component({
  selector: 'app-type-achat-materiel-create-admin',
  templateUrl: './type-achat-materiel-create-admin.component.html'
})
export class TypeAchatMaterielCreateAdminComponent extends AbstractCreateController<TypeAchatMaterielDto, TypeAchatMaterielCriteria, TypeAchatMaterielAdminService>  implements OnInit {



   private _validTypeAchatMaterielLibelle = true;
   private _validTypeAchatMaterielCode = true;

    constructor( private typeAchatMaterielService: TypeAchatMaterielAdminService ) {
        super(typeAchatMaterielService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validTypeAchatMaterielLibelle = value;
        this.validTypeAchatMaterielCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeAchatMaterielLibelle();
        this.validateTypeAchatMaterielCode();
    }

    public validateTypeAchatMaterielLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTypeAchatMaterielLibelle = false;
        } else {
            this.validTypeAchatMaterielLibelle = true;
        }
    }
    public validateTypeAchatMaterielCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTypeAchatMaterielCode = false;
        } else {
            this.validTypeAchatMaterielCode = true;
        }
    }






    get validTypeAchatMaterielLibelle(): boolean {
        return this._validTypeAchatMaterielLibelle;
    }

    set validTypeAchatMaterielLibelle(value: boolean) {
         this._validTypeAchatMaterielLibelle = value;
    }
    get validTypeAchatMaterielCode(): boolean {
        return this._validTypeAchatMaterielCode;
    }

    set validTypeAchatMaterielCode(value: boolean) {
         this._validTypeAchatMaterielCode = value;
    }



}
