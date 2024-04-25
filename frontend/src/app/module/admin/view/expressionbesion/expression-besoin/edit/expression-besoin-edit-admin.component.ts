import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ExpressionBesoinAdminService} from 'src/app/shared/service/admin/expressionbesion/ExpressionBesoinAdmin.service';
import {ExpressionBesoinDto} from 'src/app/shared/model/expressionbesion/ExpressionBesoin.model';
import {ExpressionBesoinCriteria} from 'src/app/shared/criteria/expressionbesion/ExpressionBesoinCriteria.model';


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
  selector: 'app-expression-besoin-edit-admin',
  templateUrl: './expression-besoin-edit-admin.component.html'
})
export class ExpressionBesoinEditAdminComponent extends AbstractEditController<ExpressionBesoinDto, ExpressionBesoinCriteria, ExpressionBesoinAdminService>   implements OnInit {

    private _expressionBesoinDetailsElement = new ExpressionBesoinDetailDto();


    private _validEmployeNom = true;
    private _validEmployePrenom = true;
    private _validEntiteAdminCode = true;
    private _validEntiteAdminLibelle = true;
    private _validEtatCode = true;
    private _validEtatLibelle = true;



    constructor( private expressionBesoinService: ExpressionBesoinAdminService , private entiteAdminService: EntiteAdminAdminService, private etatService: EtatAdminService, private expressionBesoinDetailService: ExpressionBesoinDetailAdminService, private employeService: EmployeAdminService, private produitService: ProduitAdminService) {
        super(expressionBesoinService);
    }

    ngOnInit(): void {
        this.expressionBesoinDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.employe = new EmployeDto();
        this.employeService.findAll().subscribe((data) => this.employes = data);
        this.entiteAdmin = new EntiteAdminDto();
        this.entiteAdminService.findAll().subscribe((data) => this.entiteAdmins = data);
        this.etat = new EtatDto();
        this.etatService.findAll().subscribe((data) => this.etats = data);
    }
    public override prepareEdit() {
        this.item.dateExpression = this.expressionBesoinService.format(this.item.dateExpression);
    }



    public validateExpressionBesoinDetails(){
        this.errorMessages = new Array();
    }
    public override setValidation(value: boolean){
        }
   public addExpressionBesoinDetails() {
        if( this.item.expressionBesoinDetails == null )
            this.item.expressionBesoinDetails = new Array<ExpressionBesoinDetailDto>();
       this.validateExpressionBesoinDetails();
       if (this.errorMessages.length === 0) {
            if(this.expressionBesoinDetailsElement.id == null){
                this.item.expressionBesoinDetails.push(this.expressionBesoinDetailsElement);
            }else{
                const index = this.item.expressionBesoinDetails.findIndex(e => e.id == this.expressionBesoinDetailsElement.id);
                this.item.expressionBesoinDetails[index] = this.expressionBesoinDetailsElement;
            }
          this.expressionBesoinDetailsElement = new ExpressionBesoinDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteExpressionBesoinDetails(p: ExpressionBesoinDetailDto) {
        this.item.expressionBesoinDetails.forEach((element, index) => {
            if (element === p) { this.item.expressionBesoinDetails.splice(index, 1); }
        });
    }

    public editExpressionBesoinDetails(p: ExpressionBesoinDetailDto) {
        this.expressionBesoinDetailsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateEtat(etat: string) {
        const isPermistted = await this.roleService.isPermitted('Etat', 'edit');
        if (isPermistted) {
             this.etat = new EtatDto();
             this.createEtatDialog = true;
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
   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get etat(): EtatDto {
       return this.etatService.item;
   }
  set etat(value: EtatDto) {
        this.etatService.item = value;
   }
   get etats(): Array<EtatDto> {
        return this.etatService.items;
   }
   set etats(value: Array<EtatDto>) {
        this.etatService.items = value;
   }
   get createEtatDialog(): boolean {
       return this.etatService.createDialog;
   }
  set createEtatDialog(value: boolean) {
       this.etatService.createDialog= value;
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

    get expressionBesoinDetailsElement(): ExpressionBesoinDetailDto {
        if( this._expressionBesoinDetailsElement == null )
            this._expressionBesoinDetailsElement = new ExpressionBesoinDetailDto();
         return this._expressionBesoinDetailsElement;
    }

    set expressionBesoinDetailsElement(value: ExpressionBesoinDetailDto) {
        this._expressionBesoinDetailsElement = value;
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
