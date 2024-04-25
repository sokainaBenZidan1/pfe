package ma.zs.stocky.service.impl.admin.achat;


import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielCriteria;
import ma.zs.stocky.dao.facade.core.achat.AchatMaterielDao;
import ma.zs.stocky.dao.specification.core.achat.AchatMaterielSpecification;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.achat.TypeAchatMaterielAdminService ;
import ma.zs.stocky.bean.core.achat.TypeAchatMateriel ;
import ma.zs.stocky.service.facade.admin.budget.BudgetAdminService ;
import ma.zs.stocky.bean.core.budget.Budget ;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielDetailAdminService ;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielAdminService ;
import ma.zs.stocky.bean.core.achat.AchatMateriel ;

import java.util.List;
@Service
public class AchatMaterielAdminServiceImpl extends AbstractServiceImpl<AchatMateriel, AchatMaterielCriteria, AchatMaterielDao> implements AchatMaterielAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AchatMateriel create(AchatMateriel t) {
        AchatMateriel saved= super.create(t);
        if (saved != null && t.getAchatMaterielDetails() != null) {
                t.getAchatMaterielDetails().forEach(element-> {
                element.setAchatMateriel(saved);
                achatMaterielDetailService.create(element);
            });
        }
        return saved;

    }

    public AchatMateriel findWithAssociatedLists(Long id){
        AchatMateriel result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAchatMaterielDetails(achatMaterielDetailService.findByAchatMaterielId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        achatMaterielDetailService.deleteByAchatMaterielId(id);
    }


    public void updateWithAssociatedLists(AchatMateriel achatMateriel){
    if(achatMateriel !=null && achatMateriel.getId() != null){
            List<List<AchatMaterielDetail>> resultAchatMaterielDetails= achatMaterielDetailService.getToBeSavedAndToBeDeleted(achatMaterielDetailService.findByAchatMaterielId(achatMateriel.getId()),achatMateriel.getAchatMaterielDetails());
            achatMaterielDetailService.delete(resultAchatMaterielDetails.get(1));
            ListUtil.emptyIfNull(resultAchatMaterielDetails.get(0)).forEach(e -> e.setAchatMateriel(achatMateriel));
            achatMaterielDetailService.update(resultAchatMaterielDetails.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(AchatMateriel t){
        if( t != null) {
            t.setBudget(budgetService.findOrSave(t.getBudget()));
            t.setTypeAchatMateriel(typeAchatMaterielService.findOrSave(t.getTypeAchatMateriel()));
        }
    }

    public List<AchatMateriel> findByBudgetId(Long id){
        return dao.findByBudgetId(id);
    }
    public int deleteByBudgetId(Long id){
        return dao.deleteByBudgetId(id);
    }
    public long countByBudgetId(Long id){
        return dao.countByBudgetId(id);
    }
    public List<AchatMateriel> findByTypeAchatMaterielId(Long id){
        return dao.findByTypeAchatMaterielId(id);
    }
    public int deleteByTypeAchatMaterielId(Long id){
        return dao.deleteByTypeAchatMaterielId(id);
    }
    public long countByTypeAchatMaterielId(Long id){
        return dao.countByTypeAchatMaterielId(id);
    }






    public void configure() {
        super.configure(AchatMateriel.class, AchatMaterielSpecification.class);
    }


    @Autowired
    private TypeAchatMaterielAdminService typeAchatMaterielService ;
    @Autowired
    private BudgetAdminService budgetService ;
    @Autowired
    private AchatMaterielDetailAdminService achatMaterielDetailService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AchatMaterielAdminService achatMaterielService ;

    public AchatMaterielAdminServiceImpl(AchatMaterielDao dao) {
        super(dao);
    }

}
