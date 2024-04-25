package ma.zs.stocky.dao.facade.core.livraison;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LivraisonDetailDao extends AbstractRepository<LivraisonDetail,Long>  {

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
