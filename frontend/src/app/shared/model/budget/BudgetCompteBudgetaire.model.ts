import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {BudgetDto} from './Budget.model';
import {CompteBudgetaireDto} from './CompteBudgetaire.model';

export class BudgetCompteBudgetaireDto extends BaseDto{

    public montant: null | number;

    public budget: BudgetDto ;
    public compteBudgetaire: CompteBudgetaireDto ;
    

    constructor() {
        super();

        this.montant = null;
        this.budget = new BudgetDto() ;

        }

}
