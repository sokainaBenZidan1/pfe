import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CompteBudgetaireAdminService} from 'src/app/shared/service/admin/budget/CompteBudgetaireAdmin.service';
import {CompteBudgetaireDto} from 'src/app/shared/model/budget/CompteBudgetaire.model';
import {CompteBudgetaireCriteria} from 'src/app/shared/criteria/budget/CompteBudgetaireCriteria.model';

@Component({
  selector: 'app-compte-budgetaire-view-admin',
  templateUrl: './compte-budgetaire-view-admin.component.html'
})
export class CompteBudgetaireViewAdminComponent extends AbstractViewController<CompteBudgetaireDto, CompteBudgetaireCriteria, CompteBudgetaireAdminService> implements OnInit {


    constructor(private compteBudgetaireService: CompteBudgetaireAdminService){
        super(compteBudgetaireService);
    }

    ngOnInit(): void {
    }




}
