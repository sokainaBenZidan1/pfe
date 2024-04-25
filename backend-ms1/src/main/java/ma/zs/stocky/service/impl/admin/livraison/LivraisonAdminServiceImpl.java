package ma.zs.stocky.service.impl.admin.livraison;


import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.dao.criteria.core.livraison.LivraisonCriteria;
import ma.zs.stocky.dao.facade.core.livraison.LivraisonDao;
import ma.zs.stocky.dao.specification.core.livraison.LivraisonSpecification;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonAdminService;
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
import ma.zs.stocky.service.facade.admin.reception.ReceptionAdminService ;
import ma.zs.stocky.bean.core.reception.Reception ;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonAdminService ;
import ma.zs.stocky.bean.core.livraison.Livraison ;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonDetailAdminService ;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class LivraisonAdminServiceImpl extends AbstractServiceImpl<Livraison, LivraisonCriteria, LivraisonDao> implements LivraisonAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Livraison create(Livraison t) {
        Livraison saved= super.create(t);
        if (saved != null && t.getLivraisonDetails() != null) {
                t.getLivraisonDetails().forEach(element-> {
                element.setLivraison(saved);
                livraisonDetailService.create(element);
            });
        }
        return saved;

    }

    public Livraison findWithAssociatedLists(Long id){
        Livraison result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setLivraisonDetails(livraisonDetailService.findByLivraisonId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        livraisonDetailService.deleteByLivraisonId(id);
    }


    public void updateWithAssociatedLists(Livraison livraison){
    if(livraison !=null && livraison.getId() != null){
            List<List<LivraisonDetail>> resultLivraisonDetails= livraisonDetailService.getToBeSavedAndToBeDeleted(livraisonDetailService.findByLivraisonId(livraison.getId()),livraison.getLivraisonDetails());
            livraisonDetailService.delete(resultLivraisonDetails.get(1));
            ListUtil.emptyIfNull(resultLivraisonDetails.get(0)).forEach(e -> e.setLivraison(livraison));
            livraisonDetailService.update(resultLivraisonDetails.get(0),true);
        }
    }




    public Livraison findByReferenceEntity(Livraison t){
        return  dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Livraison t){
        if( t != null) {
            t.setReception(receptionService.findOrSave(t.getReception()));
        }
    }

    public List<Livraison> findByReceptionId(Long id){
        return dao.findByReceptionId(id);
    }
    public int deleteByReceptionId(Long id){
        return dao.deleteByReceptionId(id);
    }
    public long countByReceptionRef(String ref){
        return dao.countByReceptionRef(ref);
    }

    public List<Livraison> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Livraison.class, LivraisonSpecification.class);
    }


    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private ReceptionAdminService receptionService ;
    @Autowired
    private LivraisonAdminService livraisonService ;
    @Autowired
    private LivraisonDetailAdminService livraisonDetailService ;
    @Autowired
    private ProduitAdminService produitService ;

    public LivraisonAdminServiceImpl(LivraisonDao dao) {
        super(dao);
    }

}
