package ma.zs.stocky.dao.facade.core.commande;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commande.Commande;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.commande.Commande;
import java.util.List;


@Repository
public interface CommandeDao extends AbstractRepository<Commande,Long>  {
    Commande findByRef(String ref);
    int deleteByRef(String ref);

    List<Commande> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);

    @Query("SELECT NEW Commande(item.id,item.ref) FROM Commande item")
    List<Commande> findAllOptimized();

}
