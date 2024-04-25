package ma.zs.stocky.service.impl.admin.commande;


import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.dao.criteria.core.commande.CommandeDetailCriteria;
import ma.zs.stocky.dao.facade.core.commande.CommandeDetailDao;
import ma.zs.stocky.dao.specification.core.commande.CommandeDetailSpecification;
import ma.zs.stocky.service.facade.admin.commande.CommandeDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commande.CommandeAdminService ;
import ma.zs.stocky.bean.core.commande.Commande ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class CommandeDetailAdminServiceImpl extends AbstractServiceImpl<CommandeDetail, CommandeDetailCriteria, CommandeDetailDao> implements CommandeDetailAdminService {






    public void findOrSaveAssociatedObject(CommandeDetail t){
        if( t != null) {
            t.setCommande(commandeService.findOrSave(t.getCommande()));
            t.setProduit(produitService.findOrSave(t.getProduit()));
        }
    }

    public List<CommandeDetail> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public long countByCommandeRef(String ref){
        return dao.countByCommandeRef(ref);
    }
    public List<CommandeDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }






    public void configure() {
        super.configure(CommandeDetail.class, CommandeDetailSpecification.class);
    }


    @Autowired
    private CommandeAdminService commandeService ;
    @Autowired
    private ProduitAdminService produitService ;

    public CommandeDetailAdminServiceImpl(CommandeDetailDao dao) {
        super(dao);
    }

}
