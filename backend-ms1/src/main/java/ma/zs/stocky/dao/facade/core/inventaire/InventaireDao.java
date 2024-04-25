package ma.zs.stocky.dao.facade.core.inventaire;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.inventaire.Inventaire;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InventaireDao extends AbstractRepository<Inventaire,Long>  {

    List<Inventaire> findByResponsableInvId(Long id);
    int deleteByResponsableInvId(Long id);
    long countByResponsableInvId(Long id);


}
