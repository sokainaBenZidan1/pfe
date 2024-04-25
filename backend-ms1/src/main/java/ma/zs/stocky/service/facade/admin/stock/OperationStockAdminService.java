package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.dao.criteria.core.stock.OperationStockCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface OperationStockAdminService extends  IService<OperationStock,OperationStockCriteria>  {

    List<OperationStock> findByMagasinSourceId(Long id);
    int deleteByMagasinSourceId(Long id);
    long countByMagasinSourceId(Long id);
    List<OperationStock> findByMagasinDestId(Long id);
    int deleteByMagasinDestId(Long id);
    long countByMagasinDestId(Long id);




}
