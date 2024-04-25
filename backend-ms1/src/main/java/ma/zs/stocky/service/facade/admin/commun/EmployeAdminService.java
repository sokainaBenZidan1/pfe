package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.Employe;
import ma.zs.stocky.dao.criteria.core.commun.EmployeCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface EmployeAdminService extends  IService<Employe,EmployeCriteria>  {

    List<Employe> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);




}
