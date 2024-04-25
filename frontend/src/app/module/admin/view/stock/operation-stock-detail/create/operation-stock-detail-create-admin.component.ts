import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {OperationStockDetailAdminService} from 'src/app/shared/service/admin/stock/OperationStockDetailAdmin.service';
import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailCriteria} from 'src/app/shared/criteria/stock/OperationStockDetailCriteria.model';
import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockAdminService} from 'src/app/shared/service/admin/stock/OperationStockAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-operation-stock-detail-create-admin',
  templateUrl: './operation-stock-detail-create-admin.component.html'
})
export class OperationStockDetailCreateAdminComponent extends AbstractCreateController<OperationStockDetailDto, OperationStockDetailCriteria, OperationStockDetailAdminService>  implements OnInit {



   private _validOperationStockDetailQte = true;
   private _validOperationStockDetailProduit = true;
   private _validOperationStockDetailOperationStock = true;
    private _validProduitCode = true;
    private _validProduitLibelle = true;
    private _validOperationStockRef = true;
    private _validOperationStockMagasinSource = true;
    private _validOperationStockMagasinDest = true;

    constructor( private operationStockDetailService: OperationStockDetailAdminService , private operationStockService: OperationStockAdminService, private produitService: ProduitAdminService) {
        super(operationStockDetailService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.operationStock = new OperationStockDto();
        this.operationStockService.findAll().subscribe((data) => this.operationStocks = data);
    }





    public override setValidation(value: boolean){
        this.validOperationStockDetailQte = value;
        this.validOperationStockDetailProduit = value;
        this.validOperationStockDetailOperationStock = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateOperationStockDetailQte();
        this.validateOperationStockDetailProduit();
        this.validateOperationStockDetailOperationStock();
    }

    public validateOperationStockDetailQte(){
        if (this.stringUtilService.isEmpty(this.item.qte)) {
        this.errorMessages.push('Qte non valide');
        this.validOperationStockDetailQte = false;
        } else {
            this.validOperationStockDetailQte = true;
        }
    }
    public validateOperationStockDetailProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validOperationStockDetailProduit = false;
        } else {
            this.validOperationStockDetailProduit = true;
        }
    }
    public validateOperationStockDetailOperationStock(){
        if (this.stringUtilService.isEmpty(this.item.operationStock)) {
        this.errorMessages.push('Operation stock non valide');
        this.validOperationStockDetailOperationStock = false;
        } else {
            this.validOperationStockDetailOperationStock = true;
        }
    }


    public async openCreateOperationStock(operationStock: string) {
    const isPermistted = await this.roleService.isPermitted('OperationStock', 'add');
    if(isPermistted) {
         this.operationStock = new OperationStockDto();
         this.createOperationStockDialog = true;
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
    get operationStock(): OperationStockDto {
        return this.operationStockService.item;
    }
    set operationStock(value: OperationStockDto) {
        this.operationStockService.item = value;
    }
    get operationStocks(): Array<OperationStockDto> {
        return this.operationStockService.items;
    }
    set operationStocks(value: Array<OperationStockDto>) {
        this.operationStockService.items = value;
    }
    get createOperationStockDialog(): boolean {
       return this.operationStockService.createDialog;
    }
    set createOperationStockDialog(value: boolean) {
        this.operationStockService.createDialog= value;
    }



    get validOperationStockDetailQte(): boolean {
        return this._validOperationStockDetailQte;
    }

    set validOperationStockDetailQte(value: boolean) {
         this._validOperationStockDetailQte = value;
    }
    get validOperationStockDetailProduit(): boolean {
        return this._validOperationStockDetailProduit;
    }

    set validOperationStockDetailProduit(value: boolean) {
         this._validOperationStockDetailProduit = value;
    }
    get validOperationStockDetailOperationStock(): boolean {
        return this._validOperationStockDetailOperationStock;
    }

    set validOperationStockDetailOperationStock(value: boolean) {
         this._validOperationStockDetailOperationStock = value;
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
    get validOperationStockRef(): boolean {
        return this._validOperationStockRef;
    }
    set validOperationStockRef(value: boolean) {
        this._validOperationStockRef = value;
    }
    get validOperationStockMagasinSource(): boolean {
        return this._validOperationStockMagasinSource;
    }
    set validOperationStockMagasinSource(value: boolean) {
        this._validOperationStockMagasinSource = value;
    }
    get validOperationStockMagasinDest(): boolean {
        return this._validOperationStockMagasinDest;
    }
    set validOperationStockMagasinDest(value: boolean) {
        this._validOperationStockMagasinDest = value;
    }


}
