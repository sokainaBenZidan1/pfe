import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntiteAdminCriteria} from './EntiteAdminCriteria.model';
import {EmployeCriteria} from './EmployeCriteria.model';

export class EntiteAdminCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
      public employe: Array<EmployeCriteria>;

}
