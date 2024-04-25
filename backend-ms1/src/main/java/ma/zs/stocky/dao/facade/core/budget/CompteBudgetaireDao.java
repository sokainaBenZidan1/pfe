package ma.zs.stocky.dao.facade.core.budget;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CompteBudgetaireDao extends AbstractRepository<CompteBudgetaire,Long>  {


    @Query("SELECT NEW CompteBudgetaire(item.id,item.libelle) FROM CompteBudgetaire item")
    List<CompteBudgetaire> findAllOptimized();

}
