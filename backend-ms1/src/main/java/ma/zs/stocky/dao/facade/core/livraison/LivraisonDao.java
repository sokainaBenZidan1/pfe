package ma.zs.stocky.dao.facade.core.livraison;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.livraison.Livraison;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.livraison.Livraison;
import java.util.List;


@Repository
public interface LivraisonDao extends AbstractRepository<Livraison,Long>  {
    Livraison findByRef(String ref);
    int deleteByRef(String ref);

    List<Livraison> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);
    long countByReceptionRef(String ref);

    @Query("SELECT NEW Livraison(item.id,item.ref) FROM Livraison item")
    List<Livraison> findAllOptimized();

}
