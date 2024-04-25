package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.dao.criteria.core.stock.OperationStockDetailCriteria;
import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class OperationStockDetailSpecification extends  AbstractSpecification<OperationStockDetailCriteria, OperationStockDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qte", criteria.getQte(), criteria.getQteMin(), criteria.getQteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
        addPredicateFk("operationStock","id", criteria.getOperationStock()==null?null:criteria.getOperationStock().getId());
        addPredicateFk("operationStock","id", criteria.getOperationStocks());
        addPredicateFk("operationStock","ref", criteria.getOperationStock()==null?null:criteria.getOperationStock().getRef());
    }

    public OperationStockDetailSpecification(OperationStockDetailCriteria criteria) {
        super(criteria);
    }

    public OperationStockDetailSpecification(OperationStockDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
