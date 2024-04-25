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

import { TypeAchatMaterielCreateAdminComponent } from './type-achat-materiel/create/type-achat-materiel-create-admin.component';
import { TypeAchatMaterielEditAdminComponent } from './type-achat-materiel/edit/type-achat-materiel-edit-admin.component';
import { TypeAchatMaterielViewAdminComponent } from './type-achat-materiel/view/type-achat-materiel-view-admin.component';
import { TypeAchatMaterielListAdminComponent } from './type-achat-materiel/list/type-achat-materiel-list-admin.component';
import { AchatMaterielCreateAdminComponent } from './achat-materiel/create/achat-materiel-create-admin.component';
import { AchatMaterielEditAdminComponent } from './achat-materiel/edit/achat-materiel-edit-admin.component';
import { AchatMaterielViewAdminComponent } from './achat-materiel/view/achat-materiel-view-admin.component';
import { AchatMaterielListAdminComponent } from './achat-materiel/list/achat-materiel-list-admin.component';
import { AchatMaterielDetailCreateAdminComponent } from './achat-materiel-detail/create/achat-materiel-detail-create-admin.component';
import { AchatMaterielDetailEditAdminComponent } from './achat-materiel-detail/edit/achat-materiel-detail-edit-admin.component';
import { AchatMaterielDetailViewAdminComponent } from './achat-materiel-detail/view/achat-materiel-detail-view-admin.component';
import { AchatMaterielDetailListAdminComponent } from './achat-materiel-detail/list/achat-materiel-detail-list-admin.component';

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

    TypeAchatMaterielCreateAdminComponent,
    TypeAchatMaterielListAdminComponent,
    TypeAchatMaterielViewAdminComponent,
    TypeAchatMaterielEditAdminComponent,
    AchatMaterielCreateAdminComponent,
    AchatMaterielListAdminComponent,
    AchatMaterielViewAdminComponent,
    AchatMaterielEditAdminComponent,
    AchatMaterielDetailCreateAdminComponent,
    AchatMaterielDetailListAdminComponent,
    AchatMaterielDetailViewAdminComponent,
    AchatMaterielDetailEditAdminComponent,
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
  TypeAchatMaterielCreateAdminComponent,
  TypeAchatMaterielListAdminComponent,
  TypeAchatMaterielViewAdminComponent,
  TypeAchatMaterielEditAdminComponent,
  AchatMaterielCreateAdminComponent,
  AchatMaterielListAdminComponent,
  AchatMaterielViewAdminComponent,
  AchatMaterielEditAdminComponent,
  AchatMaterielDetailCreateAdminComponent,
  AchatMaterielDetailListAdminComponent,
  AchatMaterielDetailViewAdminComponent,
  AchatMaterielDetailEditAdminComponent,
  ],
})
export class AchatAdminModule { }
