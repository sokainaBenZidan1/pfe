package ma.zs.stocky.service.impl.admin.produit;


import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;
import ma.zs.stocky.dao.facade.core.produit.ProduitDao;
import ma.zs.stocky.dao.specification.core.produit.ProduitSpecification;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.produit.CategorieProduitAdminService ;
import ma.zs.stocky.bean.core.produit.CategorieProduit ;

import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit, ProduitCriteria, ProduitDao> implements ProduitAdminService {






    public Produit findByReferenceEntity(Produit t){
        return  dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Produit t){
        if( t != null) {
            t.setCategorieProduit(categorieProduitService.findOrSave(t.getCategorieProduit()));
        }
    }

    public List<Produit> findByCategorieProduitId(Long id){
        return dao.findByCategorieProduitId(id);
    }
    public int deleteByCategorieProduitId(Long id){
        return dao.deleteByCategorieProduitId(id);
    }
    public long countByCategorieProduitId(Long id){
        return dao.countByCategorieProduitId(id);
    }

    public List<Produit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Produit.class, ProduitSpecification.class);
    }


    @Autowired
    private CategorieProduitAdminService categorieProduitService ;

    public ProduitAdminServiceImpl(ProduitDao dao) {
        super(dao);
    }

}
