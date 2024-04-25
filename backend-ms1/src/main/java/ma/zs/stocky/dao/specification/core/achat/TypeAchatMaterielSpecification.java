package  ma.zs.stocky.dao.specification.core.achat;

import ma.zs.stocky.dao.criteria.core.achat.TypeAchatMaterielCriteria;
import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class TypeAchatMaterielSpecification extends  AbstractSpecification<TypeAchatMaterielCriteria, TypeAchatMateriel>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TypeAchatMaterielSpecification(TypeAchatMaterielCriteria criteria) {
        super(criteria);
    }

    public TypeAchatMaterielSpecification(TypeAchatMaterielCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
