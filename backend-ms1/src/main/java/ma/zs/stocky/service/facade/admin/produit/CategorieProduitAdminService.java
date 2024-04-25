package ma.zs.stocky.service.facade.admin.produit;

import java.util.List;
import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.dao.criteria.core.produit.CategorieProduitCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface CategorieProduitAdminService extends  IService<CategorieProduit,CategorieProduitCriteria>  {

    List<CategorieProduit> findByCompteBudgetaireId(Long id);
    int deleteByCompteBudgetaireId(Long id);
    long countByCompteBudgetaireId(Long id);




}
