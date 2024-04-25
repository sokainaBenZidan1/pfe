package ma.zs.stocky.service.facade.admin.inventaire;

import java.util.List;
import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.dao.criteria.core.inventaire.InventaireCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface InventaireAdminService extends  IService<Inventaire,InventaireCriteria>  {

    List<Inventaire> findByResponsableInvId(Long id);
    int deleteByResponsableInvId(Long id);
    long countByResponsableInvId(Long id);




}
