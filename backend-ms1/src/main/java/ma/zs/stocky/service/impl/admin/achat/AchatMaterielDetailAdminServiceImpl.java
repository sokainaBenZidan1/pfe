package ma.zs.stocky.service.impl.admin.achat;


import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielDetailCriteria;
import ma.zs.stocky.dao.facade.core.achat.AchatMaterielDetailDao;
import ma.zs.stocky.dao.specification.core.achat.AchatMaterielDetailSpecification;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielAdminService ;
import ma.zs.stocky.bean.core.achat.AchatMateriel ;

import java.util.List;
@Service
public class AchatMaterielDetailAdminServiceImpl extends AbstractServiceImpl<AchatMaterielDetail, AchatMaterielDetailCriteria, AchatMaterielDetailDao> implements AchatMaterielDetailAdminService {






    public void findOrSaveAssociatedObject(AchatMaterielDetail t){
        if( t != null) {
            t.setProduit(produitService.findOrSave(t.getProduit()));
            t.setAchatMateriel(achatMaterielService.findOrSave(t.getAchatMateriel()));
        }
    }

    public List<AchatMaterielDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }
    public List<AchatMaterielDetail> findByAchatMaterielId(Long id){
        return dao.findByAchatMaterielId(id);
    }
    public int deleteByAchatMaterielId(Long id){
        return dao.deleteByAchatMaterielId(id);
    }
    public long countByAchatMaterielId(Long id){
        return dao.countByAchatMaterielId(id);
    }






    public void configure() {
        super.configure(AchatMaterielDetail.class, AchatMaterielDetailSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AchatMaterielAdminService achatMaterielService ;

    public AchatMaterielDetailAdminServiceImpl(AchatMaterielDetailDao dao) {
        super(dao);
    }

}
