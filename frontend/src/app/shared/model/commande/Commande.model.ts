import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntiteAdminDto} from '../commun/EntiteAdmin.model';
import {CommandeDto} from './Commande.model';
import {CommandeDetailDto} from './CommandeDetail.model';
import {ProduitDto} from '../produit/Produit.model';

export class CommandeDto extends BaseDto{

    public ref: string;

    public total: null | number;

    public totalPaye: null | number;

   public dateCommande: Date;

    public entiteAdmin: EntiteAdminDto ;
     public commandeDetails: Array<CommandeDetailDto>;
    

    constructor() {
        super();

        this.ref = '';
        this.total = null;
        this.totalPaye = null;
        this.dateCommande = null;
        this.commandeDetails = new Array<CommandeDetailDto>();

        }

}
