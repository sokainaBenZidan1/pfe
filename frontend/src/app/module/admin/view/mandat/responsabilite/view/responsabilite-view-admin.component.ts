import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ResponsabiliteAdminService} from 'src/app/shared/service/admin/mandat/ResponsabiliteAdmin.service';
import {ResponsabiliteDto} from 'src/app/shared/model/mandat/Responsabilite.model';
import {ResponsabiliteCriteria} from 'src/app/shared/criteria/mandat/ResponsabiliteCriteria.model';

@Component({
  selector: 'app-responsabilite-view-admin',
  templateUrl: './responsabilite-view-admin.component.html'
})
export class ResponsabiliteViewAdminComponent extends AbstractViewController<ResponsabiliteDto, ResponsabiliteCriteria, ResponsabiliteAdminService> implements OnInit {


    constructor(private responsabiliteService: ResponsabiliteAdminService){
        super(responsabiliteService);
    }

    ngOnInit(): void {
    }




}
