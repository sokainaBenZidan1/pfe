package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.dao.criteria.core.stock.OperationStockDetailCriteria;
import ma.zs.stocky.dao.facade.core.stock.OperationStockDetailDao;
import ma.zs.stocky.dao.specification.core.stock.OperationStockDetailSpecification;
import ma.zs.stocky.service.facade.admin.stock.OperationStockDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.stock.OperationStockAdminService ;
import ma.zs.stocky.bean.core.stock.OperationStock ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class OperationStockDetailAdminServiceImpl extends AbstractServiceImpl<OperationStockDetail, OperationStockDetailCriteria, OperationStockDetailDao> implements OperationStockDetailAdminService {






    public void findOrSaveAssociatedObject(OperationStockDetail t){
        if( t != null) {
            t.setProduit(produitService.findOrSave(t.getProduit()));
            t.setOperationStock(operationStockService.findOrSave(t.getOperationStock()));
        }
    }

    public List<OperationStockDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }
    public List<OperationStockDetail> findByOperationStockId(Long id){
        return dao.findByOperationStockId(id);
    }
    public int deleteByOperationStockId(Long id){
        return dao.deleteByOperationStockId(id);
    }
    public long countByOperationStockRef(String ref){
        return dao.countByOperationStockRef(ref);
    }






    public void configure() {
        super.configure(OperationStockDetail.class, OperationStockDetailSpecification.class);
    }


    @Autowired
    private OperationStockAdminService operationStockService ;
    @Autowired
    private ProduitAdminService produitService ;

    public OperationStockDetailAdminServiceImpl(OperationStockDetailDao dao) {
        super(dao);
    }

}
