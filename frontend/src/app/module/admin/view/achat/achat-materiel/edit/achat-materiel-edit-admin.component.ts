import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatMaterielAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielAdmin.service';
import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielCriteria} from 'src/app/shared/criteria/achat/AchatMaterielCriteria.model';


import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielAdminService} from 'src/app/shared/service/admin/achat/TypeAchatMaterielAdmin.service';
import {BudgetDto} from 'src/app/shared/model/budget/Budget.model';
import {BudgetAdminService} from 'src/app/shared/service/admin/budget/BudgetAdmin.service';
import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielDetailAdmin.service';
import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';

@Component({
  selector: 'app-achat-materiel-edit-admin',
  templateUrl: './achat-materiel-edit-admin.component.html'
})
export class AchatMaterielEditAdminComponent extends AbstractEditController<AchatMaterielDto, AchatMaterielCriteria, AchatMaterielAdminService>   implements OnInit {

    private _achatMaterielDetailsElement = new AchatMaterielDetailDto();


    private _validTypeAchatMaterielLibelle = true;
    private _validTypeAchatMaterielCode = true;



    constructor( private achatMaterielService: AchatMaterielAdminService , private typeAchatMaterielService: TypeAchatMaterielAdminService, private budgetService: BudgetAdminService, private achatMaterielDetailService: AchatMaterielDetailAdminService, private produitService: ProduitAdminService) {
        super(achatMaterielService);
    }

    ngOnInit(): void {
        this.achatMaterielDetailsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.budget = new BudgetDto();
        this.budgetService.findAll().subscribe((data) => this.budgets = data);
        this.typeAchatMateriel = new TypeAchatMaterielDto();
        this.typeAchatMaterielService.findAll().subscribe((data) => this.typeAchatMateriels = data);
    }
    public override prepareEdit() {
        this.item.dateAchat = this.achatMaterielService.format(this.item.dateAchat);
    }



    public validateAchatMaterielDetails(){
        this.errorMessages = new Array();
    }
    public override setValidation(value: boolean){
        }
   public addAchatMaterielDetails() {
        if( this.item.achatMaterielDetails == null )
            this.item.achatMaterielDetails = new Array<AchatMaterielDetailDto>();
       this.validateAchatMaterielDetails();
       if (this.errorMessages.length === 0) {
            if(this.achatMaterielDetailsElement.id == null){
                this.item.achatMaterielDetails.push(this.achatMaterielDetailsElement);
            }else{
                const index = this.item.achatMaterielDetails.findIndex(e => e.id == this.achatMaterielDetailsElement.id);
                this.item.achatMaterielDetails[index] = this.achatMaterielDetailsElement;
            }
          this.achatMaterielDetailsElement = new AchatMaterielDetailDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAchatMaterielDetails(p: AchatMaterielDetailDto) {
        this.item.achatMaterielDetails.forEach((element, index) => {
            if (element === p) { this.item.achatMaterielDetails.splice(index, 1); }
        });
    }

    public editAchatMaterielDetails(p: AchatMaterielDetailDto) {
        this.achatMaterielDetailsElement = {... p};
        this.activeTab = 0;
    }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateTypeAchatMateriel(typeAchatMateriel: string) {
        const isPermistted = await this.roleService.isPermitted('TypeAchatMateriel', 'edit');
        if (isPermistted) {
             this.typeAchatMateriel = new TypeAchatMaterielDto();
             this.createTypeAchatMaterielDialog = true;
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
   get typeAchatMateriel(): TypeAchatMaterielDto {
       return this.typeAchatMaterielService.item;
   }
  set typeAchatMateriel(value: TypeAchatMaterielDto) {
        this.typeAchatMaterielService.item = value;
   }
   get typeAchatMateriels(): Array<TypeAchatMaterielDto> {
        return this.typeAchatMaterielService.items;
   }
   set typeAchatMateriels(value: Array<TypeAchatMaterielDto>) {
        this.typeAchatMaterielService.items = value;
   }
   get createTypeAchatMaterielDialog(): boolean {
       return this.typeAchatMaterielService.createDialog;
   }
  set createTypeAchatMaterielDialog(value: boolean) {
       this.typeAchatMaterielService.createDialog= value;
   }
   get budget(): BudgetDto {
       return this.budgetService.item;
   }
  set budget(value: BudgetDto) {
        this.budgetService.item = value;
   }
   get budgets(): Array<BudgetDto> {
        return this.budgetService.items;
   }
   set budgets(value: Array<BudgetDto>) {
        this.budgetService.items = value;
   }
   get createBudgetDialog(): boolean {
       return this.budgetService.createDialog;
   }
  set createBudgetDialog(value: boolean) {
       this.budgetService.createDialog= value;
   }

    get achatMaterielDetailsElement(): AchatMaterielDetailDto {
        if( this._achatMaterielDetailsElement == null )
            this._achatMaterielDetailsElement = new AchatMaterielDetailDto();
         return this._achatMaterielDetailsElement;
    }

    set achatMaterielDetailsElement(value: AchatMaterielDetailDto) {
        this._achatMaterielDetailsElement = value;
    }


    get validTypeAchatMaterielLibelle(): boolean {
        return this._validTypeAchatMaterielLibelle;
    }
    set validTypeAchatMaterielLibelle(value: boolean) {
        this._validTypeAchatMaterielLibelle = value;
    }
    get validTypeAchatMaterielCode(): boolean {
        return this._validTypeAchatMaterielCode;
    }
    set validTypeAchatMaterielCode(value: boolean) {
        this._validTypeAchatMaterielCode = value;
    }
}
