import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntiteAdminCriteria} from '../commun/EntiteAdminCriteria.model';
import {BudgetCriteria} from './BudgetCriteria.model';
import {BudgetEntiteAdminCriteria} from './BudgetEntiteAdminCriteria.model';

export class BudgetCriteria  extends BaseCriteria  {

    public id: number;
    public dateBudget: Date;
    public dateBudgetFrom: Date;
    public dateBudgetTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
     public montantInvestissement: number;
     public montantInvestissementMin: number;
     public montantInvestissementMax: number;
     public montantFonction: number;
     public montantFonctionMin: number;
     public montantFonctionMax: number;
      public budgetEntiteAdmins: Array<BudgetEntiteAdminCriteria>;

}
