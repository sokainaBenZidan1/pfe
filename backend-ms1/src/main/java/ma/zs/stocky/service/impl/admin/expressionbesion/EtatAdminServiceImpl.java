package ma.zs.stocky.service.impl.admin.expressionbesion;


import ma.zs.stocky.bean.core.expressionbesion.Etat;
import ma.zs.stocky.dao.criteria.core.expressionbesion.EtatCriteria;
import ma.zs.stocky.dao.facade.core.expressionbesion.EtatDao;
import ma.zs.stocky.dao.specification.core.expressionbesion.EtatSpecification;
import ma.zs.stocky.service.facade.admin.expressionbesion.EtatAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAdminServiceImpl extends AbstractServiceImpl<Etat, EtatCriteria, EtatDao> implements EtatAdminService {






    public Etat findByReferenceEntity(Etat t){
        return  dao.findByCode(t.getCode());
    }


    public List<Etat> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Etat.class, EtatSpecification.class);
    }



    public EtatAdminServiceImpl(EtatDao dao) {
        super(dao);
    }

}
