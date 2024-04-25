package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.dao.criteria.core.stock.MagasinCriteria;
import ma.zs.stocky.dao.facade.core.stock.MagasinDao;
import ma.zs.stocky.dao.specification.core.stock.MagasinSpecification;
import ma.zs.stocky.service.facade.admin.stock.MagasinAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class MagasinAdminServiceImpl extends AbstractServiceImpl<Magasin, MagasinCriteria, MagasinDao> implements MagasinAdminService {













    public void configure() {
        super.configure(Magasin.class, MagasinSpecification.class);
    }



    public MagasinAdminServiceImpl(MagasinDao dao) {
        super(dao);
    }

}
