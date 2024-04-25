import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {MagasinCriteria} from '../stock/MagasinCriteria.model';
import {CommandeCriteria} from '../commande/CommandeCriteria.model';
import {ReceptionCriteria} from './ReceptionCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';
import {ReceptionDetailCriteria} from './ReceptionDetailCriteria.model';

export class ReceptionCriteria  extends BaseCriteria  {

    public id: number;
    public ref: string;
    public refLike: string;
    public dateReception: Date;
    public dateReceptionFrom: Date;
    public dateReceptionTo: Date;
    public libelle: string;
    public libelleLike: string;
  public commande: CommandeCriteria ;
  public commandes: Array<CommandeCriteria> ;
      public receptionDetails: Array<ReceptionDetailCriteria>;

}
