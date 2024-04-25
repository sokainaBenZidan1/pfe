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

import { LivraisonDetailCreateAdminComponent } from './livraison-detail/create/livraison-detail-create-admin.component';
import { LivraisonDetailEditAdminComponent } from './livraison-detail/edit/livraison-detail-edit-admin.component';
import { LivraisonDetailViewAdminComponent } from './livraison-detail/view/livraison-detail-view-admin.component';
import { LivraisonDetailListAdminComponent } from './livraison-detail/list/livraison-detail-list-admin.component';
import { LivraisonCreateAdminComponent } from './livraison/create/livraison-create-admin.component';
import { LivraisonEditAdminComponent } from './livraison/edit/livraison-edit-admin.component';
import { LivraisonViewAdminComponent } from './livraison/view/livraison-view-admin.component';
import { LivraisonListAdminComponent } from './livraison/list/livraison-list-admin.component';

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

    LivraisonDetailCreateAdminComponent,
    LivraisonDetailListAdminComponent,
    LivraisonDetailViewAdminComponent,
    LivraisonDetailEditAdminComponent,
    LivraisonCreateAdminComponent,
    LivraisonListAdminComponent,
    LivraisonViewAdminComponent,
    LivraisonEditAdminComponent,
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
  LivraisonDetailCreateAdminComponent,
  LivraisonDetailListAdminComponent,
  LivraisonDetailViewAdminComponent,
  LivraisonDetailEditAdminComponent,
  LivraisonCreateAdminComponent,
  LivraisonListAdminComponent,
  LivraisonViewAdminComponent,
  LivraisonEditAdminComponent,
  ],
})
export class LivraisonAdminModule { }
