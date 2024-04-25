package ma.zs.stocky.dao.facade.core.inventaire;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ResponsableInventaireDao extends AbstractRepository<ResponsableInventaire,Long>  {



}
