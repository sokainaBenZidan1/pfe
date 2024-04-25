import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';

import { ProduitAdminModule } from './view/produit/produit-admin.module';
import { ProduitAdminRoutingModule } from './view/produit/produit-admin-routing.module';
import { MandatAdminModule } from './view/mandat/mandat-admin.module';
import { MandatAdminRoutingModule } from './view/mandat/mandat-admin-routing.module';
import { ExpressionbesionAdminModule } from './view/expressionbesion/expressionbesion-admin.module';
import { ExpressionbesionAdminRoutingModule } from './view/expressionbesion/expressionbesion-admin-routing.module';
import { InventaireAdminModule } from './view/inventaire/inventaire-admin.module';
import { InventaireAdminRoutingModule } from './view/inventaire/inventaire-admin-routing.module';
import { LivraisonAdminModule } from './view/livraison/livraison-admin.module';
import { LivraisonAdminRoutingModule } from './view/livraison/livraison-admin-routing.module';
import { CommunAdminModule } from './view/commun/commun-admin.module';
import { CommunAdminRoutingModule } from './view/commun/commun-admin-routing.module';
import { AchatAdminModule } from './view/achat/achat-admin.module';
import { AchatAdminRoutingModule } from './view/achat/achat-admin-routing.module';
import { ReceptionAdminModule } from './view/reception/reception-admin.module';
import { ReceptionAdminRoutingModule } from './view/reception/reception-admin-routing.module';
import { BudgetAdminModule } from './view/budget/budget-admin.module';
import { BudgetAdminRoutingModule } from './view/budget/budget-admin-routing.module';
import { StockAdminModule } from './view/stock/stock-admin.module';
import { StockAdminRoutingModule } from './view/stock/stock-admin-routing.module';
import { CommandeAdminModule } from './view/commande/commande-admin.module';
import { CommandeAdminRoutingModule } from './view/commande/commande-admin-routing.module';

import {SecurityModule} from 'src/app/module/security/security.module';
import {SecurityRoutingModule} from 'src/app/module/security/security-routing.module';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
  ProduitAdminModule,
  ProduitAdminRoutingModule,
  MandatAdminModule,
  MandatAdminRoutingModule,
  ExpressionbesionAdminModule,
  ExpressionbesionAdminRoutingModule,
  InventaireAdminModule,
  InventaireAdminRoutingModule,
  LivraisonAdminModule,
  LivraisonAdminRoutingModule,
  CommunAdminModule,
  CommunAdminRoutingModule,
  AchatAdminModule,
  AchatAdminRoutingModule,
  ReceptionAdminModule,
  ReceptionAdminRoutingModule,
  BudgetAdminModule,
  BudgetAdminRoutingModule,
  StockAdminModule,
  StockAdminRoutingModule,
  CommandeAdminModule,
  CommandeAdminRoutingModule,
  SecurityModule,
  SecurityRoutingModule
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    ProduitAdminModule,
    MandatAdminModule,
    ExpressionbesionAdminModule,
    InventaireAdminModule,
    LivraisonAdminModule,
    CommunAdminModule,
    AchatAdminModule,
    ReceptionAdminModule,
    BudgetAdminModule,
    StockAdminModule,
    CommandeAdminModule,
  SecurityModule
  ],

})
export class AdminModule { }
