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

import { MagasinCreateAdminComponent } from './magasin/create/magasin-create-admin.component';
import { MagasinEditAdminComponent } from './magasin/edit/magasin-edit-admin.component';
import { MagasinViewAdminComponent } from './magasin/view/magasin-view-admin.component';
import { MagasinListAdminComponent } from './magasin/list/magasin-list-admin.component';
import { StockCreateAdminComponent } from './stock/create/stock-create-admin.component';
import { StockEditAdminComponent } from './stock/edit/stock-edit-admin.component';
import { StockViewAdminComponent } from './stock/view/stock-view-admin.component';
import { StockListAdminComponent } from './stock/list/stock-list-admin.component';
import { OperationStockCreateAdminComponent } from './operation-stock/create/operation-stock-create-admin.component';
import { OperationStockEditAdminComponent } from './operation-stock/edit/operation-stock-edit-admin.component';
import { OperationStockViewAdminComponent } from './operation-stock/view/operation-stock-view-admin.component';
import { OperationStockListAdminComponent } from './operation-stock/list/operation-stock-list-admin.component';
import { OperationStockDetailCreateAdminComponent } from './operation-stock-detail/create/operation-stock-detail-create-admin.component';
import { OperationStockDetailEditAdminComponent } from './operation-stock-detail/edit/operation-stock-detail-edit-admin.component';
import { OperationStockDetailViewAdminComponent } from './operation-stock-detail/view/operation-stock-detail-view-admin.component';
import { OperationStockDetailListAdminComponent } from './operation-stock-detail/list/operation-stock-detail-list-admin.component';

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

    MagasinCreateAdminComponent,
    MagasinListAdminComponent,
    MagasinViewAdminComponent,
    MagasinEditAdminComponent,
    StockCreateAdminComponent,
    StockListAdminComponent,
    StockViewAdminComponent,
    StockEditAdminComponent,
    OperationStockCreateAdminComponent,
    OperationStockListAdminComponent,
    OperationStockViewAdminComponent,
    OperationStockEditAdminComponent,
    OperationStockDetailCreateAdminComponent,
    OperationStockDetailListAdminComponent,
    OperationStockDetailViewAdminComponent,
    OperationStockDetailEditAdminComponent,
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
  MagasinCreateAdminComponent,
  MagasinListAdminComponent,
  MagasinViewAdminComponent,
  MagasinEditAdminComponent,
  StockCreateAdminComponent,
  StockListAdminComponent,
  StockViewAdminComponent,
  StockEditAdminComponent,
  OperationStockCreateAdminComponent,
  OperationStockListAdminComponent,
  OperationStockViewAdminComponent,
  OperationStockEditAdminComponent,
  OperationStockDetailCreateAdminComponent,
  OperationStockDetailListAdminComponent,
  OperationStockDetailViewAdminComponent,
  OperationStockDetailEditAdminComponent,
  ],
})
export class StockAdminModule { }
