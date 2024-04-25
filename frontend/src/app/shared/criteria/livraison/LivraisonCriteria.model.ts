import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {MagasinCriteria} from '../stock/MagasinCriteria.model';
import {ReceptionCriteria} from '../reception/ReceptionCriteria.model';
import {LivraisonCriteria} from './LivraisonCriteria.model';
import {LivraisonDetailCriteria} from './LivraisonDetailCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class LivraisonCriteria  extends BaseCriteria  {

    public id: number;
    public ref: string;
    public refLike: string;
    public datelivraison: Date;
    public datelivraisonFrom: Date;
    public datelivraisonTo: Date;
  public reception: ReceptionCriteria ;
  public receptions: Array<ReceptionCriteria> ;
      public livraisonDetails: Array<LivraisonDetailCriteria>;

}
