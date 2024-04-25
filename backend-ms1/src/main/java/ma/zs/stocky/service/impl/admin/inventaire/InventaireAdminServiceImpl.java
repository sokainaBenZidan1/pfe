package ma.zs.stocky.service.impl.admin.inventaire;


import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.dao.criteria.core.inventaire.InventaireCriteria;
import ma.zs.stocky.dao.facade.core.inventaire.InventaireDao;
import ma.zs.stocky.dao.specification.core.inventaire.InventaireSpecification;
import ma.zs.stocky.service.facade.admin.inventaire.InventaireAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.inventaire.ResponsableInventaireAdminService ;
import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire ;
import ma.zs.stocky.service.facade.admin.inventaire.InventaireDetailAdminService ;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail ;
import ma.zs.stocky.service.facade.admin.inventaire.InventaireAdminService ;
import ma.zs.stocky.bean.core.inventaire.Inventaire ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class InventaireAdminServiceImpl extends AbstractServiceImpl<Inventaire, InventaireCriteria, InventaireDao> implements InventaireAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Inventaire create(Inventaire t) {
        Inventaire saved= super.create(t);
        if (saved != null && t.getInventaireDetails() != null) {
                t.getInventaireDetails().forEach(element-> {
                element.setInventaire(saved);
                inventaireDetailService.create(element);
            });
        }
        return saved;

    }

    public Inventaire findWithAssociatedLists(Long id){
        Inventaire result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setInventaireDetails(inventaireDetailService.findByInventaireId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        inventaireDetailService.deleteByInventaireId(id);
    }


    public void updateWithAssociatedLists(Inventaire inventaire){
    if(inventaire !=null && inventaire.getId() != null){
            List<List<InventaireDetail>> resultInventaireDetails= inventaireDetailService.getToBeSavedAndToBeDeleted(inventaireDetailService.findByInventaireId(inventaire.getId()),inventaire.getInventaireDetails());
            inventaireDetailService.delete(resultInventaireDetails.get(1));
            ListUtil.emptyIfNull(resultInventaireDetails.get(0)).forEach(e -> e.setInventaire(inventaire));
            inventaireDetailService.update(resultInventaireDetails.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(Inventaire t){
        if( t != null) {
            t.setResponsableInv(responsableInventaireService.findOrSave(t.getResponsableInv()));
        }
    }

    public List<Inventaire> findByResponsableInvId(Long id){
        return dao.findByResponsableInvId(id);
    }
    public int deleteByResponsableInvId(Long id){
        return dao.deleteByResponsableInvId(id);
    }
    public long countByResponsableInvId(Long id){
        return dao.countByResponsableInvId(id);
    }






    public void configure() {
        super.configure(Inventaire.class, InventaireSpecification.class);
    }


    @Autowired
    private ResponsableInventaireAdminService responsableInventaireService ;
    @Autowired
    private InventaireDetailAdminService inventaireDetailService ;
    @Autowired
    private InventaireAdminService inventaireService ;
    @Autowired
    private ProduitAdminService produitService ;

    public InventaireAdminServiceImpl(InventaireDao dao) {
        super(dao);
    }

}
