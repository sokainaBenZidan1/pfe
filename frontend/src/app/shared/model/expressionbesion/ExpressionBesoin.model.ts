import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from '../commun/EntiteAdmin.model';
import {EtatDto} from './Etat.model';
import {ExpressionBesoinDetailDto} from './ExpressionBesoinDetail.model';
import {ExpressionBesoinDto} from './ExpressionBesoin.model';
import {EmployeDto} from '../commun/Employe.model';
import {ProduitDto} from '../produit/Produit.model';

export class ExpressionBesoinDto extends BaseDto{

    public description: string;

   public dateExpression: Date;

    public employe: EmployeDto ;
    public entiteAdmin: EntiteAdminDto ;
    public etat: EtatDto ;
     public expressionBesoinDetails: Array<ExpressionBesoinDetailDto>;
    

    constructor() {
        super();

        this.description = '';
        this.dateExpression = null;
        this.expressionBesoinDetails = new Array<ExpressionBesoinDetailDto>();

        }

}
