import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {InventaireDetailAdminService} from 'src/app/shared/service/admin/inventaire/InventaireDetailAdmin.service';
import {InventaireDetailDto} from 'src/app/shared/model/inventaire/InventaireDetail.model';
import {InventaireDetailCriteria} from 'src/app/shared/criteria/inventaire/InventaireDetailCriteria.model';


import {InventaireDto} from 'src/app/shared/model/inventaire/Inventaire.model';
import {InventaireAdminService} from 'src/app/shared/service/admin/inventaire/InventaireAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';

@Component({
  selector: 'app-inventaire-detail-edit-admin',
  templateUrl: './inventaire-detail-edit-admin.component.html'
})
export class InventaireDetailEditAdminComponent extends AbstractEditController<InventaireDetailDto, InventaireDetailCriteria, InventaireDetailAdminService>   implements OnInit {


    private _validInventaireDetailQteCalculee = true;
    private _validInventaireDetailQteStock = true;
    private _validInventaireDetailEcart = true;
    private _validInventaireDetailMagasin = true;
    private _validInventaireDetailProduit = true;
    private _validInventaireDetailInventaire = true;

    private _validProduitCode = true;
    private _validProduitLibelle = true;
    private _validInventaireResponsableInv = true;



    constructor( private inventaireDetailService: InventaireDetailAdminService , private inventaireService: InventaireAdminService, private produitService: ProduitAdminService) {
        super(inventaireDetailService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.inventaire = new InventaireDto();
        this.inventaireService.findAll().subscribe((data) => this.inventaires = data);
    }


    public override setValidation(value: boolean){
        this.validInventaireDetailQteCalculee = value;
        this.validInventaireDetailQteStock = value;
        this.validInventaireDetailEcart = value;
        this.validInventaireDetailMagasin = value;
        this.validInventaireDetailProduit = value;
        this.validInventaireDetailInventaire = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInventaireDetailQteCalculee();
        this.validateInventaireDetailQteStock();
        this.validateInventaireDetailEcart();
        this.validateInventaireDetailMagasin();
        this.validateInventaireDetailProduit();
        this.validateInventaireDetailInventaire();
    }
    public validateInventaireDetailQteCalculee(){
        if (this.stringUtilService.isEmpty(this.item.qteCalculee)) {
            this.errorMessages.push('Qte calculee non valide');
            this.validInventaireDetailQteCalculee = false;
        } else {
            this.validInventaireDetailQteCalculee = true;
        }
    }
    public validateInventaireDetailQteStock(){
        if (this.stringUtilService.isEmpty(this.item.qteStock)) {
            this.errorMessages.push('Qte stock non valide');
            this.validInventaireDetailQteStock = false;
        } else {
            this.validInventaireDetailQteStock = true;
        }
    }
    public validateInventaireDetailEcart(){
        if (this.stringUtilService.isEmpty(this.item.ecart)) {
            this.errorMessages.push('Ecart non valide');
            this.validInventaireDetailEcart = false;
        } else {
            this.validInventaireDetailEcart = true;
        }
    }
    public validateInventaireDetailMagasin(){
        if (this.stringUtilService.isEmpty(this.item.magasin)) {
            this.errorMessages.push('Magasin non valide');
            this.validInventaireDetailMagasin = false;
        } else {
            this.validInventaireDetailMagasin = true;
        }
    }
    public validateInventaireDetailProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validInventaireDetailProduit = false;
        } else {
            this.validInventaireDetailProduit = true;
        }
    }
    public validateInventaireDetailInventaire(){
        if (this.stringUtilService.isEmpty(this.item.inventaire)) {
            this.errorMessages.push('Inventaire non valide');
            this.validInventaireDetailInventaire = false;
        } else {
            this.validInventaireDetailInventaire = true;
        }
    }



   public async openCreateInventaire(inventaire: string) {
        const isPermistted = await this.roleService.isPermitted('Inventaire', 'edit');
        if (isPermistted) {
             this.inventaire = new InventaireDto();
             this.createInventaireDialog = true;
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
   get inventaire(): InventaireDto {
       return this.inventaireService.item;
   }
  set inventaire(value: InventaireDto) {
        this.inventaireService.item = value;
   }
   get inventaires(): Array<InventaireDto> {
        return this.inventaireService.items;
   }
   set inventaires(value: Array<InventaireDto>) {
        this.inventaireService.items = value;
   }
   get createInventaireDialog(): boolean {
       return this.inventaireService.createDialog;
   }
  set createInventaireDialog(value: boolean) {
       this.inventaireService.createDialog= value;
   }


    get validInventaireDetailQteCalculee(): boolean {
        return this._validInventaireDetailQteCalculee;
    }
    set validInventaireDetailQteCalculee(value: boolean) {
        this._validInventaireDetailQteCalculee = value;
    }
    get validInventaireDetailQteStock(): boolean {
        return this._validInventaireDetailQteStock;
    }
    set validInventaireDetailQteStock(value: boolean) {
        this._validInventaireDetailQteStock = value;
    }
    get validInventaireDetailEcart(): boolean {
        return this._validInventaireDetailEcart;
    }
    set validInventaireDetailEcart(value: boolean) {
        this._validInventaireDetailEcart = value;
    }
    get validInventaireDetailMagasin(): boolean {
        return this._validInventaireDetailMagasin;
    }
    set validInventaireDetailMagasin(value: boolean) {
        this._validInventaireDetailMagasin = value;
    }
    get validInventaireDetailProduit(): boolean {
        return this._validInventaireDetailProduit;
    }
    set validInventaireDetailProduit(value: boolean) {
        this._validInventaireDetailProduit = value;
    }
    get validInventaireDetailInventaire(): boolean {
        return this._validInventaireDetailInventaire;
    }
    set validInventaireDetailInventaire(value: boolean) {
        this._validInventaireDetailInventaire = value;
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
    get validInventaireResponsableInv(): boolean {
        return this._validInventaireResponsableInv;
    }
    set validInventaireResponsableInv(value: boolean) {
        this._validInventaireResponsableInv = value;
    }
}
