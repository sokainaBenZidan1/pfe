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

import { ExpressionBesoinCreateAdminComponent } from './expression-besoin/create/expression-besoin-create-admin.component';
import { ExpressionBesoinEditAdminComponent } from './expression-besoin/edit/expression-besoin-edit-admin.component';
import { ExpressionBesoinViewAdminComponent } from './expression-besoin/view/expression-besoin-view-admin.component';
import { ExpressionBesoinListAdminComponent } from './expression-besoin/list/expression-besoin-list-admin.component';
import { ExpressionBesoinDetailCreateAdminComponent } from './expression-besoin-detail/create/expression-besoin-detail-create-admin.component';
import { ExpressionBesoinDetailEditAdminComponent } from './expression-besoin-detail/edit/expression-besoin-detail-edit-admin.component';
import { ExpressionBesoinDetailViewAdminComponent } from './expression-besoin-detail/view/expression-besoin-detail-view-admin.component';
import { ExpressionBesoinDetailListAdminComponent } from './expression-besoin-detail/list/expression-besoin-detail-list-admin.component';
import { EtatCreateAdminComponent } from './etat/create/etat-create-admin.component';
import { EtatEditAdminComponent } from './etat/edit/etat-edit-admin.component';
import { EtatViewAdminComponent } from './etat/view/etat-view-admin.component';
import { EtatListAdminComponent } from './etat/list/etat-list-admin.component';

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

    ExpressionBesoinCreateAdminComponent,
    ExpressionBesoinListAdminComponent,
    ExpressionBesoinViewAdminComponent,
    ExpressionBesoinEditAdminComponent,
    ExpressionBesoinDetailCreateAdminComponent,
    ExpressionBesoinDetailListAdminComponent,
    ExpressionBesoinDetailViewAdminComponent,
    ExpressionBesoinDetailEditAdminComponent,
    EtatCreateAdminComponent,
    EtatListAdminComponent,
    EtatViewAdminComponent,
    EtatEditAdminComponent,
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
  ExpressionBesoinCreateAdminComponent,
  ExpressionBesoinListAdminComponent,
  ExpressionBesoinViewAdminComponent,
  ExpressionBesoinEditAdminComponent,
  ExpressionBesoinDetailCreateAdminComponent,
  ExpressionBesoinDetailListAdminComponent,
  ExpressionBesoinDetailViewAdminComponent,
  ExpressionBesoinDetailEditAdminComponent,
  EtatCreateAdminComponent,
  EtatListAdminComponent,
  EtatViewAdminComponent,
  EtatEditAdminComponent,
  ],
})
export class ExpressionbesionAdminModule { }
