package ma.zs.stocky.service.facade.admin.mandat;

import java.util.List;
import ma.zs.stocky.bean.core.mandat.Mandat;
import ma.zs.stocky.dao.criteria.core.mandat.MandatCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface MandatAdminService extends  IService<Mandat,MandatCriteria>  {

    List<Mandat> findByEmployeId(Long id);
    int deleteByEmployeId(Long id);
    long countByEmployeNom(String nom);
    List<Mandat> findByResponsabiliteId(Long id);
    int deleteByResponsabiliteId(Long id);
    long countByResponsabiliteId(Long id);
    List<Mandat> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);




}
