import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntiteAdminCriteria} from '../commun/EntiteAdminCriteria.model';
import {BudgetCriteria} from './BudgetCriteria.model';

export class BudgetEntiteAdminCriteria  extends BaseCriteria  {

    public id: number;
     public montantEntite: number;
     public montantEntiteMin: number;
     public montantEntiteMax: number;
     public montantInvEntite: number;
     public montantInvEntiteMin: number;
     public montantInvEntiteMax: number;
     public montantFctEntite: number;
     public montantFctEntiteMin: number;
     public montantFctEntiteMax: number;
  public entiteAdmin: EntiteAdminCriteria ;
  public entiteAdmins: Array<EntiteAdminCriteria> ;
  public budget: BudgetCriteria ;
  public budgets: Array<BudgetCriteria> ;

}
