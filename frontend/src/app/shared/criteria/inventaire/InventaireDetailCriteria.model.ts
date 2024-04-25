import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {InventaireCriteria} from './InventaireCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class InventaireDetailCriteria  extends BaseCriteria  {

    public id: number;
     public qteCalculee: number;
     public qteCalculeeMin: number;
     public qteCalculeeMax: number;
     public qteStock: number;
     public qteStockMin: number;
     public qteStockMax: number;
     public ecart: number;
     public ecartMin: number;
     public ecartMax: number;
    public magasin: string;
    public magasinLike: string;

}
