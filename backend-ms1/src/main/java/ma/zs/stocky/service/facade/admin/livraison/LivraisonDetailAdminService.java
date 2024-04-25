package ma.zs.stocky.service.facade.admin.livraison;

import java.util.List;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.dao.criteria.core.livraison.LivraisonDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface LivraisonDetailAdminService extends  IService<LivraisonDetail,LivraisonDetailCriteria>  {

    List<LivraisonDetail> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    long countByMagasinId(Long id);
    List<LivraisonDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<LivraisonDetail> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);
    long countByLivraisonRef(String ref);




}
