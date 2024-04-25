import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CommandeDetailAdminService} from 'src/app/shared/service/admin/commande/CommandeDetailAdmin.service';
import {CommandeDetailDto} from 'src/app/shared/model/commande/CommandeDetail.model';
import {CommandeDetailCriteria} from 'src/app/shared/criteria/commande/CommandeDetailCriteria.model';
import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-commande-detail-create-admin',
  templateUrl: './commande-detail-create-admin.component.html'
})
export class CommandeDetailCreateAdminComponent extends AbstractCreateController<CommandeDetailDto, CommandeDetailCriteria, CommandeDetailAdminService>  implements OnInit {



   private _validCommandeDetailPrix = true;
   private _validCommandeDetailQte = true;
   private _validCommandeDetailCommande = true;
   private _validCommandeDetailProduit = true;
    private _validCommandeRef = true;
    private _validCommandeTotal = true;
    private _validCommandeTotalPaye = true;
    private _validProduitCode = true;
    private _validProduitLibelle = true;

    constructor( private commandeDetailService: CommandeDetailAdminService , private commandeService: CommandeAdminService, private produitService: ProduitAdminService) {
        super(commandeDetailService);
    }

    ngOnInit(): void {
        this.commande = new CommandeDto();
        this.commandeService.findAll().subscribe((data) => this.commandes = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
    }





    public override setValidation(value: boolean){
        this.validCommandeDetailPrix = value;
        this.validCommandeDetailQte = value;
        this.validCommandeDetailCommande = value;
        this.validCommandeDetailProduit = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCommandeDetailPrix();
        this.validateCommandeDetailQte();
        this.validateCommandeDetailCommande();
        this.validateCommandeDetailProduit();
    }

    public validateCommandeDetailPrix(){
        if (this.stringUtilService.isEmpty(this.item.prix)) {
        this.errorMessages.push('Prix non valide');
        this.validCommandeDetailPrix = false;
        } else {
            this.validCommandeDetailPrix = true;
        }
    }
    public validateCommandeDetailQte(){
        if (this.stringUtilService.isEmpty(this.item.qte)) {
        this.errorMessages.push('Qte non valide');
        this.validCommandeDetailQte = false;
        } else {
            this.validCommandeDetailQte = true;
        }
    }
    public validateCommandeDetailCommande(){
        if (this.stringUtilService.isEmpty(this.item.commande)) {
        this.errorMessages.push('Commande non valide');
        this.validCommandeDetailCommande = false;
        } else {
            this.validCommandeDetailCommande = true;
        }
    }
    public validateCommandeDetailProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validCommandeDetailProduit = false;
        } else {
            this.validCommandeDetailProduit = true;
        }
    }


    public async openCreateCommande(commande: string) {
    const isPermistted = await this.roleService.isPermitted('Commande', 'add');
    if(isPermistted) {
         this.commande = new CommandeDto();
         this.createCommandeDialog = true;
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



    get validCommandeDetailPrix(): boolean {
        return this._validCommandeDetailPrix;
    }

    set validCommandeDetailPrix(value: boolean) {
         this._validCommandeDetailPrix = value;
    }
    get validCommandeDetailQte(): boolean {
        return this._validCommandeDetailQte;
    }

    set validCommandeDetailQte(value: boolean) {
         this._validCommandeDetailQte = value;
    }
    get validCommandeDetailCommande(): boolean {
        return this._validCommandeDetailCommande;
    }

    set validCommandeDetailCommande(value: boolean) {
         this._validCommandeDetailCommande = value;
    }
    get validCommandeDetailProduit(): boolean {
        return this._validCommandeDetailProduit;
    }

    set validCommandeDetailProduit(value: boolean) {
         this._validCommandeDetailProduit = value;
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
