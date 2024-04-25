import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TypeAchatMaterielCriteria} from './TypeAchatMaterielCriteria.model';
import {BudgetCriteria} from '../budget/BudgetCriteria.model';
import {AchatMaterielDetailCriteria} from './AchatMaterielDetailCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';
import {AchatMaterielCriteria} from './AchatMaterielCriteria.model';

export class AchatMaterielCriteria  extends BaseCriteria  {

    public id: number;
     public montantTotal: number;
     public montantTotalMin: number;
     public montantTotalMax: number;
    public dateAchat: Date;
    public dateAchatFrom: Date;
    public dateAchatTo: Date;
  public budget: BudgetCriteria ;
  public budgets: Array<BudgetCriteria> ;
  public typeAchatMateriel: TypeAchatMaterielCriteria ;
  public typeAchatMateriels: Array<TypeAchatMaterielCriteria> ;
      public achatMaterielDetails: Array<AchatMaterielDetailCriteria>;

}
