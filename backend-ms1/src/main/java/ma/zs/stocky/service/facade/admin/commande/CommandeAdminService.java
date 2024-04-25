package ma.zs.stocky.service.facade.admin.commande;

import java.util.List;
import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.dao.criteria.core.commande.CommandeCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface CommandeAdminService extends  IService<Commande,CommandeCriteria>  {

    List<Commande> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);




}
