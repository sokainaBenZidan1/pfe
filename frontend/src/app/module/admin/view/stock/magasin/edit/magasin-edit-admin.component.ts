import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinCriteria} from 'src/app/shared/criteria/stock/MagasinCriteria.model';



@Component({
  selector: 'app-magasin-edit-admin',
  templateUrl: './magasin-edit-admin.component.html'
})
export class MagasinEditAdminComponent extends AbstractEditController<MagasinDto, MagasinCriteria, MagasinAdminService>   implements OnInit {


    private _validMagasinCode = true;




    constructor( private magasinService: MagasinAdminService ) {
        super(magasinService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validMagasinCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateMagasinCode();
    }
    public validateMagasinCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validMagasinCode = false;
        } else {
            this.validMagasinCode = true;
        }
    }






    get validMagasinCode(): boolean {
        return this._validMagasinCode;
    }
    set validMagasinCode(value: boolean) {
        this._validMagasinCode = value;
    }

}
