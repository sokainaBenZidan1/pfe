import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntiteAdminCriteria} from '../commun/EntiteAdminCriteria.model';
import {ResponsabiliteCriteria} from './ResponsabiliteCriteria.model';
import {EmployeCriteria} from '../commun/EmployeCriteria.model';

export class MandatCriteria  extends BaseCriteria  {

    public id: number;
    public dateDebut: Date;
    public dateDebutFrom: Date;
    public dateDebutTo: Date;
    public dateFin: Date;
    public dateFinFrom: Date;
    public dateFinTo: Date;
  public employe: EmployeCriteria ;
  public employes: Array<EmployeCriteria> ;
  public responsabilite: ResponsabiliteCriteria ;
  public responsabilites: Array<ResponsabiliteCriteria> ;

}
