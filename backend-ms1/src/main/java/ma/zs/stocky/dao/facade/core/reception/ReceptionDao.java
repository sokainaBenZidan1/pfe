package ma.zs.stocky.dao.facade.core.reception;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.reception.Reception;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.reception.Reception;
import java.util.List;


@Repository
public interface ReceptionDao extends AbstractRepository<Reception,Long>  {
    Reception findByRef(String ref);
    int deleteByRef(String ref);

    List<Reception> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeRef(String ref);

    @Query("SELECT NEW Reception(item.id,item.ref) FROM Reception item")
    List<Reception> findAllOptimized();

}
