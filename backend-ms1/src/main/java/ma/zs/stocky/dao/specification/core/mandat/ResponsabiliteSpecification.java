package  ma.zs.stocky.dao.specification.core.mandat;

import ma.zs.stocky.dao.criteria.core.mandat.ResponsabiliteCriteria;
import ma.zs.stocky.bean.core.mandat.Responsabilite;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ResponsabiliteSpecification extends  AbstractSpecification<ResponsabiliteCriteria, Responsabilite>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ResponsabiliteSpecification(ResponsabiliteCriteria criteria) {
        super(criteria);
    }

    public ResponsabiliteSpecification(ResponsabiliteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
