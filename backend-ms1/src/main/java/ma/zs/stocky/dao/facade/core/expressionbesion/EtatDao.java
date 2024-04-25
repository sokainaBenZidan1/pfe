package ma.zs.stocky.dao.facade.core.expressionbesion;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.expressionbesion.Etat;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.expressionbesion.Etat;
import java.util.List;


@Repository
public interface EtatDao extends AbstractRepository<Etat,Long>  {
    Etat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Etat(item.id,item.libelle) FROM Etat item")
    List<Etat> findAllOptimized();

}
