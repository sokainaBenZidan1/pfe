package ma.zs.stocky.service.impl.admin.commande;


import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.dao.criteria.core.commande.CommandeCriteria;
import ma.zs.stocky.dao.facade.core.commande.CommandeDao;
import ma.zs.stocky.dao.specification.core.commande.CommandeSpecification;
import ma.zs.stocky.service.facade.admin.commande.CommandeAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.commun.EntiteAdminAdminService ;
import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.service.facade.admin.commande.CommandeAdminService ;
import ma.zs.stocky.bean.core.commande.Commande ;
import ma.zs.stocky.service.facade.admin.commande.CommandeDetailAdminService ;
import ma.zs.stocky.bean.core.commande.CommandeDetail ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class CommandeAdminServiceImpl extends AbstractServiceImpl<Commande, CommandeCriteria, CommandeDao> implements CommandeAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Commande create(Commande t) {
        Commande saved= super.create(t);
        if (saved != null && t.getCommandeDetails() != null) {
                t.getCommandeDetails().forEach(element-> {
                element.setCommande(saved);
                commandeDetailService.create(element);
            });
        }
        return saved;

    }

    public Commande findWithAssociatedLists(Long id){
        Commande result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCommandeDetails(commandeDetailService.findByCommandeId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        commandeDetailService.deleteByCommandeId(id);
    }


    public void updateWithAssociatedLists(Commande commande){
    if(commande !=null && commande.getId() != null){
            List<List<CommandeDetail>> resultCommandeDetails= commandeDetailService.getToBeSavedAndToBeDeleted(commandeDetailService.findByCommandeId(commande.getId()),commande.getCommandeDetails());
            commandeDetailService.delete(resultCommandeDetails.get(1));
            ListUtil.emptyIfNull(resultCommandeDetails.get(0)).forEach(e -> e.setCommande(commande));
            commandeDetailService.update(resultCommandeDetails.get(0),true);
        }
    }




    public Commande findByReferenceEntity(Commande t){
        return  dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Commande t){
        if( t != null) {
            t.setEntiteAdmin(entiteAdminService.findOrSave(t.getEntiteAdmin()));
        }
    }

    public List<Commande> findByEntiteAdminId(Long id){
        return dao.findByEntiteAdminId(id);
    }
    public int deleteByEntiteAdminId(Long id){
        return dao.deleteByEntiteAdminId(id);
    }
    public long countByEntiteAdminCode(String code){
        return dao.countByEntiteAdminCode(code);
    }

    public List<Commande> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Commande.class, CommandeSpecification.class);
    }


    @Autowired
    private EntiteAdminAdminService entiteAdminService ;
    @Autowired
    private CommandeAdminService commandeService ;
    @Autowired
    private CommandeDetailAdminService commandeDetailService ;
    @Autowired
    private ProduitAdminService produitService ;

    public CommandeAdminServiceImpl(CommandeDao dao) {
        super(dao);
    }

}
