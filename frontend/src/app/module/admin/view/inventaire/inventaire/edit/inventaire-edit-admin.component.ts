import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {InventaireAdminService} from 'src/app/shared/service/admin/inventaire/InventaireAdmin.service';
import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireCriteria} from 'src/app/shared/criteria/inventaire/InventaireCriteria.model';


import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireAdminService} from 'src/app/shared/service/admin/inventaire/ResponsableInventaireAdmin.service';
import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailAdminService} from 'src/app/shared/service/admin/inventaire/InventaireDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';

@Component({
  selector: 'app-inventaire-edit-admin',
  templateUrl: './inventaire-edit-admin.component.html'
})
export class InventaireEditAdminComponent extends AbstractEditController<InventaireDto, InventaireCriteria, InventaireAdminService>   implements OnInit {

    private _inventaireDetailsElement = new InventaireDetailDto();

    private _validInventaireResponsableInv = true;

    private _validResponsableInvNom = true;
    private _validResponsableInvPrenom = true;
    private _validResponsableInvLogin = true;
    private _validResponsableInvMdp = true;
    private _validInventaireDetailsQteCalculee = true;
    private _validInventaireDetailsQteStock = true;
    private _validInventaireDetailsEcart = true;
    private _validInventaireDetailsMagasin = true;
    private _validInventaireDetailsProduit = true;
    private _validInventaireDetailsInventaire = true;



    constructor( private inventaireService: InventaireAdminService , private responsableInventaireService: ResponsableInventaireAdminService, private inventaireDetailService: InventaireDetailAdminService, private produitService: ProduitAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.inventaireDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.responsableInv = new ResponsableInventaireDto();
        this.responsableInventaireService.findAll().subscribe((data) => this.responsableInvs = data);
    }
    public override prepareEdit() {
        this.item.dateDebut = this.inventaireService.format(this.item.dateDebut);
        this.item.dateFin = this.inventaireService.format(this.item.dateFin);
    }



    public validateInventaireDetails(){
        this.errorMessages = new Array();
        this.validateInventaireDetailsQteCalculee();
        this.validateInventaireDetailsQteStock();
        this.validateInventaireDetailsEcart();
        this.validateInventaireDetailsMagasin();
        this.validateInventaireDetailsProduit();
        this.validateInventaireDetailsInventaire();
    }
    public override setValidation(value: boolean){
        this.validInventaireResponsableInv = value;
        this.validInventaireDetailsQteCalculee = value;
        this.validInventaireDetailsQteStock = value;
        this.validInventaireDetailsEcart = value;
        this.validInventaireDetailsMagasin = value;
        this.validInventaireDetailsProduit = value;
        this.validInventaireDetailsInventaire = value;
        }
   public addInventaireDetails() {
        if( this.item.inventaireDetails == null )
            this.item.inventaireDetails = new Array<InventaireDetailDto>();
       this.validateInventaireDetails();
       if (this.errorMessages.length === 0) {
            if(this.inventaireDetailsElement.id == null){
                this.item.inventaireDetails.push(this.inventaireDetailsElement);
            }else{
                const index = this.item.inventaireDetails.findIndex(e => e.id == this.inventaireDetailsElement.id);
                this.item.inventaireDetails[index] = this.inventaireDetailsElement;
            }
          this.inventaireDetailsElement = new InventaireDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteInventaireDetails(p: InventaireDetailDto) {
        this.item.inventaireDetails.forEach((element, index) => {
            if (element === p) { this.item.inventaireDetails.splice(index, 1); }
        });
    }

    public editInventaireDetails(p: InventaireDetailDto) {
        this.inventaireDetailsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInventaireResponsableInv();
    }
    public validateInventaireResponsableInv(){
        if (this.stringUtilService.isEmpty(this.item.responsableInv)) {
            this.errorMessages.push('Responsable inv non valide');
            this.validInventaireResponsableInv = false;
        } else {
            this.validInventaireResponsableInv = true;
        }
    }


    private validateInventaireDetailsQteCalculee(){
        if (this.inventaireDetailsElement.qteCalculee == null) {
        this.errorMessages.push('QteCalculee de la inventaireDetail est  invalide');
            this.validInventaireDetailsQteCalculee = false;
        } else {
            this.validInventaireDetailsQteCalculee = true;
        }
    }
    private validateInventaireDetailsQteStock(){
        if (this.inventaireDetailsElement.qteStock == null) {
        this.errorMessages.push('QteStock de la inventaireDetail est  invalide');
            this.validInventaireDetailsQteStock = false;
        } else {
            this.validInventaireDetailsQteStock = true;
        }
    }
    private validateInventaireDetailsEcart(){
        if (this.inventaireDetailsElement.ecart == null) {
        this.errorMessages.push('Ecart de la inventaireDetail est  invalide');
            this.validInventaireDetailsEcart = false;
        } else {
            this.validInventaireDetailsEcart = true;
        }
    }
    private validateInventaireDetailsMagasin(){
        if (this.inventaireDetailsElement.magasin == null) {
        this.errorMessages.push('Magasin de la inventaireDetail est  invalide');
            this.validInventaireDetailsMagasin = false;
        } else {
            this.validInventaireDetailsMagasin = true;
        }
    }
    private validateInventaireDetailsProduit(){
        if (this.inventaireDetailsElement.produit == null) {
        this.errorMessages.push('Produit de la inventaireDetail est  invalide');
            this.validInventaireDetailsProduit = false;
        } else {
            this.validInventaireDetailsProduit = true;
        }
    }
    private validateInventaireDetailsInventaire(){
        if (this.inventaireDetailsElement.inventaire == null) {
        this.errorMessages.push('Inventaire de la inventaireDetail est  invalide');
            this.validInventaireDetailsInventaire = false;
        } else {
            this.validInventaireDetailsInventaire = true;
        }
    }

   public async openCreateResponsableInv(responsableInv: string) {
        const isPermistted = await this.roleService.isPermitted('ResponsableInventaire', 'edit');
        if (isPermistted) {
             this.responsableInv = new ResponsableInventaireDto();
             this.createResponsableInvDialog = true;
        }else {
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
   get responsableInv(): ResponsableInventaireDto {
       return this.responsableInventaireService.item;
   }
  set responsableInv(value: ResponsableInventaireDto) {
        this.responsableInventaireService.item = value;
   }
   get responsableInvs(): Array<ResponsableInventaireDto> {
        return this.responsableInventaireService.items;
   }
   set responsableInvs(value: Array<ResponsableInventaireDto>) {
        this.responsableInventaireService.items = value;
   }
   get createResponsableInvDialog(): boolean {
       return this.responsableInventaireService.createDialog;
   }
  set createResponsableInvDialog(value: boolean) {
       this.responsableInventaireService.createDialog= value;
   }

    get inventaireDetailsElement(): InventaireDetailDto {
        if( this._inventaireDetailsElement == null )
            this._inventaireDetailsElement = new InventaireDetailDto();
         return this._inventaireDetailsElement;
    }

    set inventaireDetailsElement(value: InventaireDetailDto) {
        this._inventaireDetailsElement = value;
    }

    get validInventaireResponsableInv(): boolean {
        return this._validInventaireResponsableInv;
    }
    set validInventaireResponsableInv(value: boolean) {
        this._validInventaireResponsableInv = value;
    }

    get validResponsableInvNom(): boolean {
        return this._validResponsableInvNom;
    }
    set validResponsableInvNom(value: boolean) {
        this._validResponsableInvNom = value;
    }
    get validResponsableInvPrenom(): boolean {
        return this._validResponsableInvPrenom;
    }
    set validResponsableInvPrenom(value: boolean) {
        this._validResponsableInvPrenom = value;
    }
    get validResponsableInvLogin(): boolean {
        return this._validResponsableInvLogin;
    }
    set validResponsableInvLogin(value: boolean) {
        this._validResponsableInvLogin = value;
    }
    get validResponsableInvMdp(): boolean {
        return this._validResponsableInvMdp;
    }
    set validResponsableInvMdp(value: boolean) {
        this._validResponsableInvMdp = value;
    }
    get validInventaireDetailsQteCalculee(): boolean {
        return this._validInventaireDetailsQteCalculee;
    }
    set validInventaireDetailsQteCalculee(value: boolean) {
        this._validInventaireDetailsQteCalculee = value;
    }
    get validInventaireDetailsQteStock(): boolean {
        return this._validInventaireDetailsQteStock;
    }
    set validInventaireDetailsQteStock(value: boolean) {
        this._validInventaireDetailsQteStock = value;
    }
    get validInventaireDetailsEcart(): boolean {
        return this._validInventaireDetailsEcart;
    }
    set validInventaireDetailsEcart(value: boolean) {
        this._validInventaireDetailsEcart = value;
    }
    get validInventaireDetailsMagasin(): boolean {
        return this._validInventaireDetailsMagasin;
    }
    set validInventaireDetailsMagasin(value: boolean) {
        this._validInventaireDetailsMagasin = value;
    }
    get validInventaireDetailsProduit(): boolean {
        return this._validInventaireDetailsProduit;
    }
    set validInventaireDetailsProduit(value: boolean) {
        this._validInventaireDetailsProduit = value;
    }
    get validInventaireDetailsInventaire(): boolean {
        return this._validInventaireDetailsInventaire;
    }
    set validInventaireDetailsInventaire(value: boolean) {
        this._validInventaireDetailsInventaire = value;
    }
}
