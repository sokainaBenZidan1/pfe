package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.dao.criteria.core.stock.MagasinCriteria;
import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class MagasinSpecification extends  AbstractSpecification<MagasinCriteria, Magasin>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
    }

    public MagasinSpecification(MagasinCriteria criteria) {
        super(criteria);
    }

    public MagasinSpecification(MagasinCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
