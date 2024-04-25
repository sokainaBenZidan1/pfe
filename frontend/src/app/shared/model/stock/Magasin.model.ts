import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class MagasinDto extends BaseDto{

    public code: string;

    public adresse: string;

    

    constructor() {
        super();

        this.code = '';
        this.adresse = '';

        }

}
