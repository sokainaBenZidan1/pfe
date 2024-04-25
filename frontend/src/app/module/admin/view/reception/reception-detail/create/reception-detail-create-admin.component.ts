import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReceptionDetailAdminService} from 'src/app/shared/service/admin/reception/ReceptionDetailAdmin.service';
import {ReceptionDetailDto} from 'src/app/shared/model/reception/ReceptionDetail.model';
import {ReceptionDetailCriteria} from 'src/app/shared/criteria/reception/ReceptionDetailCriteria.model';
import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-reception-detail-create-admin',
  templateUrl: './reception-detail-create-admin.component.html'
})
export class ReceptionDetailCreateAdminComponent extends AbstractCreateController<ReceptionDetailDto, ReceptionDetailCriteria, ReceptionDetailAdminService>  implements OnInit {



   private _validReceptionDetailQte = true;
   private _validReceptionDetailMagasin = true;
   private _validReceptionDetailProduit = true;
   private _validReceptionDetailReception = true;
    private _validMagasinCode = true;
    private _validProduitCode = true;
    private _validProduitLibelle = true;
    private _validReceptionRef = true;
    private _validReceptionCommande = true;

    constructor( private receptionDetailService: ReceptionDetailAdminService , private magasinService: MagasinAdminService, private receptionService: ReceptionAdminService, private produitService: ProduitAdminService) {
        super(receptionDetailService);
    }

    ngOnInit(): void {
        this.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.reception = new ReceptionDto();
        this.receptionService.findAll().subscribe((data) => this.receptions = data);
    }





    public override setValidation(value: boolean){
        this.validReceptionDetailQte = value;
        this.validReceptionDetailMagasin = value;
        this.validReceptionDetailProduit = value;
        this.validReceptionDetailReception = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReceptionDetailQte();
        this.validateReceptionDetailMagasin();
        this.validateReceptionDetailProduit();
        this.validateReceptionDetailReception();
    }

    public validateReceptionDetailQte(){
        if (this.stringUtilService.isEmpty(this.item.qte)) {
        this.errorMessages.push('Qte non valide');
        this.validReceptionDetailQte = false;
        } else {
            this.validReceptionDetailQte = true;
        }
    }
    public validateReceptionDetailMagasin(){
        if (this.stringUtilService.isEmpty(this.item.magasin)) {
        this.errorMessages.push('Magasin non valide');
        this.validReceptionDetailMagasin = false;
        } else {
            this.validReceptionDetailMagasin = true;
        }
    }
    public validateReceptionDetailProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validReceptionDetailProduit = false;
        } else {
            this.validReceptionDetailProduit = true;
        }
    }
    public validateReceptionDetailReception(){
        if (this.stringUtilService.isEmpty(this.item.reception)) {
        this.errorMessages.push('Reception non valide');
        this.validReceptionDetailReception = false;
        } else {
            this.validReceptionDetailReception = true;
        }
    }


    public async openCreateReception(reception: string) {
    const isPermistted = await this.roleService.isPermitted('Reception', 'add');
    if(isPermistted) {
         this.reception = new ReceptionDto();
         this.createReceptionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get reception(): ReceptionDto {
        return this.receptionService.item;
    }
    set reception(value: ReceptionDto) {
        this.receptionService.item = value;
    }
    get receptions(): Array<ReceptionDto> {
        return this.receptionService.items;
    }
    set receptions(value: Array<ReceptionDto>) {
        this.receptionService.items = value;
    }
    get createReceptionDialog(): boolean {
       return this.receptionService.createDialog;
    }
    set createReceptionDialog(value: boolean) {
        this.receptionService.createDialog= value;
    }
    get magasin(): MagasinDto {
        return this.magasinService.item;
    }
    set magasin(value: MagasinDto) {
        this.magasinService.item = value;
    }
    get magasins(): Array<MagasinDto> {
        return this.magasinService.items;
    }
    set magasins(value: Array<MagasinDto>) {
        this.magasinService.items = value;
    }
    get createMagasinDialog(): boolean {
       return this.magasinService.createDialog;
    }
    set createMagasinDialog(value: boolean) {
        this.magasinService.createDialog= value;
    }



    get validReceptionDetailQte(): boolean {
        return this._validReceptionDetailQte;
    }

    set validReceptionDetailQte(value: boolean) {
         this._validReceptionDetailQte = value;
    }
    get validReceptionDetailMagasin(): boolean {
        return this._validReceptionDetailMagasin;
    }

    set validReceptionDetailMagasin(value: boolean) {
         this._validReceptionDetailMagasin = value;
    }
    get validReceptionDetailProduit(): boolean {
        return this._validReceptionDetailProduit;
    }

    set validReceptionDetailProduit(value: boolean) {
         this._validReceptionDetailProduit = value;
    }
    get validReceptionDetailReception(): boolean {
        return this._validReceptionDetailReception;
    }

    set validReceptionDetailReception(value: boolean) {
         this._validReceptionDetailReception = value;
    }

    get validMagasinCode(): boolean {
        return this._validMagasinCode;
    }
    set validMagasinCode(value: boolean) {
        this._validMagasinCode = value;
    }
    get validProduitCode(): boolean {
        return this._validProduitCode;
    }
    set validProduitCode(value: boolean) {
        this._validProduitCode = value;
    }
    get validProduitLibelle(): boolean {
        return this._validProduitLibelle;
    }
    set validProduitLibelle(value: boolean) {
        this._validProduitLibelle = value;
    }
    get validReceptionRef(): boolean {
        return this._validReceptionRef;
    }
    set validReceptionRef(value: boolean) {
        this._validReceptionRef = value;
    }
    get validReceptionCommande(): boolean {
        return this._validReceptionCommande;
    }
    set validReceptionCommande(value: boolean) {
        this._validReceptionCommande = value;
    }


}
