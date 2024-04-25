package ma.zs.stocky.service.impl.admin.inventaire;


import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.dao.criteria.core.inventaire.InventaireDetailCriteria;
import ma.zs.stocky.dao.facade.core.inventaire.InventaireDetailDao;
import ma.zs.stocky.dao.specification.core.inventaire.InventaireDetailSpecification;
import ma.zs.stocky.service.facade.admin.inventaire.InventaireDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.inventaire.InventaireAdminService ;
import ma.zs.stocky.bean.core.inventaire.Inventaire ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class InventaireDetailAdminServiceImpl extends AbstractServiceImpl<InventaireDetail, InventaireDetailCriteria, InventaireDetailDao> implements InventaireDetailAdminService {






    public void findOrSaveAssociatedObject(InventaireDetail t){
        if( t != null) {
            t.setProduit(produitService.findOrSave(t.getProduit()));
            t.setInventaire(inventaireService.findOrSave(t.getInventaire()));
        }
    }

    public List<InventaireDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }
    public List<InventaireDetail> findByInventaireId(Long id){
        return dao.findByInventaireId(id);
    }
    public int deleteByInventaireId(Long id){
        return dao.deleteByInventaireId(id);
    }
    public long countByInventaireId(Long id){
        return dao.countByInventaireId(id);
    }






    public void configure() {
        super.configure(InventaireDetail.class, InventaireDetailSpecification.class);
    }


    @Autowired
    private InventaireAdminService inventaireService ;
    @Autowired
    private ProduitAdminService produitService ;

    public InventaireDetailAdminServiceImpl(InventaireDetailDao dao) {
        super(dao);
    }

}
