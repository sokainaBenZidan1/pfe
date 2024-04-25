package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.dao.criteria.core.stock.OperationStockCriteria;
import ma.zs.stocky.dao.facade.core.stock.OperationStockDao;
import ma.zs.stocky.dao.specification.core.stock.OperationStockSpecification;
import ma.zs.stocky.service.facade.admin.stock.OperationStockAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.stock.MagasinAdminService ;
import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.service.facade.admin.stock.OperationStockAdminService ;
import ma.zs.stocky.bean.core.stock.OperationStock ;
import ma.zs.stocky.service.facade.admin.stock.OperationStockDetailAdminService ;
import ma.zs.stocky.bean.core.stock.OperationStockDetail ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class OperationStockAdminServiceImpl extends AbstractServiceImpl<OperationStock, OperationStockCriteria, OperationStockDao> implements OperationStockAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public OperationStock create(OperationStock t) {
        OperationStock saved= super.create(t);
        if (saved != null && t.getOperationStockDetails() != null) {
                t.getOperationStockDetails().forEach(element-> {
                element.setOperationStock(saved);
                operationStockDetailService.create(element);
            });
        }
        return saved;

    }

    public OperationStock findWithAssociatedLists(Long id){
        OperationStock result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setOperationStockDetails(operationStockDetailService.findByOperationStockId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        operationStockDetailService.deleteByOperationStockId(id);
    }


    public void updateWithAssociatedLists(OperationStock operationStock){
    if(operationStock !=null && operationStock.getId() != null){
            List<List<OperationStockDetail>> resultOperationStockDetails= operationStockDetailService.getToBeSavedAndToBeDeleted(operationStockDetailService.findByOperationStockId(operationStock.getId()),operationStock.getOperationStockDetails());
            operationStockDetailService.delete(resultOperationStockDetails.get(1));
            ListUtil.emptyIfNull(resultOperationStockDetails.get(0)).forEach(e -> e.setOperationStock(operationStock));
            operationStockDetailService.update(resultOperationStockDetails.get(0),true);
        }
    }




    public OperationStock findByReferenceEntity(OperationStock t){
        return  dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(OperationStock t){
        if( t != null) {
            t.setMagasinSource(magasinService.findOrSave(t.getMagasinSource()));
            t.setMagasinDest(magasinService.findOrSave(t.getMagasinDest()));
        }
    }

    public List<OperationStock> findByMagasinSourceId(Long id){
        return dao.findByMagasinSourceId(id);
    }
    public int deleteByMagasinSourceId(Long id){
        return dao.deleteByMagasinSourceId(id);
    }
    public long countByMagasinSourceId(Long id){
        return dao.countByMagasinSourceId(id);
    }
    public List<OperationStock> findByMagasinDestId(Long id){
        return dao.findByMagasinDestId(id);
    }
    public int deleteByMagasinDestId(Long id){
        return dao.deleteByMagasinDestId(id);
    }
    public long countByMagasinDestId(Long id){
        return dao.countByMagasinDestId(id);
    }

    public List<OperationStock> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(OperationStock.class, OperationStockSpecification.class);
    }


    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private OperationStockAdminService operationStockService ;
    @Autowired
    private OperationStockDetailAdminService operationStockDetailService ;
    @Autowired
    private ProduitAdminService produitService ;

    public OperationStockAdminServiceImpl(OperationStockDao dao) {
        super(dao);
    }

}
