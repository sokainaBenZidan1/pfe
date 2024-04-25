import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from '../commun/EntiteAdmin.model';
import {BudgetDto} from './Budget.model';

export class BudgetEntiteAdminDto extends BaseDto{

    public montantEntite: null | number;

    public montantInvEntite: null | number;

    public montantFctEntite: null | number;

    public entiteAdmin: EntiteAdminDto ;
    public budget: BudgetDto ;
    

    constructor() {
        super();

        this.montantEntite = null;
        this.montantInvEntite = null;
        this.montantFctEntite = null;
        this.entiteAdmin = new EntiteAdminDto() ;
        this.budget = new BudgetDto() ;

        }

}
