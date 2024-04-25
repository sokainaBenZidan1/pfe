package ma.zs.stocky.dao.facade.core.budget;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.budget.Budget;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BudgetDao extends AbstractRepository<Budget,Long>  {



}
