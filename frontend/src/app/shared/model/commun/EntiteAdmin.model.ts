import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from './EntiteAdmin.model';
import {EmployeDto} from './Employe.model';

export class EntiteAdminDto extends BaseDto{

    public code: string;

    public libelle: string;

     public employe: Array<EmployeDto>;
    

    constructor() {
        super();

        this.code = '';
        this.libelle = '';
        this.employe = new Array<EmployeDto>();

        }

}
