package  ma.zs.stocky.dao.specification.core.mandat;

import ma.zs.stocky.dao.criteria.core.mandat.MandatCriteria;
import ma.zs.stocky.bean.core.mandat.Mandat;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class MandatSpecification extends  AbstractSpecification<MandatCriteria, Mandat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("employe","id", criteria.getEmploye()==null?null:criteria.getEmploye().getId());
        addPredicateFk("employe","id", criteria.getEmployes());
        addPredicateFk("employe","nom", criteria.getEmploye()==null?null:criteria.getEmploye().getNom());
        addPredicateFk("responsabilite","id", criteria.getResponsabilite()==null?null:criteria.getResponsabilite().getId());
        addPredicateFk("responsabilite","id", criteria.getResponsabilites());
        addPredicateFk("entiteAdmin","id", criteria.getEntiteAdmin()==null?null:criteria.getEntiteAdmin().getId());
        addPredicateFk("entiteAdmin","id", criteria.getEntiteAdmins());
        addPredicateFk("entiteAdmin","code", criteria.getEntiteAdmin()==null?null:criteria.getEntiteAdmin().getCode());
    }

    public MandatSpecification(MandatCriteria criteria) {
        super(criteria);
    }

    public MandatSpecification(MandatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
