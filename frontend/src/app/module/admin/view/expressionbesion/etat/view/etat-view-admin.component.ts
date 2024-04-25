import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAdminService} from 'src/app/shared/service/admin/expressionbesion/EtatAdmin.service';
import {EtatDto} from 'src/app/shared/model/expressionbesion/Etat.model';
import {EtatCriteria} from 'src/app/shared/criteria/expressionbesion/EtatCriteria.model';

@Component({
  selector: 'app-etat-view-admin',
  templateUrl: './etat-view-admin.component.html'
})
export class EtatViewAdminComponent extends AbstractViewController<EtatDto, EtatCriteria, EtatAdminService> implements OnInit {


    constructor(private etatService: EtatAdminService){
        super(etatService);
    }

    ngOnInit(): void {
    }




}
