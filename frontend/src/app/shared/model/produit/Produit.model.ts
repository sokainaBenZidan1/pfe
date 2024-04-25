import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CategorieProduitDto} from './CategorieProduit.model';

export class ProduitDto extends BaseDto{

    public code: string;

    public libelle: string;

    public categorieProduit: CategorieProduitDto ;
    

    constructor() {
        super();

        this.code = '';
        this.libelle = '';
        this.categorieProduit = new CategorieProduitDto() ;

        }

}
