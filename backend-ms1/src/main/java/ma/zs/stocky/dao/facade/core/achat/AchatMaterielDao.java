package ma.zs.stocky.dao.facade.core.achat;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.achat.AchatMateriel;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AchatMaterielDao extends AbstractRepository<AchatMateriel,Long>  {

    List<AchatMateriel> findByBudgetId(Long id);
    int deleteByBudgetId(Long id);
    long countByBudgetId(Long id);
    List<AchatMateriel> findByTypeAchatMaterielId(Long id);
    int deleteByTypeAchatMaterielId(Long id);
    long countByTypeAchatMaterielId(Long id);


}
