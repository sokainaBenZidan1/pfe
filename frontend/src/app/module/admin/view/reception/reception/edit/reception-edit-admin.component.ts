import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ReceptionAdminService} from 'src/app/shared/service/admin/reception/ReceptionAdmin.service';
import {ReceptionDto} from 'src/app/shared/model/reception/Reception.model';
import {ReceptionCriteria} from 'src/app/shared/criteria/reception/ReceptionCriteria.model';


import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {ReceptionDetailDto} from 'src/app/shared/model/reception/ReceptionDetail.model';
import {ReceptionDetailAdminService} from 'src/app/shared/service/admin/reception/ReceptionDetailAdmin.service';

@Component({
  selector: 'app-reception-edit-admin',
  templateUrl: './reception-edit-admin.component.html'
})
export class ReceptionEditAdminComponent extends AbstractEditController<ReceptionDto, ReceptionCriteria, ReceptionAdminService>   implements OnInit {

    private _receptionDetailsElement = new ReceptionDetailDto();

    private _validReceptionRef = true;
    private _validReceptionCommande = true;

    private _validCommandeRef = true;
    private _validCommandeTotal = true;
    private _validCommandeTotalPaye = true;
    private _validReceptionDetailsQte = true;
    private _validReceptionDetailsMagasin = true;
    private _validReceptionDetailsProduit = true;
    private _validReceptionDetailsReception = true;



    constructor( private receptionService: ReceptionAdminService , private magasinService: MagasinAdminService, private commandeService: CommandeAdminService, private produitService: ProduitAdminService, private receptionDetailService: ReceptionDetailAdminService) {
        super(receptionService);
    }

    ngOnInit(): void {
        this.receptionDetailsElement.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
        this.receptionDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.commande = new CommandeDto();
        this.commandeService.findAll().subscribe((data) => this.commandes = data);
    }
    public override prepareEdit() {
        this.item.dateReception = this.receptionService.format(this.item.dateReception);
    }



    public validateReceptionDetails(){
        this.errorMessages = new Array();
        this.validateReceptionDetailsQte();
        this.validateReceptionDetailsMagasin();
        this.validateReceptionDetailsProduit();
        this.validateReceptionDetailsReception();
    }
    public override setValidation(value: boolean){
        this.validReceptionRef = value;
        this.validReceptionCommande = value;
        this.validReceptionDetailsQte = value;
        this.validReceptionDetailsMagasin = value;
        this.validReceptionDetailsProduit = value;
        this.validReceptionDetailsReception = value;
        }
   public addReceptionDetails() {
        if( this.item.receptionDetails == null )
            this.item.receptionDetails = new Array<ReceptionDetailDto>();
       this.validateReceptionDetails();
       if (this.errorMessages.length === 0) {
            if(this.receptionDetailsElement.id == null){
                this.item.receptionDetails.push(this.receptionDetailsElement);
            }else{
                const index = this.item.receptionDetails.findIndex(e => e.id == this.receptionDetailsElement.id);
                this.item.receptionDetails[index] = this.receptionDetailsElement;
            }
          this.receptionDetailsElement = new ReceptionDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteReceptionDetails(p: ReceptionDetailDto) {
        this.item.receptionDetails.forEach((element, index) => {
            if (element === p) { this.item.receptionDetails.splice(index, 1); }
        });
    }

    public editReceptionDetails(p: ReceptionDetailDto) {
        this.receptionDetailsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReceptionRef();
        this.validateReceptionCommande();
    }
    public validateReceptionRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
            this.errorMessages.push('Ref non valide');
            this.validReceptionRef = false;
        } else {
            this.validReceptionRef = true;
        }
    }
    public validateReceptionCommande(){
        if (this.stringUtilService.isEmpty(this.item.commande)) {
            this.errorMessages.push('Commande non valide');
            this.validReceptionCommande = false;
        } else {
            this.validReceptionCommande = true;
        }
    }


    private validateReceptionDetailsQte(){
        if (this.receptionDetailsElement.qte == null) {
        this.errorMessages.push('Qte de la receptionDetail est  invalide');
            this.validReceptionDetailsQte = false;
        } else {
            this.validReceptionDetailsQte = true;
        }
    }
    private validateReceptionDetailsMagasin(){
        if (this.receptionDetailsElement.magasin == null) {
        this.errorMessages.push('Magasin de la receptionDetail est  invalide');
            this.validReceptionDetailsMagasin = false;
        } else {
            this.validReceptionDetailsMagasin = true;
        }
    }
    private validateReceptionDetailsProduit(){
        if (this.receptionDetailsElement.produit == null) {
        this.errorMessages.push('Produit de la receptionDetail est  invalide');
            this.validReceptionDetailsProduit = false;
        } else {
            this.validReceptionDetailsProduit = true;
        }
    }
    private validateReceptionDetailsReception(){
        if (this.receptionDetailsElement.reception == null) {
        this.errorMessages.push('Reception de la receptionDetail est  invalide');
            this.validReceptionDetailsReception = false;
        } else {
            this.validReceptionDetailsReception = true;
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
   get commande(): CommandeDto {
       return this.commandeService.item;
   }
  set commande(value: CommandeDto) {
        this.commandeService.item = value;
   }
   get commandes(): Array<CommandeDto> {
        return this.commandeService.items;
   }
   set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
   }
   get createCommandeDialog(): boolean {
       return this.commandeService.createDialog;
   }
  set createCommandeDialog(value: boolean) {
       this.commandeService.createDialog= value;
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

    get receptionDetailsElement(): ReceptionDetailDto {
        if( this._receptionDetailsElement == null )
            this._receptionDetailsElement = new ReceptionDetailDto();
         return this._receptionDetailsElement;
    }

    set receptionDetailsElement(value: ReceptionDetailDto) {
        this._receptionDetailsElement = value;
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

    get validCommandeRef(): boolean {
        return this._validCommandeRef;
    }
    set validCommandeRef(value: boolean) {
        this._validCommandeRef = value;
    }
    get validCommandeTotal(): boolean {
        return this._validCommandeTotal;
    }
    set validCommandeTotal(value: boolean) {
        this._validCommandeTotal = value;
    }
    get validCommandeTotalPaye(): boolean {
        return this._validCommandeTotalPaye;
    }
    set validCommandeTotalPaye(value: boolean) {
        this._validCommandeTotalPaye = value;
    }
    get validReceptionDetailsQte(): boolean {
        return this._validReceptionDetailsQte;
    }
    set validReceptionDetailsQte(value: boolean) {
        this._validReceptionDetailsQte = value;
    }
    get validReceptionDetailsMagasin(): boolean {
        return this._validReceptionDetailsMagasin;
    }
    set validReceptionDetailsMagasin(value: boolean) {
        this._validReceptionDetailsMagasin = value;
    }
    get validReceptionDetailsProduit(): boolean {
        return this._validReceptionDetailsProduit;
    }
    set validReceptionDetailsProduit(value: boolean) {
        this._validReceptionDetailsProduit = value;
    }
    get validReceptionDetailsReception(): boolean {
        return this._validReceptionDetailsReception;
    }
    set validReceptionDetailsReception(value: boolean) {
        this._validReceptionDetailsReception = value;
    }
}
