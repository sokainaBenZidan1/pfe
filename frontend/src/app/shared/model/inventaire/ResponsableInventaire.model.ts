import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ResponsableInventaireDto extends BaseDto{

    public nom: string;

    public prenom: string;

    public login: string;

    public mdp: string;

    

    constructor() {
        super();

        this.nom = '';
        this.prenom = '';
        this.login = '';
        this.mdp = '';

        }

}
