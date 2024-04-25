package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OperationStockDetailDao extends AbstractRepository<OperationStockDetail,Long>  {

    List<OperationStockDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<OperationStockDetail> findByOperationStockId(Long id);
    int deleteByOperationStockId(Long id);
    long countByOperationStockRef(String ref);


}
