package  ma.zs.stocky.dao.specification.core.budget;

import ma.zs.stocky.dao.criteria.core.budget.BudgetEntiteAdminCriteria;
import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class BudgetEntiteAdminSpecification extends  AbstractSpecification<BudgetEntiteAdminCriteria, BudgetEntiteAdmin>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("montantEntite", criteria.getMontantEntite(), criteria.getMontantEntiteMin(), criteria.getMontantEntiteMax());
        addPredicateBigDecimal("montantInvEntite", criteria.getMontantInvEntite(), criteria.getMontantInvEntiteMin(), criteria.getMontantInvEntiteMax());
        addPredicateBigDecimal("montantFctEntite", criteria.getMontantFctEntite(), criteria.getMontantFctEntiteMin(), criteria.getMontantFctEntiteMax());
        addPredicateFk("entiteAdmin","id", criteria.getEntiteAdmin()==null?null:criteria.getEntiteAdmin().getId());
        addPredicateFk("entiteAdmin","id", criteria.getEntiteAdmins());
        addPredicateFk("entiteAdmin","code", criteria.getEntiteAdmin()==null?null:criteria.getEntiteAdmin().getCode());
        addPredicateFk("budget","id", criteria.getBudget()==null?null:criteria.getBudget().getId());
        addPredicateFk("budget","id", criteria.getBudgets());
    }

    public BudgetEntiteAdminSpecification(BudgetEntiteAdminCriteria criteria) {
        super(criteria);
    }

    public BudgetEntiteAdminSpecification(BudgetEntiteAdminCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
