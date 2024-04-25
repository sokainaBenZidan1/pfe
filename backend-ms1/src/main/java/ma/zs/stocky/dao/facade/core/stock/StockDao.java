package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.Stock;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StockDao extends AbstractRepository<Stock,Long>  {

    List<Stock> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    long countByMagasinId(Long id);
    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);


}
