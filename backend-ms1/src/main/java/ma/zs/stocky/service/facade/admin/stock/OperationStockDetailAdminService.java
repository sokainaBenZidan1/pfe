package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.dao.criteria.core.stock.OperationStockDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface OperationStockDetailAdminService extends  IService<OperationStockDetail,OperationStockDetailCriteria>  {

    List<OperationStockDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<OperationStockDetail> findByOperationStockId(Long id);
    int deleteByOperationStockId(Long id);
    long countByOperationStockRef(String ref);




}
