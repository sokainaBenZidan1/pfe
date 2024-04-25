import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ExpressionBesoinCriteria} from './ExpressionBesoinCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class ExpressionBesoinDetailCriteria  extends BaseCriteria  {

    public id: number;
     public qteDemandee: number;
     public qteDemandeeMin: number;
     public qteDemandeeMax: number;
     public qteAccordee: number;
     public qteAccordeeMin: number;
     public qteAccordeeMax: number;
     public qteLivre: number;
     public qteLivreMin: number;
     public qteLivreMax: number;
  public expressionBesoin: ExpressionBesoinCriteria ;
  public expressionBesoins: Array<ExpressionBesoinCriteria> ;

}
