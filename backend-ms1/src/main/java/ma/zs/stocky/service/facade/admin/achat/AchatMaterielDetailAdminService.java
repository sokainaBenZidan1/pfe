package ma.zs.stocky.service.facade.admin.achat;

import java.util.List;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AchatMaterielDetailAdminService extends  IService<AchatMaterielDetail,AchatMaterielDetailCriteria>  {

    List<AchatMaterielDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<AchatMaterielDetail> findByAchatMaterielId(Long id);
    int deleteByAchatMaterielId(Long id);
    long countByAchatMaterielId(Long id);




}
