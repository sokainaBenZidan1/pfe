import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from './EntiteAdmin.model';

export class EmployeDto extends BaseDto{

    public nom: string;

    public prenom: string;

    public entiteAdmin: EntiteAdminDto ;
    

    constructor() {
        super();

        this.nom = '';
        this.prenom = '';

        }

}
