package ma.zs.stocky.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.OperationStock;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.stock.OperationStock;
import java.util.List;


@Repository
public interface OperationStockDao extends AbstractRepository<OperationStock,Long>  {
    OperationStock findByRef(String ref);
    int deleteByRef(String ref);

    List<OperationStock> findByMagasinSourceId(Long id);
    int deleteByMagasinSourceId(Long id);
    long countByMagasinSourceId(Long id);
    List<OperationStock> findByMagasinDestId(Long id);
    int deleteByMagasinDestId(Long id);
    long countByMagasinDestId(Long id);

    @Query("SELECT NEW OperationStock(item.id,item.ref) FROM OperationStock item")
    List<OperationStock> findAllOptimized();

}
