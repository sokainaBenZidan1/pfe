import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeAchatMaterielDto} from './TypeAchatMateriel.model';
import {BudgetDto} from '../budget/Budget.model';
import {AchatMaterielDetailDto} from './AchatMaterielDetail.model';
import {ProduitDto} from '../produit/Produit.model';
import {AchatMaterielDto} from './AchatMateriel.model';

export class AchatMaterielDto extends BaseDto{

    public montantTotal: null | number;

   public dateAchat: Date;

    public budget: BudgetDto ;
    public typeAchatMateriel: TypeAchatMaterielDto ;
     public achatMaterielDetails: Array<AchatMaterielDetailDto>;
    

    constructor() {
        super();

        this.montantTotal = null;
        this.dateAchat = null;
        this.budget = new BudgetDto() ;
        this.typeAchatMateriel = new TypeAchatMaterielDto() ;
        this.achatMaterielDetails = new Array<AchatMaterielDetailDto>();

        }

}
