import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatMaterielDetailAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielDetailAdmin.service';
import {AchatMaterielDetailDto} from 'src/app/shared/model/achat/AchatMaterielDetail.model';
import {AchatMaterielDetailCriteria} from 'src/app/shared/criteria/achat/AchatMaterielDetailCriteria.model';


import {ProduitDto} from 'src/app/shared/model/produit/Produit.model';
import {ProduitAdminService} from 'src/app/shared/service/admin/produit/ProduitAdmin.service';
import {AchatMaterielDto} from 'src/app/shared/model/achat/AchatMateriel.model';
import {AchatMaterielAdminService} from 'src/app/shared/service/admin/achat/AchatMaterielAdmin.service';

@Component({
  selector: 'app-achat-materiel-detail-edit-admin',
  templateUrl: './achat-materiel-detail-edit-admin.component.html'
})
export class AchatMaterielDetailEditAdminComponent extends AbstractEditController<AchatMaterielDetailDto, AchatMaterielDetailCriteria, AchatMaterielDetailAdminService>   implements OnInit {



    private _validProduitCode = true;
    private _validProduitLibelle = true;



    constructor( private achatMaterielDetailService: AchatMaterielDetailAdminService , private produitService: ProduitAdminService, private achatMaterielService: AchatMaterielAdminService) {
        super(achatMaterielDetailService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.achatMateriel = new AchatMaterielDto();
        this.achatMaterielService.findAll().subscribe((data) => this.achatMateriels = data);
    }


    public override setValidation(value: boolean){
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateAchatMateriel(achatMateriel: string) {
        const isPermistted = await this.roleService.isPermitted('AchatMateriel', 'edit');
        if (isPermistted) {
             this.achatMateriel = new AchatMaterielDto();
             this.createAchatMaterielDialog = true;
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
   get achatMateriel(): AchatMaterielDto {
       return this.achatMaterielService.item;
   }
  set achatMateriel(value: AchatMaterielDto) {
        this.achatMaterielService.item = value;
   }
   get achatMateriels(): Array<AchatMaterielDto> {
        return this.achatMaterielService.items;
   }
   set achatMateriels(value: Array<AchatMaterielDto>) {
        this.achatMaterielService.items = value;
   }
   get createAchatMaterielDialog(): boolean {
       return this.achatMaterielService.createDialog;
   }
  set createAchatMaterielDialog(value: boolean) {
       this.achatMaterielService.createDialog= value;
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
