package ma.zs.stocky.service.facade.admin.inventaire;

import java.util.List;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.dao.criteria.core.inventaire.InventaireDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface InventaireDetailAdminService extends  IService<InventaireDetail,InventaireDetailCriteria>  {

    List<InventaireDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<InventaireDetail> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);
    long countByInventaireId(Long id);




}
