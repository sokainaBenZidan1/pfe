import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ResponsableInventaireDto} from './ResponsableInventaire.model';
import {InventaireDetailDto} from './InventaireDetail.model';
import {InventaireDto} from './Inventaire.model';
import {ProduitDto} from '../produit/Produit.model';

export class InventaireDto extends BaseDto{

   public dateDebut: Date;

   public dateFin: Date;

    public responsableInv: ResponsableInventaireDto ;
     public inventaireDetails: Array<InventaireDetailDto>;
    

    constructor() {
        super();

        this.dateDebut = null;
        this.dateFin = null;
        this.responsableInv = new ResponsableInventaireDto() ;
        this.inventaireDetails = new Array<InventaireDetailDto>();

        }

}
