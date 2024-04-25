import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ExpressionBesoinDto} from './ExpressionBesoin.model';
import {ProduitDto} from '../produit/Produit.model';

export class ExpressionBesoinDetailDto extends BaseDto{

    public qteDemandee: null | number;

    public qteAccordee: null | number;

    public qteLivre: null | number;

    public expressionBesoin: ExpressionBesoinDto ;
    public produit: ProduitDto ;
    

    constructor() {
        super();

        this.qteDemandee = null;
        this.qteAccordee = null;
        this.qteLivre = null;
        this.expressionBesoin = new ExpressionBesoinDto() ;

        }

}
