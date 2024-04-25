package ma.zs.stocky.dao.facade.core.mandat;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.mandat.Responsabilite;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ResponsabiliteDao extends AbstractRepository<Responsabilite,Long>  {


    @Query("SELECT NEW Responsabilite(item.id,item.libelle) FROM Responsabilite item")
    List<Responsabilite> findAllOptimized();

}
