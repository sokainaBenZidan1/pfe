import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CommandeDto} from './Commande.model';
import {ProduitDto} from '../produit/Produit.model';

export class CommandeDetailDto extends BaseDto{

    public prix: null | number;

    public qte: null | number;

    public commande: CommandeDto ;
    public produit: ProduitDto ;
    

    constructor() {
        super();

        this.prix = null;
        this.qte = null;
        this.commande = new CommandeDto() ;

        }

}
