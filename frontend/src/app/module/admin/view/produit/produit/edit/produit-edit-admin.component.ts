import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitCriteria} from 'src/app/shared/criteria/produit/ProduitCriteria.model';


import {CategorieProduitDto} from 'src/app/shared/model/produit/CategorieProduit.model';
import {CategorieProduitAdminService} from 'src/app/shared/service/admin/produit/CategorieProduitAdmin.service';

@Component({
  selector: 'app-produit-edit-admin',
  templateUrl: './produit-edit-admin.component.html'
})
export class ProduitEditAdminComponent extends AbstractEditController<ProduitDto, ProduitCriteria, ProduitAdminService>   implements OnInit {


    private _validProduitCode = true;
    private _validProduitLibelle = true;

    private _validCategorieProduitLibelle = true;
    private _validCategorieProduitCode = true;



    constructor( private produitService: ProduitAdminService , private categorieProduitService: CategorieProduitAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.categorieProduit = new CategorieProduitDto();
        this.categorieProduitService.findAll().subscribe((data) => this.categorieProduits = data);
    }


    public override setValidation(value: boolean){
        this.validProduitCode = value;
        this.validProduitLibelle = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitCode();
        this.validateProduitLibelle();
    }
    public validateProduitCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validProduitCode = false;
        } else {
            this.validProduitCode = true;
        }
    }
    public validateProduitLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validProduitLibelle = false;
        } else {
            this.validProduitLibelle = true;
        }
    }



   public async openCreateCategorieProduit(categorieProduit: string) {
        const isPermistted = await this.roleService.isPermitted('CategorieProduit', 'edit');
        if (isPermistted) {
             this.categorieProduit = new CategorieProduitDto();
             this.createCategorieProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get categorieProduit(): CategorieProduitDto {
       return this.categorieProduitService.item;
   }
  set categorieProduit(value: CategorieProduitDto) {
        this.categorieProduitService.item = value;
   }
   get categorieProduits(): Array<CategorieProduitDto> {
        return this.categorieProduitService.items;
   }
   set categorieProduits(value: Array<CategorieProduitDto>) {
        this.categorieProduitService.items = value;
   }
   get createCategorieProduitDialog(): boolean {
       return this.categorieProduitService.createDialog;
   }
  set createCategorieProduitDialog(value: boolean) {
       this.categorieProduitService.createDialog= value;
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

    get validCategorieProduitLibelle(): boolean {
        return this._validCategorieProduitLibelle;
    }
    set validCategorieProduitLibelle(value: boolean) {
        this._validCategorieProduitLibelle = value;
    }
    get validCategorieProduitCode(): boolean {
        return this._validCategorieProduitCode;
    }
    set validCategorieProduitCode(value: boolean) {
        this._validCategorieProduitCode = value;
    }
}
