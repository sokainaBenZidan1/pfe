package ma.zs.stocky.service.impl.admin.inventaire;


import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.dao.criteria.core.inventaire.ResponsableInventaireCriteria;
import ma.zs.stocky.dao.facade.core.inventaire.ResponsableInventaireDao;
import ma.zs.stocky.dao.specification.core.inventaire.ResponsableInventaireSpecification;
import ma.zs.stocky.service.facade.admin.inventaire.ResponsableInventaireAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ResponsableInventaireAdminServiceImpl extends AbstractServiceImpl<ResponsableInventaire, ResponsableInventaireCriteria, ResponsableInventaireDao> implements ResponsableInventaireAdminService {













    public void configure() {
        super.configure(ResponsableInventaire.class, ResponsableInventaireSpecification.class);
    }



    public ResponsableInventaireAdminServiceImpl(ResponsableInventaireDao dao) {
        super(dao);
    }

}
