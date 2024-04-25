package  ma.zs.stocky.dao.specification.core.livraison;

import ma.zs.stocky.dao.criteria.core.livraison.LivraisonCriteria;
import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class LivraisonSpecification extends  AbstractSpecification<LivraisonCriteria, Livraison>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("datelivraison", criteria.getDatelivraison(), criteria.getDatelivraisonFrom(), criteria.getDatelivraisonTo());
        addPredicateFk("reception","id", criteria.getReception()==null?null:criteria.getReception().getId());
        addPredicateFk("reception","id", criteria.getReceptions());
        addPredicateFk("reception","ref", criteria.getReception()==null?null:criteria.getReception().getRef());
    }

    public LivraisonSpecification(LivraisonCriteria criteria) {
        super(criteria);
    }

    public LivraisonSpecification(LivraisonCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
