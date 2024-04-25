package ma.zs.stocky.service.facade.admin.budget;

import java.util.List;
import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import ma.zs.stocky.dao.criteria.core.budget.BudgetEntiteAdminCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface BudgetEntiteAdminAdminService extends  IService<BudgetEntiteAdmin,BudgetEntiteAdminCriteria>  {

    List<BudgetEntiteAdmin> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);
    List<BudgetEntiteAdmin> findByBudgetId(Long id);
    int deleteByBudgetId(Long id);
    long countByBudgetId(Long id);




}
