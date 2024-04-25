import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ResponsableInventaireAdminService} from 'src/app/shared/service/admin/inventaire/ResponsableInventaireAdmin.service';
import {ResponsableInventaireDto} from 'src/app/shared/model/inventaire/ResponsableInventaire.model';
import {ResponsableInventaireCriteria} from 'src/app/shared/criteria/inventaire/ResponsableInventaireCriteria.model';

@Component({
  selector: 'app-responsable-inventaire-view-admin',
  templateUrl: './responsable-inventaire-view-admin.component.html'
})
export class ResponsableInventaireViewAdminComponent extends AbstractViewController<ResponsableInventaireDto, ResponsableInventaireCriteria, ResponsableInventaireAdminService> implements OnInit {


    constructor(private responsableInventaireService: ResponsableInventaireAdminService){
        super(responsableInventaireService);
    }

    ngOnInit(): void {
    }




}
