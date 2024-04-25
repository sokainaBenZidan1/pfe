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

import { ResponsableInventaireCreateAdminComponent } from './responsable-inventaire/create/responsable-inventaire-create-admin.component';
import { ResponsableInventaireEditAdminComponent } from './responsable-inventaire/edit/responsable-inventaire-edit-admin.component';
import { ResponsableInventaireViewAdminComponent } from './responsable-inventaire/view/responsable-inventaire-view-admin.component';
import { ResponsableInventaireListAdminComponent } from './responsable-inventaire/list/responsable-inventaire-list-admin.component';
import { InventaireDetailCreateAdminComponent } from './inventaire-detail/create/inventaire-detail-create-admin.component';
import { InventaireDetailEditAdminComponent } from './inventaire-detail/edit/inventaire-detail-edit-admin.component';
import { InventaireDetailViewAdminComponent } from './inventaire-detail/view/inventaire-detail-view-admin.component';
import { InventaireDetailListAdminComponent } from './inventaire-detail/list/inventaire-detail-list-admin.component';
import { InventaireCreateAdminComponent } from './inventaire/create/inventaire-create-admin.component';
import { InventaireEditAdminComponent } from './inventaire/edit/inventaire-edit-admin.component';
import { InventaireViewAdminComponent } from './inventaire/view/inventaire-view-admin.component';
import { InventaireListAdminComponent } from './inventaire/list/inventaire-list-admin.component';

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

    ResponsableInventaireCreateAdminComponent,
    ResponsableInventaireListAdminComponent,
    ResponsableInventaireViewAdminComponent,
    ResponsableInventaireEditAdminComponent,
    InventaireDetailCreateAdminComponent,
    InventaireDetailListAdminComponent,
    InventaireDetailViewAdminComponent,
    InventaireDetailEditAdminComponent,
    InventaireCreateAdminComponent,
    InventaireListAdminComponent,
    InventaireViewAdminComponent,
    InventaireEditAdminComponent,
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
  ResponsableInventaireCreateAdminComponent,
  ResponsableInventaireListAdminComponent,
  ResponsableInventaireViewAdminComponent,
  ResponsableInventaireEditAdminComponent,
  InventaireDetailCreateAdminComponent,
  InventaireDetailListAdminComponent,
  InventaireDetailViewAdminComponent,
  InventaireDetailEditAdminComponent,
  InventaireCreateAdminComponent,
  InventaireListAdminComponent,
  InventaireViewAdminComponent,
  InventaireEditAdminComponent,
  ],
})
export class InventaireAdminModule { }
