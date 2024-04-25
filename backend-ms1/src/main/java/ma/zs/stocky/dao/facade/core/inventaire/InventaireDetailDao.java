package ma.zs.stocky.dao.facade.core.inventaire;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InventaireDetailDao extends AbstractRepository<InventaireDetail,Long>  {

    List<InventaireDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<InventaireDetail> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);
    long countByInventaireId(Long id);


}
