import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class ResponsableInventaireCriteria  extends BaseCriteria  {

    public id: number;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public login: string;
    public loginLike: string;
    public mdp: string;
    public mdpLike: string;

}
