package ma.zs.stocky.dao.facade.core.mandat;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.mandat.Mandat;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MandatDao extends AbstractRepository<Mandat,Long>  {

    List<Mandat> findByEmployeId(Long id);
    int deleteByEmployeId(Long id);
    long countByEmployeNom(String nom);
    List<Mandat> findByResponsabiliteId(Long id);
    int deleteByResponsabiliteId(Long id);
    long countByResponsabiliteId(Long id);
    List<Mandat> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);


}
