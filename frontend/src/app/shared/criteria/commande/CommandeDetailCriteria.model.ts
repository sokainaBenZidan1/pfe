import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CommandeCriteria} from './CommandeCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class CommandeDetailCriteria  extends BaseCriteria  {

    public id: number;
     public prix: number;
     public prixMin: number;
     public prixMax: number;
     public qte: number;
     public qteMin: number;
     public qteMax: number;
  public commande: CommandeCriteria ;
  public commandes: Array<CommandeCriteria> ;

}
