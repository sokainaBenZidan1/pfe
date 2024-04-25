import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CompteBudgetaireDto extends BaseDto{

    public libelle: string;

    public code: string;

    public montantMax: null | number;

    

    constructor() {
        super();

        this.libelle = '';
        this.code = '';
        this.montantMax = null;

        }

}
