package ma.zs.stocky.dao.facade.core.reception;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReceptionDetailDao extends AbstractRepository<ReceptionDetail,Long>  {

    List<ReceptionDetail> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    long countByMagasinId(Long id);
    List<ReceptionDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<ReceptionDetail> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);
    long countByReceptionRef(String ref);


}
