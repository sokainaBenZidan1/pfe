package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.dao.criteria.core.stock.StockCriteria;
import ma.zs.stocky.bean.core.stock.Stock;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class StockSpecification extends  AbstractSpecification<StockCriteria, Stock>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qte", criteria.getQte(), criteria.getQteMin(), criteria.getQteMax());
        addPredicateBigDecimal("qteDeffectueuse", criteria.getQteDeffectueuse(), criteria.getQteDeffectueuseMin(), criteria.getQteDeffectueuseMax());
        addPredicateFk("magasin","id", criteria.getMagasin()==null?null:criteria.getMagasin().getId());
        addPredicateFk("magasin","id", criteria.getMagasins());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
    }

    public StockSpecification(StockCriteria criteria) {
        super(criteria);
    }

    public StockSpecification(StockCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
