import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CompteBudgetaireCriteria} from '../budget/CompteBudgetaireCriteria.model';

export class CategorieProduitCriteria  extends BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;

}
