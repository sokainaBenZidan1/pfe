import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {BudgetCriteria} from './BudgetCriteria.model';
import {CompteBudgetaireCriteria} from './CompteBudgetaireCriteria.model';

export class BudgetCompteBudgetaireCriteria  extends BaseCriteria  {

    public id: number;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public budget: BudgetCriteria ;
  public budgets: Array<BudgetCriteria> ;

}
