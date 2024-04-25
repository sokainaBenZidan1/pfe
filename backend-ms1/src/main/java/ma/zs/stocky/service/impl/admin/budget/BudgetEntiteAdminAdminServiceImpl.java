package ma.zs.stocky.service.impl.admin.budget;


import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import ma.zs.stocky.dao.criteria.core.budget.BudgetEntiteAdminCriteria;
import ma.zs.stocky.dao.facade.core.budget.BudgetEntiteAdminDao;
import ma.zs.stocky.dao.specification.core.budget.BudgetEntiteAdminSpecification;
import ma.zs.stocky.service.facade.admin.budget.BudgetEntiteAdminAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.EntiteAdminAdminService ;
import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.service.facade.admin.budget.BudgetAdminService ;
import ma.zs.stocky.bean.core.budget.Budget ;

import java.util.List;
@Service
public class BudgetEntiteAdminAdminServiceImpl extends AbstractServiceImpl<BudgetEntiteAdmin, BudgetEntiteAdminCriteria, BudgetEntiteAdminDao> implements BudgetEntiteAdminAdminService {






    public void findOrSaveAssociatedObject(BudgetEntiteAdmin t){
        if( t != null) {
            t.setEntiteAdmin(entiteAdminService.findOrSave(t.getEntiteAdmin()));
            t.setBudget(budgetService.findOrSave(t.getBudget()));
        }
    }

    public List<BudgetEntiteAdmin> findByEntiteAdminId(Long id){
        return dao.findByEntiteAdminId(id);
    }
    public int deleteByEntiteAdminId(Long id){
        return dao.deleteByEntiteAdminId(id);
    }
    public long countByEntiteAdminCode(String code){
        return dao.countByEntiteAdminCode(code);
    }
    public List<BudgetEntiteAdmin> findByBudgetId(Long id){
        return dao.findByBudgetId(id);
    }
    public int deleteByBudgetId(Long id){
        return dao.deleteByBudgetId(id);
    }
    public long countByBudgetId(Long id){
        return dao.countByBudgetId(id);
    }






    public void configure() {
        super.configure(BudgetEntiteAdmin.class, BudgetEntiteAdminSpecification.class);
    }


    @Autowired
    private EntiteAdminAdminService entiteAdminService ;
    @Autowired
    private BudgetAdminService budgetService ;

    public BudgetEntiteAdminAdminServiceImpl(BudgetEntiteAdminDao dao) {
        super(dao);
    }

}
