import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from '../produit/Produit.model';
import {AchatMaterielDto} from './AchatMateriel.model';

export class AchatMaterielDetailDto extends BaseDto{

    public qteAchetee: null | number;

    public qteRecue: null | number;

    public qteLivree: null | number;

    public produit: ProduitDto ;
    public achatMateriel: AchatMaterielDto ;
    

    constructor() {
        super();

        this.qteAchetee = null;
        this.qteRecue = null;
        this.qteLivree = null;
        this.produit = new ProduitDto() ;
        this.achatMateriel = new AchatMaterielDto() ;

        }

}
