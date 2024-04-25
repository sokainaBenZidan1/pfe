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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { BudgetCreateAdminComponent } from './budget/create/budget-create-admin.component';
import { BudgetEditAdminComponent } from './budget/edit/budget-edit-admin.component';
import { BudgetViewAdminComponent } from './budget/view/budget-view-admin.component';
import { BudgetListAdminComponent } from './budget/list/budget-list-admin.component';
import { BudgetCompteBudgetaireCreateAdminComponent } from './budget-compte-budgetaire/create/budget-compte-budgetaire-create-admin.component';
import { BudgetCompteBudgetaireEditAdminComponent } from './budget-compte-budgetaire/edit/budget-compte-budgetaire-edit-admin.component';
import { BudgetCompteBudgetaireViewAdminComponent } from './budget-compte-budgetaire/view/budget-compte-budgetaire-view-admin.component';
import { BudgetCompteBudgetaireListAdminComponent } from './budget-compte-budgetaire/list/budget-compte-budgetaire-list-admin.component';
import { BudgetEntiteAdminCreateAdminComponent } from './budget-entite-admin/create/budget-entite-admin-create-admin.component';
import { BudgetEntiteAdminEditAdminComponent } from './budget-entite-admin/edit/budget-entite-admin-edit-admin.component';
import { BudgetEntiteAdminViewAdminComponent } from './budget-entite-admin/view/budget-entite-admin-view-admin.component';
import { BudgetEntiteAdminListAdminComponent } from './budget-entite-admin/list/budget-entite-admin-list-admin.component';
import { CompteBudgetaireCreateAdminComponent } from './compte-budgetaire/create/compte-budgetaire-create-admin.component';
import { CompteBudgetaireEditAdminComponent } from './compte-budgetaire/edit/compte-budgetaire-edit-admin.component';
import { CompteBudgetaireViewAdminComponent } from './compte-budgetaire/view/compte-budgetaire-view-admin.component';
import { CompteBudgetaireListAdminComponent } from './compte-budgetaire/list/compte-budgetaire-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    BudgetCreateAdminComponent,
    BudgetListAdminComponent,
    BudgetViewAdminComponent,
    BudgetEditAdminComponent,
    BudgetCompteBudgetaireCreateAdminComponent,
    BudgetCompteBudgetaireListAdminComponent,
    BudgetCompteBudgetaireViewAdminComponent,
    BudgetCompteBudgetaireEditAdminComponent,
    BudgetEntiteAdminCreateAdminComponent,
    BudgetEntiteAdminListAdminComponent,
    BudgetEntiteAdminViewAdminComponent,
    BudgetEntiteAdminEditAdminComponent,
    CompteBudgetaireCreateAdminComponent,
    CompteBudgetaireListAdminComponent,
    CompteBudgetaireViewAdminComponent,
    CompteBudgetaireEditAdminComponent,
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
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,

  ],
  exports: [
  BudgetCreateAdminComponent,
  BudgetListAdminComponent,
  BudgetViewAdminComponent,
  BudgetEditAdminComponent,
  BudgetCompteBudgetaireCreateAdminComponent,
  BudgetCompteBudgetaireListAdminComponent,
  BudgetCompteBudgetaireViewAdminComponent,
  BudgetCompteBudgetaireEditAdminComponent,
  BudgetEntiteAdminCreateAdminComponent,
  BudgetEntiteAdminListAdminComponent,
  BudgetEntiteAdminViewAdminComponent,
  BudgetEntiteAdminEditAdminComponent,
  CompteBudgetaireCreateAdminComponent,
  CompteBudgetaireListAdminComponent,
  CompteBudgetaireViewAdminComponent,
  CompteBudgetaireEditAdminComponent,
  ],
})
export class BudgetAdminModule { }
