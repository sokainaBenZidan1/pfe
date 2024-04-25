package ma.zs.stocky.service.facade.admin.commande;

import java.util.List;
import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.dao.criteria.core.commande.CommandeDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface CommandeDetailAdminService extends  IService<CommandeDetail,CommandeDetailCriteria>  {

    List<CommandeDetail> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeRef(String ref);
    List<CommandeDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);




}
