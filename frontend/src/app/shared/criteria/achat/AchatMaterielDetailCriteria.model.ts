import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';
import {AchatMaterielCriteria} from './AchatMaterielCriteria.model';

export class AchatMaterielDetailCriteria  extends BaseCriteria  {

    public id: number;
     public qteAchetee: number;
     public qteAcheteeMin: number;
     public qteAcheteeMax: number;
     public qteRecue: number;
     public qteRecueMin: number;
     public qteRecueMax: number;
     public qteLivree: number;
     public qteLivreeMin: number;
     public qteLivreeMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public achatMateriel: AchatMaterielCriteria ;
  public achatMateriels: Array<AchatMaterielCriteria> ;

}
