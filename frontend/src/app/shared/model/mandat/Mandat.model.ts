import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from '../commun/EntiteAdmin.model';
import {ResponsabiliteDto} from './Responsabilite.model';
import {EmployeDto} from '../commun/Employe.model';

export class MandatDto extends BaseDto{

   public dateDebut: Date;

   public dateFin: Date;

    public employe: EmployeDto ;
    public responsabilite: ResponsabiliteDto ;
    public entiteAdmin: EntiteAdminDto ;
    

    constructor() {
        super();

        this.dateDebut = null;
        this.dateFin = null;
        this.employe = new EmployeDto() ;
        this.responsabilite = new ResponsabiliteDto() ;

        }

}
