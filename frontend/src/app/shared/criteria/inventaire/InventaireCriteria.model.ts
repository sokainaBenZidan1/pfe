import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ResponsableInventaireCriteria} from './ResponsableInventaireCriteria.model';
import {InventaireDetailCriteria} from './InventaireDetailCriteria.model';
import {InventaireCriteria} from './InventaireCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class InventaireCriteria  extends BaseCriteria  {

    public id: number;
    public dateDebut: Date;
    public dateDebutFrom: Date;
    public dateDebutTo: Date;
    public dateFin: Date;
    public dateFinFrom: Date;
    public dateFinTo: Date;
  public responsableInv: ResponsableInventaireCriteria ;
  public responsableInvs: Array<ResponsableInventaireCriteria> ;
      public inventaireDetails: Array<InventaireDetailCriteria>;

}
