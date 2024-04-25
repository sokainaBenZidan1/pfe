package ma.zs.stocky.dao.facade.core.budget;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BudgetCompteBudgetaireDao extends AbstractRepository<BudgetCompteBudgetaire,Long>  {

    List<BudgetCompteBudgetaire> findByBudgetId(Long id);
    int deleteByBudgetId(Long id);
    long countByBudgetId(Long id);
    List<BudgetCompteBudgetaire> findByCompteBudgetaireId(Long id);
    int deleteByCompteBudgetaireId(Long id);
    long countByCompteBudgetaireId(Long id);


}
