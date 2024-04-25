package ma.zs.stocky.service.impl.admin.reception;


import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.dao.criteria.core.reception.ReceptionCriteria;
import ma.zs.stocky.dao.facade.core.reception.ReceptionDao;
import ma.zs.stocky.dao.specification.core.reception.ReceptionSpecification;
import ma.zs.stocky.service.facade.admin.reception.ReceptionAdminService;
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
import ma.zs.stocky.service.facade.admin.commande.CommandeAdminService ;
import ma.zs.stocky.bean.core.commande.Commande ;
import ma.zs.stocky.service.facade.admin.reception.ReceptionAdminService ;
import ma.zs.stocky.bean.core.reception.Reception ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;
import ma.zs.stocky.service.facade.admin.reception.ReceptionDetailAdminService ;
import ma.zs.stocky.bean.core.reception.ReceptionDetail ;

import java.util.List;
@Service
public class ReceptionAdminServiceImpl extends AbstractServiceImpl<Reception, ReceptionCriteria, ReceptionDao> implements ReceptionAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Reception create(Reception t) {
        Reception saved= super.create(t);
        if (saved != null && t.getReceptionDetails() != null) {
                t.getReceptionDetails().forEach(element-> {
                element.setReception(saved);
                receptionDetailService.create(element);
            });
        }
        return saved;

    }

    public Reception findWithAssociatedLists(Long id){
        Reception result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReceptionDetails(receptionDetailService.findByReceptionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        receptionDetailService.deleteByReceptionId(id);
    }


    public void updateWithAssociatedLists(Reception reception){
    if(reception !=null && reception.getId() != null){
            List<List<ReceptionDetail>> resultReceptionDetails= receptionDetailService.getToBeSavedAndToBeDeleted(receptionDetailService.findByReceptionId(reception.getId()),reception.getReceptionDetails());
            receptionDetailService.delete(resultReceptionDetails.get(1));
            ListUtil.emptyIfNull(resultReceptionDetails.get(0)).forEach(e -> e.setReception(reception));
            receptionDetailService.update(resultReceptionDetails.get(0),true);
        }
    }




    public Reception findByReferenceEntity(Reception t){
        return  dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Reception t){
        if( t != null) {
            t.setCommande(commandeService.findOrSave(t.getCommande()));
        }
    }

    public List<Reception> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public long countByCommandeRef(String ref){
        return dao.countByCommandeRef(ref);
    }

    public List<Reception> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Reception.class, ReceptionSpecification.class);
    }


    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private CommandeAdminService commandeService ;
    @Autowired
    private ReceptionAdminService receptionService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private ReceptionDetailAdminService receptionDetailService ;

    public ReceptionAdminServiceImpl(ReceptionDao dao) {
        super(dao);
    }

}
