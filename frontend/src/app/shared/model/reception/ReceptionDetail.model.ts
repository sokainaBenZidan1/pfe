import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {MagasinDto} from '../stock/Magasin.model';
import {ReceptionDto} from './Reception.model';
import {ProduitDto} from '../produit/Produit.model';

export class ReceptionDetailDto extends BaseDto{

    public qte: null | number;

    public magasin: MagasinDto ;
    public produit: ProduitDto ;
    public reception: ReceptionDto ;
    

    constructor() {
        super();

        this.qte = null;

        }

}
