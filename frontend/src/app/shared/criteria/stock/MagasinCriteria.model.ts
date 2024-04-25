import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class MagasinCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public adresse: string;
    public adresseLike: string;

}
