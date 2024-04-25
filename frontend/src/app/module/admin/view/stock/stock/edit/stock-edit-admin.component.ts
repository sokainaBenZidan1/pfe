import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StockAdminService} from 'src/app/shared/service/admin/stock/StockAdmin.service';
import {StockDto} from 'src/app/shared/model/stock/Stock.model';
import {StockCriteria} from 'src/app/shared/criteria/stock/StockCriteria.model';


import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';

@Component({
  selector: 'app-stock-edit-admin',
  templateUrl: './stock-edit-admin.component.html'
})
export class StockEditAdminComponent extends AbstractEditController<StockDto, StockCriteria, StockAdminService>   implements OnInit {


    private _validStockQte = true;
    private _validStockQteDeffectueuse = true;
    private _validStockMagasin = true;
    private _validStockProduit = true;

    private _validMagasinCode = true;
    private _validProduitCode = true;
    private _validProduitLibelle = true;



    constructor( private stockService: StockAdminService , private magasinService: MagasinAdminService, private produitService: ProduitAdminService) {
        super(stockService);
    }

    ngOnInit(): void {
        this.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
    }


    public override setValidation(value: boolean){
        this.validStockQte = value;
        this.validStockQteDeffectueuse = value;
        this.validStockMagasin = value;
        this.validStockProduit = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStockQte();
        this.validateStockQteDeffectueuse();
        this.validateStockMagasin();
        this.validateStockProduit();
    }
    public validateStockQte(){
        if (this.stringUtilService.isEmpty(this.item.qte)) {
            this.errorMessages.push('Qte non valide');
            this.validStockQte = false;
        } else {
            this.validStockQte = true;
        }
    }
    public validateStockQteDeffectueuse(){
        if (this.stringUtilService.isEmpty(this.item.qteDeffectueuse)) {
            this.errorMessages.push('Qte deffectueuse non valide');
            this.validStockQteDeffectueuse = false;
        } else {
            this.validStockQteDeffectueuse = true;
        }
    }
    public validateStockMagasin(){
        if (this.stringUtilService.isEmpty(this.item.magasin)) {
            this.errorMessages.push('Magasin non valide');
            this.validStockMagasin = false;
        } else {
            this.validStockMagasin = true;
        }
    }
    public validateStockProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validStockProduit = false;
        } else {
            this.validStockProduit = true;
        }
    }



   public async openCreateMagasin(magasin: string) {
        const isPermistted = await this.roleService.isPermitted('Magasin', 'edit');
        if (isPermistted) {
             this.magasin = new MagasinDto();
             this.createMagasinDialog = true;
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


    get validStockQte(): boolean {
        return this._validStockQte;
    }
    set validStockQte(value: boolean) {
        this._validStockQte = value;
    }
    get validStockQteDeffectueuse(): boolean {
        return this._validStockQteDeffectueuse;
    }
    set validStockQteDeffectueuse(value: boolean) {
        this._validStockQteDeffectueuse = value;
    }
    get validStockMagasin(): boolean {
        return this._validStockMagasin;
    }
    set validStockMagasin(value: boolean) {
        this._validStockMagasin = value;
    }
    get validStockProduit(): boolean {
        return this._validStockProduit;
    }
    set validStockProduit(value: boolean) {
        this._validStockProduit = value;
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
}
