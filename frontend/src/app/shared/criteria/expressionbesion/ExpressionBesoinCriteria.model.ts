import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntiteAdminCriteria} from '../commun/EntiteAdminCriteria.model';
import {EtatCriteria} from './EtatCriteria.model';
import {ExpressionBesoinDetailCriteria} from './ExpressionBesoinDetailCriteria.model';
import {ExpressionBesoinCriteria} from './ExpressionBesoinCriteria.model';
import {EmployeCriteria} from '../commun/EmployeCriteria.model';
import {ProduitCriteria} from '../produit/ProduitCriteria.model';

export class ExpressionBesoinCriteria  extends BaseCriteria  {

    public id: number;
    public description: string;
    public descriptionLike: string;
    public dateExpression: Date;
    public dateExpressionFrom: Date;
    public dateExpressionTo: Date;
      public expressionBesoinDetails: Array<ExpressionBesoinDetailCriteria>;

}
