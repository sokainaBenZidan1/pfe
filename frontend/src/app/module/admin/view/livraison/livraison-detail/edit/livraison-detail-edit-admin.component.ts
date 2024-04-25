import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {LivraisonDetailAdminService} from 'src/app/shared/service/admin/livraison/LivraisonDetailAdmin.service';
import {LivraisonDetailDto} from 'src/app/shared/model/livraison/LivraisonDetail.model';
import {LivraisonDetailCriteria} from 'src/app/shared/criteria/livraison/LivraisonDetailCriteria.model';


import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {LivraisonDto} from 'src/app/shared/model/livraison/Livraison.model';
import {LivraisonAdminService} from 'src/app/shared/service/admin/livraison/LivraisonAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';

@Component({
  selector: 'app-livraison-detail-edit-admin',
  templateUrl: './livraison-detail-edit-admin.component.html'
})
export class LivraisonDetailEditAdminComponent extends AbstractEditController<LivraisonDetailDto, LivraisonDetailCriteria, LivraisonDetailAdminService>   implements OnInit {


    private _validLivraisonDetailQte = true;
    private _validLivraisonDetailMagasin = true;
    private _validLivraisonDetailProduit = true;
    private _validLivraisonDetailLivraison = true;

    private _validMagasinCode = true;
    private _validProduitCode = true;
    private _validProduitLibelle = true;
    private _validLivraisonRef = true;
    private _validLivraisonReception = true;



    constructor( private livraisonDetailService: LivraisonDetailAdminService , private magasinService: MagasinAdminService, private livraisonService: LivraisonAdminService, private produitService: ProduitAdminService) {
        super(livraisonDetailService);
    }

    ngOnInit(): void {
        this.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.livraison = new LivraisonDto();
        this.livraisonService.findAll().subscribe((data) => this.livraisons = data);
    }


    public override setValidation(value: boolean){
        this.validLivraisonDetailQte = value;
        this.validLivraisonDetailMagasin = value;
        this.validLivraisonDetailProduit = value;
        this.validLivraisonDetailLivraison = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateLivraisonDetailQte();
        this.validateLivraisonDetailMagasin();
        this.validateLivraisonDetailProduit();
        this.validateLivraisonDetailLivraison();
    }
    public validateLivraisonDetailQte(){
        if (this.stringUtilService.isEmpty(this.item.qte)) {
            this.errorMessages.push('Qte non valide');
            this.validLivraisonDetailQte = false;
        } else {
            this.validLivraisonDetailQte = true;
        }
    }
    public validateLivraisonDetailMagasin(){
        if (this.stringUtilService.isEmpty(this.item.magasin)) {
            this.errorMessages.push('Magasin non valide');
            this.validLivraisonDetailMagasin = false;
        } else {
            this.validLivraisonDetailMagasin = true;
        }
    }
    public validateLivraisonDetailProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validLivraisonDetailProduit = false;
        } else {
            this.validLivraisonDetailProduit = true;
        }
    }
    public validateLivraisonDetailLivraison(){
        if (this.stringUtilService.isEmpty(this.item.livraison)) {
            this.errorMessages.push('Livraison non valide');
            this.validLivraisonDetailLivraison = false;
        } else {
            this.validLivraisonDetailLivraison = true;
        }
    }



   public async openCreateLivraison(livraison: string) {
        const isPermistted = await this.roleService.isPermitted('Livraison', 'edit');
        if (isPermistted) {
             this.livraison = new LivraisonDto();
             this.createLivraisonDialog = true;
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
   get livraison(): LivraisonDto {
       return this.livraisonService.item;
   }
  set livraison(value: LivraisonDto) {
        this.livraisonService.item = value;
   }
   get livraisons(): Array<LivraisonDto> {
        return this.livraisonService.items;
   }
   set livraisons(value: Array<LivraisonDto>) {
        this.livraisonService.items = value;
   }
   get createLivraisonDialog(): boolean {
       return this.livraisonService.createDialog;
   }
  set createLivraisonDialog(value: boolean) {
       this.livraisonService.createDialog= value;
   }


    get validLivraisonDetailQte(): boolean {
        return this._validLivraisonDetailQte;
    }
    set validLivraisonDetailQte(value: boolean) {
        this._validLivraisonDetailQte = value;
    }
    get validLivraisonDetailMagasin(): boolean {
        return this._validLivraisonDetailMagasin;
    }
    set validLivraisonDetailMagasin(value: boolean) {
        this._validLivraisonDetailMagasin = value;
    }
    get validLivraisonDetailProduit(): boolean {
        return this._validLivraisonDetailProduit;
    }
    set validLivraisonDetailProduit(value: boolean) {
        this._validLivraisonDetailProduit = value;
    }
    get validLivraisonDetailLivraison(): boolean {
        return this._validLivraisonDetailLivraison;
    }
    set validLivraisonDetailLivraison(value: boolean) {
        this._validLivraisonDetailLivraison = value;
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
}
