import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {MagasinCriteria} from './MagasinCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class StockCriteria  extends BaseCriteria  {

    public id: number;
     public qte: number;
     public qteMin: number;
     public qteMax: number;
     public qteDeffectueuse: number;
     public qteDeffectueuseMin: number;
     public qteDeffectueuseMax: number;
  public magasin: MagasinCriteria ;
  public magasins: Array<MagasinCriteria> ;

}
