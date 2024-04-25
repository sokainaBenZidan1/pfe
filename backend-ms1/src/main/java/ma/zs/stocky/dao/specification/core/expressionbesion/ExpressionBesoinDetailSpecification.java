package  ma.zs.stocky.dao.specification.core.expressionbesion;

import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinDetailCriteria;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ExpressionBesoinDetailSpecification extends  AbstractSpecification<ExpressionBesoinDetailCriteria, ExpressionBesoinDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qteDemandee", criteria.getQteDemandee(), criteria.getQteDemandeeMin(), criteria.getQteDemandeeMax());
        addPredicateBigDecimal("qteAccordee", criteria.getQteAccordee(), criteria.getQteAccordeeMin(), criteria.getQteAccordeeMax());
        addPredicateBigDecimal("qteLivre", criteria.getQteLivre(), criteria.getQteLivreMin(), criteria.getQteLivreMax());
        addPredicateFk("expressionBesoin","id", criteria.getExpressionBesoin()==null?null:criteria.getExpressionBesoin().getId());
        addPredicateFk("expressionBesoin","id", criteria.getExpressionBesoins());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
    }

    public ExpressionBesoinDetailSpecification(ExpressionBesoinDetailCriteria criteria) {
        super(criteria);
    }

    public ExpressionBesoinDetailSpecification(ExpressionBesoinDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
