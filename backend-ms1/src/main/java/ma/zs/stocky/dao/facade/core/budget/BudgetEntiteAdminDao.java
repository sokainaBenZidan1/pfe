package ma.zs.stocky.dao.facade.core.budget;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BudgetEntiteAdminDao extends AbstractRepository<BudgetEntiteAdmin,Long>  {

    List<BudgetEntiteAdmin> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);
    List<BudgetEntiteAdmin> findByBudgetId(Long id);
    int deleteByBudgetId(Long id);
    long countByBudgetId(Long id);


}
