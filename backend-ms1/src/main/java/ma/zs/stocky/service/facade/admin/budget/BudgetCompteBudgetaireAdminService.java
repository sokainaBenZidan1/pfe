package ma.zs.stocky.service.facade.admin.budget;

import java.util.List;
import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import ma.zs.stocky.dao.criteria.core.budget.BudgetCompteBudgetaireCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface BudgetCompteBudgetaireAdminService extends  IService<BudgetCompteBudgetaire,BudgetCompteBudgetaireCriteria>  {

    List<BudgetCompteBudgetaire> findByBudgetId(Long id);
    int deleteByBudgetId(Long id);
    long countByBudgetId(Long id);
    List<BudgetCompteBudgetaire> findByCompteBudgetaireId(Long id);
    int deleteByCompteBudgetaireId(Long id);
    long countByCompteBudgetaireId(Long id);




}
