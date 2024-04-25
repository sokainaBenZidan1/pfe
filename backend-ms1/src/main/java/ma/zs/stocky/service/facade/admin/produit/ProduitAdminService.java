package ma.zs.stocky.service.facade.admin.produit;

import java.util.List;
import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ProduitAdminService extends  IService<Produit,ProduitCriteria>  {

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    long countByCategorieProduitId(Long id);




}
