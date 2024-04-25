import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {MagasinAdminService} from 'src/app/shared/service/admin/stock/MagasinAdmin.service';
import {MagasinDto} from 'src/app/shared/model/stock/Magasin.model';
import {MagasinCriteria} from 'src/app/shared/criteria/stock/MagasinCriteria.model';

@Component({
  selector: 'app-magasin-view-admin',
  templateUrl: './magasin-view-admin.component.html'
})
export class MagasinViewAdminComponent extends AbstractViewController<MagasinDto, MagasinCriteria, MagasinAdminService> implements OnInit {


    constructor(private magasinService: MagasinAdminService){
        super(magasinService);
    }

    ngOnInit(): void {
    }




}
