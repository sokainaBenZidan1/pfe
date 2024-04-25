package ma.zs.stocky.service.facade.admin.reception;

import java.util.List;
import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.dao.criteria.core.reception.ReceptionCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ReceptionAdminService extends  IService<Reception,ReceptionCriteria>  {

    List<Reception> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeRef(String ref);




}
