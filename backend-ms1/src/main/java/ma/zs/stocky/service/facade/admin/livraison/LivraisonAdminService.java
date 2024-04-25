package ma.zs.stocky.service.facade.admin.livraison;

import java.util.List;
import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.dao.criteria.core.livraison.LivraisonCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface LivraisonAdminService extends  IService<Livraison,LivraisonCriteria>  {

    List<Livraison> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);
    long countByReceptionRef(String ref);




}
