package ma.zs.stocky.dao.facade.core.produit;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.produit.CategorieProduit;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CategorieProduitDao extends AbstractRepository<CategorieProduit,Long>  {

    List<CategorieProduit> findByCompteBudgetaireId(Long id);
    int deleteByCompteBudgetaireId(Long id);
    long countByCompteBudgetaireId(Long id);

    @Query("SELECT NEW CategorieProduit(item.id,item.libelle) FROM CategorieProduit item")
    List<CategorieProduit> findAllOptimized();

}
