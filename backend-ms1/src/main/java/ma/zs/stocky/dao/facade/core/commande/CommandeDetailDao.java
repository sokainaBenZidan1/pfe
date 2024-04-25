package ma.zs.stocky.dao.facade.core.commande;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commande.CommandeDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommandeDetailDao extends AbstractRepository<CommandeDetail,Long>  {

    List<CommandeDetail> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeRef(String ref);
    List<CommandeDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);


}
