package  ma.zs.stocky.dao.specification.core.budget;

import ma.zs.stocky.dao.criteria.core.budget.CompteBudgetaireCriteria;
import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class CompteBudgetaireSpecification extends  AbstractSpecification<CompteBudgetaireCriteria, CompteBudgetaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montantMax", criteria.getMontantMax(), criteria.getMontantMaxMin(), criteria.getMontantMaxMax());
    }

    public CompteBudgetaireSpecification(CompteBudgetaireCriteria criteria) {
        super(criteria);
    }

    public CompteBudgetaireSpecification(CompteBudgetaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
