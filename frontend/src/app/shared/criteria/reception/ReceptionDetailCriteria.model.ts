import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {MagasinCriteria} from '../stock/MagasinCriteria.model';
import {ReceptionCriteria} from './ReceptionCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class ReceptionDetailCriteria  extends BaseCriteria  {

    public id: number;
     public qte: number;
     public qteMin: number;
     public qteMax: number;

}
