import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {MagasinDto} from '../stock/Magasin.model';
import {ReceptionDto} from '../reception/Reception.model';
import {LivraisonDto} from './Livraison.model';
import {LivraisonDetailDto} from './LivraisonDetail.model';
import {ProduitDto} from '../produit/Produit.model';

export class LivraisonDto extends BaseDto{

    public ref: string;

   public datelivraison: Date;

    public reception: ReceptionDto ;
     public livraisonDetails: Array<LivraisonDetailDto>;
    

    constructor() {
        super();

        this.ref = '';
        this.datelivraison = null;
        this.reception = new ReceptionDto() ;
        this.livraisonDetails = new Array<LivraisonDetailDto>();

        }

}
