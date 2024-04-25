package ma.zs.stocky.service.facade.admin.achat;

import java.util.List;
import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AchatMaterielAdminService extends  IService<AchatMateriel,AchatMaterielCriteria>  {

    List<AchatMateriel> findByBudgetId(Long id);
    int deleteByBudgetId(Long id);
    long countByBudgetId(Long id);
    List<AchatMateriel> findByTypeAchatMaterielId(Long id);
    int deleteByTypeAchatMaterielId(Long id);
    long countByTypeAchatMaterielId(Long id);




}
