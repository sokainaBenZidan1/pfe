import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CategorieProduitCriteria} from './CategorieProduitCriteria.model';

export class ProduitCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public categorieProduit: CategorieProduitCriteria ;
  public categorieProduits: Array<CategorieProduitCriteria> ;

}
