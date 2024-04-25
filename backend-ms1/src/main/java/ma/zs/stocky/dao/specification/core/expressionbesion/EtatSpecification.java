package  ma.zs.stocky.dao.specification.core.expressionbesion;

import ma.zs.stocky.dao.criteria.core.expressionbesion.EtatCriteria;
import ma.zs.stocky.bean.core.expressionbesion.Etat;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class EtatSpecification extends  AbstractSpecification<EtatCriteria, Etat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatSpecification(EtatCriteria criteria) {
        super(criteria);
    }

    public EtatSpecification(EtatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
