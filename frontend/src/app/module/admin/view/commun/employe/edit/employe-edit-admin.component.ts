import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EmployeAdminService} from 'src/app/shared/service/admin/commun/EmployeAdmin.service';
import {EmployeDto} from 'src/app/shared/model/commun/Employe.model';
import {EmployeCriteria} from 'src/app/shared/criteria/commun/EmployeCriteria.model';


import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';

@Component({
  selector: 'app-employe-edit-admin',
  templateUrl: './employe-edit-admin.component.html'
})
export class EmployeEditAdminComponent extends AbstractEditController<EmployeDto, EmployeCriteria, EmployeAdminService>   implements OnInit {


    private _validEmployeNom = true;
    private _validEmployePrenom = true;

    private _validEntiteAdminCode = true;
    private _validEntiteAdminLibelle = true;



    constructor( private employeService: EmployeAdminService , private entiteAdminService: EntiteAdminAdminService) {
        super(employeService);
    }

    ngOnInit(): void {
        this.entiteAdmin = new EntiteAdminDto();
        this.entiteAdminService.findAll().subscribe((data) => this.entiteAdmins = data);
    }


    public override setValidation(value: boolean){
        this.validEmployeNom = value;
        this.validEmployePrenom = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEmployeNom();
        this.validateEmployePrenom();
    }
    public validateEmployeNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validEmployeNom = false;
        } else {
            this.validEmployeNom = true;
        }
    }
    public validateEmployePrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
            this.errorMessages.push('Prenom non valide');
            this.validEmployePrenom = false;
        } else {
            this.validEmployePrenom = true;
        }
    }



   public async openCreateEntiteAdmin(entiteAdmin: string) {
        const isPermistted = await this.roleService.isPermitted('EntiteAdmin', 'edit');
        if (isPermistted) {
             this.entiteAdmin = new EntiteAdminDto();
             this.createEntiteAdminDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get entiteAdmin(): EntiteAdminDto {
       return this.entiteAdminService.item;
   }
  set entiteAdmin(value: EntiteAdminDto) {
        this.entiteAdminService.item = value;
   }
   get entiteAdmins(): Array<EntiteAdminDto> {
        return this.entiteAdminService.items;
   }
   set entiteAdmins(value: Array<EntiteAdminDto>) {
        this.entiteAdminService.items = value;
   }
   get createEntiteAdminDialog(): boolean {
       return this.entiteAdminService.createDialog;
   }
  set createEntiteAdminDialog(value: boolean) {
       this.entiteAdminService.createDialog= value;
   }


    get validEmployeNom(): boolean {
        return this._validEmployeNom;
    }
    set validEmployeNom(value: boolean) {
        this._validEmployeNom = value;
    }
    get validEmployePrenom(): boolean {
        return this._validEmployePrenom;
    }
    set validEmployePrenom(value: boolean) {
        this._validEmployePrenom = value;
    }

    get validEntiteAdminCode(): boolean {
        return this._validEntiteAdminCode;
    }
    set validEntiteAdminCode(value: boolean) {
        this._validEntiteAdminCode = value;
    }
    get validEntiteAdminLibelle(): boolean {
        return this._validEntiteAdminLibelle;
    }
    set validEntiteAdminLibelle(value: boolean) {
        this._validEntiteAdminLibelle = value;
    }
}
