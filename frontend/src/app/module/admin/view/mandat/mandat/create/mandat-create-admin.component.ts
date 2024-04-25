import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {MandatAdminService} from 'src/app/shared/service/admin/mandat/MandatAdmin.service';
import {MandatDto} from 'src/app/shared/model/mandat/Mandat.model';
import {MandatCriteria} from 'src/app/shared/criteria/mandat/MandatCriteria.model';
import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {ResponsabiliteDto} from 'src/app/shared/model/mandat/Responsabilite.model';
import {ResponsabiliteAdminService} from 'src/app/shared/service/admin/mandat/ResponsabiliteAdmin.service';
import {EmployeDto} from 'src/app/shared/model/commun/Employe.model';
import {EmployeAdminService} from 'src/app/shared/service/admin/commun/EmployeAdmin.service';
@Component({
  selector: 'app-mandat-create-admin',
  templateUrl: './mandat-create-admin.component.html'
})
export class MandatCreateAdminComponent extends AbstractCreateController<MandatDto, MandatCriteria, MandatAdminService>  implements OnInit {



    private _validEmployeNom = true;
    private _validEmployePrenom = true;
    private _validResponsabiliteLibelle = true;
    private _validResponsabiliteCode = true;
    private _validEntiteAdminCode = true;
    private _validEntiteAdminLibelle = true;

    constructor( private mandatService: MandatAdminService , private entiteAdminService: EntiteAdminAdminService, private responsabiliteService: ResponsabiliteAdminService, private employeService: EmployeAdminService) {
        super(mandatService);
    }

    ngOnInit(): void {
        this.employe = new EmployeDto();
        this.employeService.findAll().subscribe((data) => this.employes = data);
        this.responsabilite = new ResponsabiliteDto();
        this.responsabiliteService.findAll().subscribe((data) => this.responsabilites = data);
        this.entiteAdmin = new EntiteAdminDto();
        this.entiteAdminService.findAll().subscribe((data) => this.entiteAdmins = data);
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateResponsabilite(responsabilite: string) {
    const isPermistted = await this.roleService.isPermitted('Responsabilite', 'add');
    if(isPermistted) {
         this.responsabilite = new ResponsabiliteDto();
         this.createResponsabiliteDialog = true;
    }else{
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
    get responsabilite(): ResponsabiliteDto {
        return this.responsabiliteService.item;
    }
    set responsabilite(value: ResponsabiliteDto) {
        this.responsabiliteService.item = value;
    }
    get responsabilites(): Array<ResponsabiliteDto> {
        return this.responsabiliteService.items;
    }
    set responsabilites(value: Array<ResponsabiliteDto>) {
        this.responsabiliteService.items = value;
    }
    get createResponsabiliteDialog(): boolean {
       return this.responsabiliteService.createDialog;
    }
    set createResponsabiliteDialog(value: boolean) {
        this.responsabiliteService.createDialog= value;
    }
    get employe(): EmployeDto {
        return this.employeService.item;
    }
    set employe(value: EmployeDto) {
        this.employeService.item = value;
    }
    get employes(): Array<EmployeDto> {
        return this.employeService.items;
    }
    set employes(value: Array<EmployeDto>) {
        this.employeService.items = value;
    }
    get createEmployeDialog(): boolean {
       return this.employeService.createDialog;
    }
    set createEmployeDialog(value: boolean) {
        this.employeService.createDialog= value;
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
