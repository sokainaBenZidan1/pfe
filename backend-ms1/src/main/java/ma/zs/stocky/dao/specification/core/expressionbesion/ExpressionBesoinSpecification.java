package  ma.zs.stocky.dao.specification.core.expressionbesion;

import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinCriteria;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ExpressionBesoinSpecification extends  AbstractSpecification<ExpressionBesoinCriteria, ExpressionBesoin>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateExpression", criteria.getDateExpression(), criteria.getDateExpressionFrom(), criteria.getDateExpressionTo());
        addPredicateFk("employe","id", criteria.getEmploye()==null?null:criteria.getEmploye().getId());
        addPredicateFk("employe","id", criteria.getEmployes());
        addPredicateFk("employe","nom", criteria.getEmploye()==null?null:criteria.getEmploye().getNom());
        addPredicateFk("entiteAdmin","id", criteria.getEntiteAdmin()==null?null:criteria.getEntiteAdmin().getId());
        addPredicateFk("entiteAdmin","id", criteria.getEntiteAdmins());
        addPredicateFk("entiteAdmin","code", criteria.getEntiteAdmin()==null?null:criteria.getEntiteAdmin().getCode());
        addPredicateFk("etat","id", criteria.getEtat()==null?null:criteria.getEtat().getId());
        addPredicateFk("etat","id", criteria.getEtats());
        addPredicateFk("etat","code", criteria.getEtat()==null?null:criteria.getEtat().getCode());
    }

    public ExpressionBesoinSpecification(ExpressionBesoinCriteria criteria) {
        super(criteria);
    }

    public ExpressionBesoinSpecification(ExpressionBesoinCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
