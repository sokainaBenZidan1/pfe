import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CompteBudgetaireDto} from '../budget/CompteBudgetaire.model';

export class CategorieProduitDto extends BaseDto{

    public libelle: string;

    public code: string;

    public compteBudgetaire: CompteBudgetaireDto ;
    

    constructor() {
        super();

        this.libelle = '';
        this.code = '';

        }

}
