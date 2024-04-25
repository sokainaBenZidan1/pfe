import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {MagasinDto} from '../stock/Magasin.model';
import {LivraisonDto} from './Livraison.model';
import {ProduitDto} from '../produit/Produit.model';

export class LivraisonDetailDto extends BaseDto{

    public qte: null | number;

    public magasin: MagasinDto ;
    public produit: ProduitDto ;
    public livraison: LivraisonDto ;
    

    constructor() {
        super();

        this.qte = null;

        }

}
