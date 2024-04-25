import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {MagasinDto} from './Magasin.model';
import {ProduitDto} from '../produit/Produit.model';

export class StockDto extends BaseDto{

    public qte: null | number;

    public qteDeffectueuse: null | number;

    public magasin: MagasinDto ;
    public produit: ProduitDto ;
    

    constructor() {
        super();

        this.qte = null;
        this.qteDeffectueuse = null;
        this.magasin = new MagasinDto() ;

        }

}
