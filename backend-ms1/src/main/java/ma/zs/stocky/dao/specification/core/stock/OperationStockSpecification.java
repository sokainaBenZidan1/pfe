package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.dao.criteria.core.stock.OperationStockCriteria;
import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class OperationStockSpecification extends  AbstractSpecification<OperationStockCriteria, OperationStock>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("dateOS", criteria.getDateOS(), criteria.getDateOSFrom(), criteria.getDateOSTo());
        addPredicate("discription", criteria.getDiscription(),criteria.getDiscriptionLike());
        addPredicateFk("magasinSource","id", criteria.getMagasinSource()==null?null:criteria.getMagasinSource().getId());
        addPredicateFk("magasinSource","id", criteria.getMagasinSources());
        addPredicateFk("magasinDest","id", criteria.getMagasinDest()==null?null:criteria.getMagasinDest().getId());
        addPredicateFk("magasinDest","id", criteria.getMagasinDests());
    }

    public OperationStockSpecification(OperationStockCriteria criteria) {
        super(criteria);
    }

    public OperationStockSpecification(OperationStockCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
