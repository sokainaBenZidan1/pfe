import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {LivraisonAdminService} from 'src/app/shared/service/admin/livraison/LivraisonAdmin.service';
import {LivraisonDto} from 'src/app/shared/model/livraison/Livraison.model';
import {LivraisonCriteria} from 'src/app/shared/criteria/livraison/LivraisonCriteria.model';
import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {LivraisonDetailDto} from 'src/app/shared/model/livraison/LivraisonDetail.model';
import {LivraisonDetailAdminService} from 'src/app/shared/service/admin/livraison/LivraisonDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-livraison-create-admin',
  templateUrl: './livraison-create-admin.component.html'
})
export class LivraisonCreateAdminComponent extends AbstractCreateController<LivraisonDto, LivraisonCriteria, LivraisonAdminService>  implements OnInit {

    private _livraisonDetailsElement = new LivraisonDetailDto();


   private _validLivraisonRef = true;
   private _validLivraisonReception = true;
    private _validReceptionRef = true;
    private _validReceptionCommande = true;
    private _validLivraisonDetailsQte = true;
    private _validLivraisonDetailsMagasin = true;
    private _validLivraisonDetailsProduit = true;
    private _validLivraisonDetailsLivraison = true;

    constructor( private livraisonService: LivraisonAdminService , private magasinService: MagasinAdminService, private receptionService: ReceptionAdminService, private livraisonDetailService: LivraisonDetailAdminService, private produitService: ProduitAdminService) {
        super(livraisonService);
    }

    ngOnInit(): void {
        this.livraisonDetailsElement.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
        this.livraisonDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.reception = new ReceptionDto();
        this.receptionService.findAll().subscribe((data) => this.receptions = data);
    }



    validateLivraisonDetails(){
        this.errorMessages = new Array();
        this.validateLivraisonDetailsQte();
        this.validateLivraisonDetailsMagasin();
        this.validateLivraisonDetailsProduit();
        this.validateLivraisonDetailsLivraison();
    }


    public override setValidation(value: boolean){
        this.validLivraisonRef = value;
        this.validLivraisonReception = value;
        this.validLivraisonDetailsQte = value;
        this.validLivraisonDetailsMagasin = value;
        this.validLivraisonDetailsProduit = value;
        this.validLivraisonDetailsLivraison = value;
    }

    public addLivraisonDetails() {
        if( this.item.livraisonDetails == null )
            this.item.livraisonDetails = new Array<LivraisonDetailDto>();
       this.validateLivraisonDetails();
       if (this.errorMessages.length === 0) {
              this.item.livraisonDetails.push({... this.livraisonDetailsElement});
              this.livraisonDetailsElement = new LivraisonDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletelivraisonDetails(p: LivraisonDetailDto) {
        this.item.livraisonDetails.forEach((element, index) => {
            if (element === p) { this.item.livraisonDetails.splice(index, 1); }
        });
    }

    public editlivraisonDetails(p: LivraisonDetailDto) {
        this.livraisonDetailsElement = {... p};
        this.activeTab = 0;
    }


    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateLivraisonRef();
        this.validateLivraisonReception();
    }

    public validateLivraisonRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
        this.errorMessages.push('Ref non valide');
        this.validLivraisonRef = false;
        } else {
            this.validLivraisonRef = true;
        }
    }
    public validateLivraisonReception(){
        if (this.stringUtilService.isEmpty(this.item.reception)) {
        this.errorMessages.push('Reception non valide');
        this.validLivraisonReception = false;
        } else {
            this.validLivraisonReception = true;
        }
    }

    public validateLivraisonDetailsQte(){
        if (this.livraisonDetailsElement.qte == null) {
            this.errorMessages.push('Qte de la livraisonDetail est  invalide');
            this.validLivraisonDetailsQte = false;
        } else {
            this.validLivraisonDetailsQte = true;
        }
    }
    public validateLivraisonDetailsMagasin(){
        if (this.livraisonDetailsElement.magasin == null) {
            this.errorMessages.push('Magasin de la livraisonDetail est  invalide');
            this.validLivraisonDetailsMagasin = false;
        } else {
            this.validLivraisonDetailsMagasin = true;
        }
    }
    public validateLivraisonDetailsProduit(){
        if (this.livraisonDetailsElement.produit == null) {
            this.errorMessages.push('Produit de la livraisonDetail est  invalide');
            this.validLivraisonDetailsProduit = false;
        } else {
            this.validLivraisonDetailsProduit = true;
        }
    }
    public validateLivraisonDetailsLivraison(){
        if (this.livraisonDetailsElement.livraison == null) {
            this.errorMessages.push('Livraison de la livraisonDetail est  invalide');
            this.validLivraisonDetailsLivraison = false;
        } else {
            this.validLivraisonDetailsLivraison = true;
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



    get validLivraisonRef(): boolean {
        return this._validLivraisonRef;
    }

    set validLivraisonRef(value: boolean) {
         this._validLivraisonRef = value;
    }
    get validLivraisonReception(): boolean {
        return this._validLivraisonReception;
    }

    set validLivraisonReception(value: boolean) {
         this._validLivraisonReception = value;
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
    get validLivraisonDetailsQte(): boolean {
        return this._validLivraisonDetailsQte;
    }
    set validLivraisonDetailsQte(value: boolean) {
        this._validLivraisonDetailsQte = value;
    }
    get validLivraisonDetailsMagasin(): boolean {
        return this._validLivraisonDetailsMagasin;
    }
    set validLivraisonDetailsMagasin(value: boolean) {
        this._validLivraisonDetailsMagasin = value;
    }
    get validLivraisonDetailsProduit(): boolean {
        return this._validLivraisonDetailsProduit;
    }
    set validLivraisonDetailsProduit(value: boolean) {
        this._validLivraisonDetailsProduit = value;
    }
    get validLivraisonDetailsLivraison(): boolean {
        return this._validLivraisonDetailsLivraison;
    }
    set validLivraisonDetailsLivraison(value: boolean) {
        this._validLivraisonDetailsLivraison = value;
    }

    get livraisonDetailsElement(): LivraisonDetailDto {
        if( this._livraisonDetailsElement == null )
            this._livraisonDetailsElement = new LivraisonDetailDto();
        return this._livraisonDetailsElement;
    }

    set livraisonDetailsElement(value: LivraisonDetailDto) {
        this._livraisonDetailsElement = value;
    }

}
