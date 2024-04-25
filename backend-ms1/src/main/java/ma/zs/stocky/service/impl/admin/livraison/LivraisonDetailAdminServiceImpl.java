package ma.zs.stocky.service.impl.admin.livraison;


import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.dao.criteria.core.livraison.LivraisonDetailCriteria;
import ma.zs.stocky.dao.facade.core.livraison.LivraisonDetailDao;
import ma.zs.stocky.dao.specification.core.livraison.LivraisonDetailSpecification;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.stock.MagasinAdminService ;
import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonAdminService ;
import ma.zs.stocky.bean.core.livraison.Livraison ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class LivraisonDetailAdminServiceImpl extends AbstractServiceImpl<LivraisonDetail, LivraisonDetailCriteria, LivraisonDetailDao> implements LivraisonDetailAdminService {






    public void findOrSaveAssociatedObject(LivraisonDetail t){
        if( t != null) {
            t.setMagasin(magasinService.findOrSave(t.getMagasin()));
            t.setProduit(produitService.findOrSave(t.getProduit()));
            t.setLivraison(livraisonService.findOrSave(t.getLivraison()));
        }
    }

    public List<LivraisonDetail> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public long countByMagasinId(Long id){
        return dao.countByMagasinId(id);
    }
    public List<LivraisonDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }
    public List<LivraisonDetail> findByLivraisonId(Long id){
        return dao.findByLivraisonId(id);
    }
    public int deleteByLivraisonId(Long id){
        return dao.deleteByLivraisonId(id);
    }
    public long countByLivraisonRef(String ref){
        return dao.countByLivraisonRef(ref);
    }






    public void configure() {
        super.configure(LivraisonDetail.class, LivraisonDetailSpecification.class);
    }


    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private LivraisonAdminService livraisonService ;
    @Autowired
    private ProduitAdminService produitService ;

    public LivraisonDetailAdminServiceImpl(LivraisonDetailDao dao) {
        super(dao);
    }

}
