package ma.zs.stocky.dao.facade.core.achat;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AchatMaterielDetailDao extends AbstractRepository<AchatMaterielDetail,Long>  {

    List<AchatMaterielDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<AchatMaterielDetail> findByAchatMaterielId(Long id);
    int deleteByAchatMaterielId(Long id);
    long countByAchatMaterielId(Long id);


}
