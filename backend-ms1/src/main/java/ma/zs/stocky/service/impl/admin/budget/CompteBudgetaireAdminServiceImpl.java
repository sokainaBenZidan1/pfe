package ma.zs.stocky.service.impl.admin.budget;


import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.dao.criteria.core.budget.CompteBudgetaireCriteria;
import ma.zs.stocky.dao.facade.core.budget.CompteBudgetaireDao;
import ma.zs.stocky.dao.specification.core.budget.CompteBudgetaireSpecification;
import ma.zs.stocky.service.facade.admin.budget.CompteBudgetaireAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CompteBudgetaireAdminServiceImpl extends AbstractServiceImpl<CompteBudgetaire, CompteBudgetaireCriteria, CompteBudgetaireDao> implements CompteBudgetaireAdminService {








    public List<CompteBudgetaire> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CompteBudgetaire.class, CompteBudgetaireSpecification.class);
    }



    public CompteBudgetaireAdminServiceImpl(CompteBudgetaireDao dao) {
        super(dao);
    }

}
