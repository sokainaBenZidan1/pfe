import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from '../commun/EntiteAdmin.model';
import {BudgetDto} from './Budget.model';
import {BudgetEntiteAdminDto} from './BudgetEntiteAdmin.model';

export class BudgetDto extends BaseDto{

   public dateBudget: Date;

    public montant: null | number;

    public montantInvestissement: null | number;

    public montantFonction: null | number;

     public budgetEntiteAdmins: Array<BudgetEntiteAdminDto>;
    

    constructor() {
        super();

        this.dateBudget = null;
        this.montant = null;
        this.montantInvestissement = null;
        this.montantFonction = null;
        this.budgetEntiteAdmins = new Array<BudgetEntiteAdminDto>();

        }

}
