package ma.zs.stocky.service.facade.admin.reception;

import java.util.List;
import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.dao.criteria.core.reception.ReceptionDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ReceptionDetailAdminService extends  IService<ReceptionDetail,ReceptionDetailCriteria>  {

    List<ReceptionDetail> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    long countByMagasinId(Long id);
    List<ReceptionDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);
    List<ReceptionDetail> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);
    long countByReceptionRef(String ref);




}
