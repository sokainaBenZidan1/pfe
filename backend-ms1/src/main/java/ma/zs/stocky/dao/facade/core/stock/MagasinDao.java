package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.Magasin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MagasinDao extends AbstractRepository<Magasin,Long>  {



}
