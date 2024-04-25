import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {OperationStockCriteria} from './OperationStockCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class OperationStockDetailCriteria  extends BaseCriteria  {

    public id: number;
     public qte: number;
     public qteMin: number;
     public qteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public operationStock: OperationStockCriteria ;
  public operationStocks: Array<OperationStockCriteria> ;

}
