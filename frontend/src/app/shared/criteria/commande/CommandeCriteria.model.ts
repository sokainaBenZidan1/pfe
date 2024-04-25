import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntiteAdminCriteria} from '../commun/EntiteAdminCriteria.model';
import {CommandeCriteria} from './CommandeCriteria.model';
import {CommandeDetailCriteria} from './CommandeDetailCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class CommandeCriteria  extends BaseCriteria  {

    public id: number;
    public ref: string;
    public refLike: string;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaye: number;
     public totalPayeMin: number;
     public totalPayeMax: number;
    public dateCommande: Date;
    public dateCommandeFrom: Date;
    public dateCommandeTo: Date;
      public commandeDetails: Array<CommandeDetailCriteria>;

}
