package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.Stock;
import ma.zs.stocky.dao.criteria.core.stock.StockCriteria;
import ma.zs.stocky.dao.facade.core.stock.StockDao;
import ma.zs.stocky.dao.specification.core.stock.StockSpecification;
import ma.zs.stocky.service.facade.admin.stock.StockAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.stock.MagasinAdminService ;
import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class StockAdminServiceImpl extends AbstractServiceImpl<Stock, StockCriteria, StockDao> implements StockAdminService {






    public void findOrSaveAssociatedObject(Stock t){
        if( t != null) {
            t.setMagasin(magasinService.findOrSave(t.getMagasin()));
            t.setProduit(produitService.findOrSave(t.getProduit()));
        }
    }

    public List<Stock> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public long countByMagasinId(Long id){
        return dao.countByMagasinId(id);
    }
    public List<Stock> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }






    public void configure() {
        super.configure(Stock.class, StockSpecification.class);
    }


    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private ProduitAdminService produitService ;

    public StockAdminServiceImpl(StockDao dao) {
        super(dao);
    }

}
