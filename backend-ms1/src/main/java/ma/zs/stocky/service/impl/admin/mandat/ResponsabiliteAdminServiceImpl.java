package ma.zs.stocky.service.impl.admin.mandat;


import ma.zs.stocky.bean.core.mandat.Responsabilite;
import ma.zs.stocky.dao.criteria.core.mandat.ResponsabiliteCriteria;
import ma.zs.stocky.dao.facade.core.mandat.ResponsabiliteDao;
import ma.zs.stocky.dao.specification.core.mandat.ResponsabiliteSpecification;
import ma.zs.stocky.service.facade.admin.mandat.ResponsabiliteAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ResponsabiliteAdminServiceImpl extends AbstractServiceImpl<Responsabilite, ResponsabiliteCriteria, ResponsabiliteDao> implements ResponsabiliteAdminService {








    public List<Responsabilite> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Responsabilite.class, ResponsabiliteSpecification.class);
    }



    public ResponsabiliteAdminServiceImpl(ResponsabiliteDao dao) {
        super(dao);
    }

}
