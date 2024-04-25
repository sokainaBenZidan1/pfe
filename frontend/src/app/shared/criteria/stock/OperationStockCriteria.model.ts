import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {MagasinCriteria} from './MagasinCriteria.model';
import {OperationStockCriteria} from './OperationStockCriteria.model';
import {OperationStockDetailCriteria} from './OperationStockDetailCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class OperationStockCriteria  extends BaseCriteria  {

    public id: number;
    public ref: string;
    public refLike: string;
    public dateOS: Date;
    public dateOSFrom: Date;
    public dateOSTo: Date;
    public discription: string;
    public discriptionLike: string;
  public magasinSource: MagasinCriteria ;
  public magasinSources: Array<MagasinCriteria> ;
  public magasinDest: MagasinCriteria ;
  public magasinDests: Array<MagasinCriteria> ;
      public operationStockDetails: Array<OperationStockDetailCriteria>;

}
