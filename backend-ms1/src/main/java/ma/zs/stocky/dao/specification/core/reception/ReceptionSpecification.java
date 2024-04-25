package  ma.zs.stocky.dao.specification.core.reception;

import ma.zs.stocky.dao.criteria.core.reception.ReceptionCriteria;
import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ReceptionSpecification extends  AbstractSpecification<ReceptionCriteria, Reception>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("dateReception", criteria.getDateReception(), criteria.getDateReceptionFrom(), criteria.getDateReceptionTo());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("commande","id", criteria.getCommande()==null?null:criteria.getCommande().getId());
        addPredicateFk("commande","id", criteria.getCommandes());
        addPredicateFk("commande","ref", criteria.getCommande()==null?null:criteria.getCommande().getRef());
    }

    public ReceptionSpecification(ReceptionCriteria criteria) {
        super(criteria);
    }

    public ReceptionSpecification(ReceptionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
