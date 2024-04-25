package ma.zs.stocky.service.impl.admin.produit;


import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.dao.criteria.core.produit.CategorieProduitCriteria;
import ma.zs.stocky.dao.facade.core.produit.CategorieProduitDao;
import ma.zs.stocky.dao.specification.core.produit.CategorieProduitSpecification;
import ma.zs.stocky.service.facade.admin.produit.CategorieProduitAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.budget.CompteBudgetaireAdminService ;
import ma.zs.stocky.bean.core.budget.CompteBudgetaire ;

import java.util.List;
@Service
public class CategorieProduitAdminServiceImpl extends AbstractServiceImpl<CategorieProduit, CategorieProduitCriteria, CategorieProduitDao> implements CategorieProduitAdminService {






    public void findOrSaveAssociatedObject(CategorieProduit t){
        if( t != null) {
            t.setCompteBudgetaire(compteBudgetaireService.findOrSave(t.getCompteBudgetaire()));
        }
    }

    public List<CategorieProduit> findByCompteBudgetaireId(Long id){
        return dao.findByCompteBudgetaireId(id);
    }
    public int deleteByCompteBudgetaireId(Long id){
        return dao.deleteByCompteBudgetaireId(id);
    }
    public long countByCompteBudgetaireId(Long id){
        return dao.countByCompteBudgetaireId(id);
    }

    public List<CategorieProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieProduit.class, CategorieProduitSpecification.class);
    }


    @Autowired
    private CompteBudgetaireAdminService compteBudgetaireService ;

    public CategorieProduitAdminServiceImpl(CategorieProduitDao dao) {
        super(dao);
    }

}
