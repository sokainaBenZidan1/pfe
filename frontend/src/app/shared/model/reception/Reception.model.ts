import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {MagasinDto} from '../stock/Magasin.model';
import {CommandeDto} from '../commande/Commande.model';
import {ReceptionDto} from './Reception.model';
import {ProduitDto} from '../produit/Produit.model';
import {ReceptionDetailDto} from './ReceptionDetail.model';

export class ReceptionDto extends BaseDto{

    public ref: string;

   public dateReception: Date;

    public libelle: string;

    public commande: CommandeDto ;
     public receptionDetails: Array<ReceptionDetailDto>;
    

    constructor() {
        super();

        this.ref = '';
        this.dateReception = null;
        this.libelle = '';
        this.commande = new CommandeDto() ;
        this.receptionDetails = new Array<ReceptionDetailDto>();

        }

}
