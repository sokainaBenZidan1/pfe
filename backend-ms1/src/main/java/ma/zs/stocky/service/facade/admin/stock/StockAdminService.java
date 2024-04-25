package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.Stock;
import ma.zs.stocky.dao.criteria.core.stock.StockCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface StockAdminService extends  IService<Stock,StockCriteria>  {

    List<Stock> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    long countByMagasinId(Long id);
    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);




}
