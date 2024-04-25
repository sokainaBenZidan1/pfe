import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { LayoutService } from './service/app.layout.service';
import {RoleService} from "../zynerator/security/shared/service/Role.service";
import {AppComponent} from "../app.component";
import {AuthService} from "../zynerator/security/shared/service/Auth.service";
import {Router} from "@angular/router";
import {AppLayoutComponent} from "./app.layout.component";

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html'
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelanonymous: any[];
    modelAdmin: any[];
constructor(public layoutService: LayoutService, public app: AppComponent, public appMain: AppLayoutComponent, private roleService: RoleService, private authService: AuthService, private router: Router) { }
  ngOnInit() {
    this.modelAdmin =
      [

				{
                    label: 'Pages',
                    icon: 'pi pi-fw pi-briefcase',
                    items: [
					  {
						label: 'Expressionbesion',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste expression besoin',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/expressionbesion/expression-besoin/list']
								  },
								  {
									label: 'Liste expression besoin detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/expressionbesion/expression-besoin-detail/list']
								  },
								  {
									label: 'Liste etat',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/expressionbesion/etat/list']
								  },
						]
					  },
					  {
						label: 'Reception',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste reception',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/reception/reception/list']
								  },
						]
					  },
					  {
						label: 'Inventaire',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste commande',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commande/commande/list']
								  },
								  {
									label: 'Liste responsable inventaire',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/inventaire/responsable-inventaire/list']
								  },
								  {
									label: 'Liste inventaire detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/inventaire/inventaire-detail/list']
								  },
								  {
									label: 'Liste inventaire',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/inventaire/inventaire/list']
								  },
								  {
									label: 'Liste commande detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commande/commande-detail/list']
								  },
								  {
									label: 'Liste produit',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/produit/produit/list']
								  },
						]
					  },
					  {
						label: 'AchatMaterielDetail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste achat materiel detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/achat/achat-materiel-detail/list']
								  },
						]
					  },
					  {
						label: 'Livraison',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste livraison',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/livraison/livraison/list']
								  },
						]
					  },
					  {
						label: 'Produit',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste categorie produit',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/produit/categorie-produit/list']
								  },
						]
					  },
					  {
						label: 'ReceptionDetail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste reception detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/reception/reception-detail/list']
								  },
						]
					  },
					  {
						label: 'Mandat',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste responsabilite',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/mandat/responsabilite/list']
								  },
								  {
									label: 'Liste mandat',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/mandat/mandat/list']
								  },
						]
					  },
					  {
						label: 'TypeAchatMateriel',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste type achat materiel',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/achat/type-achat-materiel/list']
								  },
						]
					  },
					  {
						label: 'OperationStockDetail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste operation stock detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/stock/operation-stock-detail/list']
								  },
						]
					  },
					  {
						label: 'Magasin',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste magasin',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/stock/magasin/list']
								  },
						]
					  },
					  {
						label: 'AchatMateriel',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste achat materiel',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/achat/achat-materiel/list']
								  },
						]
					  },
					  {
						label: 'Budget',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste budget',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/budget/budget/list']
								  },
								  {
									label: 'Liste budget compte budgetaire',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/budget/budget-compte-budgetaire/list']
								  },
								  {
									label: 'Liste budget entite admin',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/budget/budget-entite-admin/list']
								  },
								  {
									label: 'Liste compte budgetaire',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/budget/compte-budgetaire/list']
								  },
						]
					  },
					  {
						label: 'OperationStock',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste operation stock',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/stock/operation-stock/list']
								  },
						]
					  },
					  {
						label: 'Employe',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste employe',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/employe/list']
								  },
						]
					  },
					  {
						label: 'LivraisonDetail',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste livraison detail',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/livraison/livraison-detail/list']
								  },
						]
					  },
					  {
						label: 'Stock',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste stock',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/stock/stock/list']
								  },
						]
					  },
					  {
						label: 'EntiteAdmin',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste entite admin',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/commun/entite-admin/list']
								  },
						]
					  },

				   {
					  label: 'Security Management',
					  icon: 'pi pi-wallet',
					  items: [
						  {
							  label: 'List User',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/user/list']
						  },
						  {
							  label: 'List Model',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/model-permission/list']
						  },
						  {
							  label: 'List Action Permission',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/action-permission/list']
						  },
					  ]
				  }
			]
	    }
    ];
        if (this.authService.authenticated) {
            if (this.authService.authenticatedUser.roleUsers) {
              this.authService.authenticatedUser.roleUsers.forEach(role => {
                  const roleName: string = this.getRole(role.role.authority);
                  this.roleService._role.next(roleName.toUpperCase());
                  eval('this.model = this.model' + this.getRole(role.role.authority));
              })
            }
        }
  }

    getRole(text){
        const [role, ...rest] = text.split('_');
        return this.upperCaseFirstLetter(rest.join(''));
    }

    upperCaseFirstLetter(word: string) {
      if (!word) { return word; }
      return word[0].toUpperCase() + word.substr(1).toLowerCase();
    }

    onMenuClick(event) {
        this.appMain.onMenuClick(event);
    }
}
