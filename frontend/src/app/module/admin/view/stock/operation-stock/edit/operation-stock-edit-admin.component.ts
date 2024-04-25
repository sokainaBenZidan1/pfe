import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {OperationStockAdminService} from 'src/app/shared/service/admin/stock/OperationStockAdmin.service';
import {OperationStockDto} from 'src/app/shared/model/stock/OperationStock.model';
import {OperationStockCriteria} from 'src/app/shared/criteria/stock/OperationStockCriteria.model';


import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {OperationStockDetailDto} from 'src/app/shared/model/stock/OperationStockDetail.model';
import {OperationStockDetailAdminService} from 'src/app/shared/service/admin/stock/OperationStockDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';

@Component({
  selector: 'app-operation-stock-edit-admin',
  templateUrl: './operation-stock-edit-admin.component.html'
})
export class OperationStockEditAdminComponent extends AbstractEditController<OperationStockDto, OperationStockCriteria, OperationStockAdminService>   implements OnInit {

    private _operationStockDetailsElement = new OperationStockDetailDto();

    private _validOperationStockRef = true;
    private _validOperationStockMagasinSource = true;
    private _validOperationStockMagasinDest = true;

    private _validMagasinSourceCode = true;
    private _validMagasinDestCode = true;
    private _validOperationStockDetailsQte = true;
    private _validOperationStockDetailsProduit = true;
    private _validOperationStockDetailsOperationStock = true;



    constructor( private operationStockService: OperationStockAdminService , private magasinService: MagasinAdminService, private operationStockDetailService: OperationStockDetailAdminService, private produitService: ProduitAdminService) {
        super(operationStockService);
    }

    ngOnInit(): void {
        this.operationStockDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.magasinSource = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasinSources = data);
        this.magasinDest = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasinDests = data);
    }
    public override prepareEdit() {
        this.item.dateOS = this.operationStockService.format(this.item.dateOS);
    }



    public validateOperationStockDetails(){
        this.errorMessages = new Array();
        this.validateOperationStockDetailsQte();
        this.validateOperationStockDetailsProduit();
        this.validateOperationStockDetailsOperationStock();
    }
    public override setValidation(value: boolean){
        this.validOperationStockRef = value;
        this.validOperationStockMagasinSource = value;
        this.validOperationStockMagasinDest = value;
        this.validOperationStockDetailsQte = value;
        this.validOperationStockDetailsProduit = value;
        this.validOperationStockDetailsOperationStock = value;
        }
   public addOperationStockDetails() {
        if( this.item.operationStockDetails == null )
            this.item.operationStockDetails = new Array<OperationStockDetailDto>();
       this.validateOperationStockDetails();
       if (this.errorMessages.length === 0) {
            if(this.operationStockDetailsElement.id == null){
                this.item.operationStockDetails.push(this.operationStockDetailsElement);
            }else{
                const index = this.item.operationStockDetails.findIndex(e => e.id == this.operationStockDetailsElement.id);
                this.item.operationStockDetails[index] = this.operationStockDetailsElement;
            }
          this.operationStockDetailsElement = new OperationStockDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteOperationStockDetails(p: OperationStockDetailDto) {
        this.item.operationStockDetails.forEach((element, index) => {
            if (element === p) { this.item.operationStockDetails.splice(index, 1); }
        });
    }

    public editOperationStockDetails(p: OperationStockDetailDto) {
        this.operationStockDetailsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateOperationStockRef();
        this.validateOperationStockMagasinSource();
        this.validateOperationStockMagasinDest();
    }
    public validateOperationStockRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
            this.errorMessages.push('Ref non valide');
            this.validOperationStockRef = false;
        } else {
            this.validOperationStockRef = true;
        }
    }
    public validateOperationStockMagasinSource(){
        if (this.stringUtilService.isEmpty(this.item.magasinSource)) {
            this.errorMessages.push('Magasin source non valide');
            this.validOperationStockMagasinSource = false;
        } else {
            this.validOperationStockMagasinSource = true;
        }
    }
    public validateOperationStockMagasinDest(){
        if (this.stringUtilService.isEmpty(this.item.magasinDest)) {
            this.errorMessages.push('Magasin dest non valide');
            this.validOperationStockMagasinDest = false;
        } else {
            this.validOperationStockMagasinDest = true;
        }
    }


    private validateOperationStockDetailsQte(){
        if (this.operationStockDetailsElement.qte == null) {
        this.errorMessages.push('Qte de la operationStockDetail est  invalide');
            this.validOperationStockDetailsQte = false;
        } else {
            this.validOperationStockDetailsQte = true;
        }
    }
    private validateOperationStockDetailsProduit(){
        if (this.operationStockDetailsElement.produit == null) {
        this.errorMessages.push('Produit de la operationStockDetail est  invalide');
            this.validOperationStockDetailsProduit = false;
        } else {
            this.validOperationStockDetailsProduit = true;
        }
    }
    private validateOperationStockDetailsOperationStock(){
        if (this.operationStockDetailsElement.operationStock == null) {
        this.errorMessages.push('OperationStock de la operationStockDetail est  invalide');
            this.validOperationStockDetailsOperationStock = false;
        } else {
            this.validOperationStockDetailsOperationStock = true;
        }
    }

   public async openCreateMagasinDest(magasinDest: string) {
        const isPermistted = await this.roleService.isPermitted('Magasin', 'edit');
        if (isPermistted) {
             this.magasinDest = new MagasinDto();
             this.createMagasinDestDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateMagasinSource(magasinSource: string) {
        const isPermistted = await this.roleService.isPermitted('Magasin', 'edit');
        if (isPermistted) {
             this.magasinSource = new MagasinDto();
             this.createMagasinSourceDialog = true;
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
   get magasinDest(): MagasinDto {
       return this.magasinService.item;
   }
  set magasinDest(value: MagasinDto) {
        this.magasinService.item = value;
   }
   get magasinDests(): Array<MagasinDto> {
        return this.magasinService.items;
   }
   set magasinDests(value: Array<MagasinDto>) {
        this.magasinService.items = value;
   }
   get createMagasinDestDialog(): boolean {
       return this.magasinService.createDialog;
   }
  set createMagasinDestDialog(value: boolean) {
       this.magasinService.createDialog= value;
   }
   get magasinSource(): MagasinDto {
       return this.magasinService.item;
   }
  set magasinSource(value: MagasinDto) {
        this.magasinService.item = value;
   }
   get magasinSources(): Array<MagasinDto> {
        return this.magasinService.items;
   }
   set magasinSources(value: Array<MagasinDto>) {
        this.magasinService.items = value;
   }
   get createMagasinSourceDialog(): boolean {
       return this.magasinService.createDialog;
   }
  set createMagasinSourceDialog(value: boolean) {
       this.magasinService.createDialog= value;
   }

    get operationStockDetailsElement(): OperationStockDetailDto {
        if( this._operationStockDetailsElement == null )
            this._operationStockDetailsElement = new OperationStockDetailDto();
         return this._operationStockDetailsElement;
    }

    set operationStockDetailsElement(value: OperationStockDetailDto) {
        this._operationStockDetailsElement = value;
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

    get validMagasinSourceCode(): boolean {
        return this._validMagasinSourceCode;
    }
    set validMagasinSourceCode(value: boolean) {
        this._validMagasinSourceCode = value;
    }
    get validMagasinDestCode(): boolean {
        return this._validMagasinDestCode;
    }
    set validMagasinDestCode(value: boolean) {
        this._validMagasinDestCode = value;
    }
    get validOperationStockDetailsQte(): boolean {
        return this._validOperationStockDetailsQte;
    }
    set validOperationStockDetailsQte(value: boolean) {
        this._validOperationStockDetailsQte = value;
    }
    get validOperationStockDetailsProduit(): boolean {
        return this._validOperationStockDetailsProduit;
    }
    set validOperationStockDetailsProduit(value: boolean) {
        this._validOperationStockDetailsProduit = value;
    }
    get validOperationStockDetailsOperationStock(): boolean {
        return this._validOperationStockDetailsOperationStock;
    }
    set validOperationStockDetailsOperationStock(value: boolean) {
        this._validOperationStockDetailsOperationStock = value;
    }
}
