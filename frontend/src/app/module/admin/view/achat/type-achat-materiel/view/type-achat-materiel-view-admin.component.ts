import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeAchatMaterielAdminService} from 'src/app/shared/service/admin/achat/TypeAchatMaterielAdmin.service';
import {TypeAchatMaterielDto} from 'src/app/shared/model/achat/TypeAchatMateriel.model';
import {TypeAchatMaterielCriteria} from 'src/app/shared/criteria/achat/TypeAchatMaterielCriteria.model';

@Component({
  selector: 'app-type-achat-materiel-view-admin',
  templateUrl: './type-achat-materiel-view-admin.component.html'
})
export class TypeAchatMaterielViewAdminComponent extends AbstractViewController<TypeAchatMaterielDto, TypeAchatMaterielCriteria, TypeAchatMaterielAdminService> implements OnInit {


    constructor(private typeAchatMaterielService: TypeAchatMaterielAdminService){
        super(typeAchatMaterielService);
    }

    ngOnInit(): void {
    }




}
