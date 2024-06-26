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

import { ReceptionDetailCreateAdminComponent } from './reception-detail/create/reception-detail-create-admin.component';
import { ReceptionDetailEditAdminComponent } from './reception-detail/edit/reception-detail-edit-admin.component';
import { ReceptionDetailViewAdminComponent } from './reception-detail/view/reception-detail-view-admin.component';
import { ReceptionDetailListAdminComponent } from './reception-detail/list/reception-detail-list-admin.component';
import { ReceptionCreateAdminComponent } from './reception/create/reception-create-admin.component';
import { ReceptionEditAdminComponent } from './reception/edit/reception-edit-admin.component';
import { ReceptionViewAdminComponent } from './reception/view/reception-view-admin.component';
import { ReceptionListAdminComponent } from './reception/list/reception-list-admin.component';

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

    ReceptionDetailCreateAdminComponent,
    ReceptionDetailListAdminComponent,
    ReceptionDetailViewAdminComponent,
    ReceptionDetailEditAdminComponent,
    ReceptionCreateAdminComponent,
    ReceptionListAdminComponent,
    ReceptionViewAdminComponent,
    ReceptionEditAdminComponent,
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
  ReceptionDetailCreateAdminComponent,
  ReceptionDetailListAdminComponent,
  ReceptionDetailViewAdminComponent,
  ReceptionDetailEditAdminComponent,
  ReceptionCreateAdminComponent,
  ReceptionListAdminComponent,
  ReceptionViewAdminComponent,
  ReceptionEditAdminComponent,
  ],
})
export class ReceptionAdminModule { }
