import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CommandeAdminService} from 'src/app/shared/service/admin/commande/CommandeAdmin.service';
import {CommandeDto} from 'src/app/shared/model/commande/Commande.model';
import {CommandeCriteria} from 'src/app/shared/criteria/commande/CommandeCriteria.model';
import {EntiteAdminDto} from 'src/app/shared/model/commun/EntiteAdmin.model';
import {EntiteAdminAdminService} from 'src/app/shared/service/admin/commun/EntiteAdminAdmin.service';
import {CommandeDetailDto} from 'src/app/shared/model/commande/CommandeDetail.model';
import {CommandeDetailAdminService} from 'src/app/shared/service/admin/commande/CommandeDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
@Component({
  selector: 'app-commande-create-admin',
  templateUrl: './commande-create-admin.component.html'
})
export class CommandeCreateAdminComponent extends AbstractCreateController<CommandeDto, CommandeCriteria, CommandeAdminService>  implements OnInit {

    private _commandeDetailsElement = new CommandeDetailDto();


   private _validCommandeRef = true;
   private _validCommandeTotal = true;
   private _validCommandeTotalPaye = true;
    private _validCommandeDetailsPrix = true;
    private _validCommandeDetailsQte = true;
    private _validCommandeDetailsCommande = true;
    private _validCommandeDetailsProduit = true;
    private _validEntiteAdminCode = true;
    private _validEntiteAdminLibelle = true;

    constructor( private commandeService: CommandeAdminService , private entiteAdminService: EntiteAdminAdminService, private commandeDetailService: CommandeDetailAdminService, private produitService: ProduitAdminService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.commandeDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.entiteAdmin = new EntiteAdminDto();
        this.entiteAdminService.findAll().subscribe((data) => this.entiteAdmins = data);
    }



    validateCommandeDetails(){
        this.errorMessages = new Array();
        this.validateCommandeDetailsPrix();
        this.validateCommandeDetailsQte();
        this.validateCommandeDetailsCommande();
        this.validateCommandeDetailsProduit();
    }


    public override setValidation(value: boolean){
        this.validCommandeRef = value;
        this.validCommandeTotal = value;
        this.validCommandeTotalPaye = value;
        this.validCommandeDetailsPrix = value;
        this.validCommandeDetailsQte = value;
        this.validCommandeDetailsCommande = value;
        this.validCommandeDetailsProduit = value;
    }

    public addCommandeDetails() {
        if( this.item.commandeDetails == null )
            this.item.commandeDetails = new Array<CommandeDetailDto>();
       this.validateCommandeDetails();
       if (this.errorMessages.length === 0) {
              this.item.commandeDetails.push({... this.commandeDetailsElement});
              this.commandeDetailsElement = new CommandeDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletecommandeDetails(p: CommandeDetailDto) {
        this.item.commandeDetails.forEach((element, index) => {
            if (element === p) { this.item.commandeDetails.splice(index, 1); }
        });
    }

    public editcommandeDetails(p: CommandeDetailDto) {
        this.commandeDetailsElement = {... p};
        this.activeTab = 0;
    }


    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCommandeRef();
        this.validateCommandeTotal();
        this.validateCommandeTotalPaye();
    }

    public validateCommandeRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
        this.errorMessages.push('Ref non valide');
        this.validCommandeRef = false;
        } else {
            this.validCommandeRef = true;
        }
    }
    public validateCommandeTotal(){
        if (this.stringUtilService.isEmpty(this.item.total)) {
        this.errorMessages.push('Total non valide');
        this.validCommandeTotal = false;
        } else {
            this.validCommandeTotal = true;
        }
    }
    public validateCommandeTotalPaye(){
        if (this.stringUtilService.isEmpty(this.item.totalPaye)) {
        this.errorMessages.push('Total paye non valide');
        this.validCommandeTotalPaye = false;
        } else {
            this.validCommandeTotalPaye = true;
        }
    }

    public validateCommandeDetailsPrix(){
        if (this.commandeDetailsElement.prix == null) {
            this.errorMessages.push('Prix de la commandeDetail est  invalide');
            this.validCommandeDetailsPrix = false;
        } else {
            this.validCommandeDetailsPrix = true;
        }
    }
    public validateCommandeDetailsQte(){
        if (this.commandeDetailsElement.qte == null) {
            this.errorMessages.push('Qte de la commandeDetail est  invalide');
            this.validCommandeDetailsQte = false;
        } else {
            this.validCommandeDetailsQte = true;
        }
    }
    public validateCommandeDetailsCommande(){
        if (this.commandeDetailsElement.commande == null) {
            this.errorMessages.push('Commande de la commandeDetail est  invalide');
            this.validCommandeDetailsCommande = false;
        } else {
            this.validCommandeDetailsCommande = true;
        }
    }
    public validateCommandeDetailsProduit(){
        if (this.commandeDetailsElement.produit == null) {
            this.errorMessages.push('Produit de la commandeDetail est  invalide');
            this.validCommandeDetailsProduit = false;
        } else {
            this.validCommandeDetailsProduit = true;
        }
    }


    get entiteAdmin(): EntiteAdminDto {
        return this.entiteAdminService.item;
    }
    set entiteAdmin(value: EntiteAdminDto) {
        this.entiteAdminService.item = value;
    }
    get entiteAdmins(): Array<EntiteAdminDto> {
        return this.entiteAdminService.items;
    }
    set entiteAdmins(value: Array<EntiteAdminDto>) {
        this.entiteAdminService.items = value;
    }
    get createEntiteAdminDialog(): boolean {
       return this.entiteAdminService.createDialog;
    }
    set createEntiteAdminDialog(value: boolean) {
        this.entiteAdminService.createDialog= value;
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

    get validCommandeDetailsPrix(): boolean {
        return this._validCommandeDetailsPrix;
    }
    set validCommandeDetailsPrix(value: boolean) {
        this._validCommandeDetailsPrix = value;
    }
    get validCommandeDetailsQte(): boolean {
        return this._validCommandeDetailsQte;
    }
    set validCommandeDetailsQte(value: boolean) {
        this._validCommandeDetailsQte = value;
    }
    get validCommandeDetailsCommande(): boolean {
        return this._validCommandeDetailsCommande;
    }
    set validCommandeDetailsCommande(value: boolean) {
        this._validCommandeDetailsCommande = value;
    }
    get validCommandeDetailsProduit(): boolean {
        return this._validCommandeDetailsProduit;
    }
    set validCommandeDetailsProduit(value: boolean) {
        this._validCommandeDetailsProduit = value;
    }
    get validEntiteAdminCode(): boolean {
        return this._validEntiteAdminCode;
    }
    set validEntiteAdminCode(value: boolean) {
        this._validEntiteAdminCode = value;
    }
    get validEntiteAdminLibelle(): boolean {
        return this._validEntiteAdminLibelle;
    }
    set validEntiteAdminLibelle(value: boolean) {
        this._validEntiteAdminLibelle = value;
    }

    get commandeDetailsElement(): CommandeDetailDto {
        if( this._commandeDetailsElement == null )
            this._commandeDetailsElement = new CommandeDetailDto();
        return this._commandeDetailsElement;
    }

    set commandeDetailsElement(value: CommandeDetailDto) {
        this._commandeDetailsElement = value;
    }

}
