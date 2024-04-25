package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class EntiteAdminSpecification extends  AbstractSpecification<EntiteAdminCriteria, EntiteAdmin>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EntiteAdminSpecification(EntiteAdminCriteria criteria) {
        super(criteria);
    }

    public EntiteAdminSpecification(EntiteAdminCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
