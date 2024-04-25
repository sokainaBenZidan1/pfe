package ma.zs.stocky.dao.facade.core.achat;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TypeAchatMaterielDao extends AbstractRepository<TypeAchatMateriel,Long>  {


    @Query("SELECT NEW TypeAchatMateriel(item.id,item.libelle) FROM TypeAchatMateriel item")
    List<TypeAchatMateriel> findAllOptimized();

}
