import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {InventaireDto} from './Inventaire.model';
import {ProduitDto} from '../produit/Produit.model';

export class InventaireDetailDto extends BaseDto{

    public qteCalculee: null | number;

    public qteStock: null | number;

    public ecart: null | number;

    public magasin: string;

    public produit: ProduitDto ;
    public inventaire: InventaireDto ;
    

    constructor() {
        super();

        this.qteCalculee = null;
        this.qteStock = null;
        this.ecart = null;
        this.magasin = '';

        }

}
