package  ma.zs.stocky.dao.specification.core.budget;

import ma.zs.stocky.dao.criteria.core.budget.BudgetCompteBudgetaireCriteria;
import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class BudgetCompteBudgetaireSpecification extends  AbstractSpecification<BudgetCompteBudgetaireCriteria, BudgetCompteBudgetaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("budget","id", criteria.getBudget()==null?null:criteria.getBudget().getId());
        addPredicateFk("budget","id", criteria.getBudgets());
        addPredicateFk("compteBudgetaire","id", criteria.getCompteBudgetaire()==null?null:criteria.getCompteBudgetaire().getId());
        addPredicateFk("compteBudgetaire","id", criteria.getCompteBudgetaires());
    }

    public BudgetCompteBudgetaireSpecification(BudgetCompteBudgetaireCriteria criteria) {
        super(criteria);
    }

    public BudgetCompteBudgetaireSpecification(BudgetCompteBudgetaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
