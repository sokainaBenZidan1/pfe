package  ma.zs.stocky.dao.specification.core.inventaire;

import ma.zs.stocky.dao.criteria.core.inventaire.InventaireCriteria;
import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class InventaireSpecification extends  AbstractSpecification<InventaireCriteria, Inventaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("responsableInv","id", criteria.getResponsableInv()==null?null:criteria.getResponsableInv().getId());
        addPredicateFk("responsableInv","id", criteria.getResponsableInvs());
    }

    public InventaireSpecification(InventaireCriteria criteria) {
        super(criteria);
    }

    public InventaireSpecification(InventaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
