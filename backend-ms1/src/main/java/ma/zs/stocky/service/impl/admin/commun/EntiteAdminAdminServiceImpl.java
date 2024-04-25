package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.stocky.dao.facade.core.commun.EntiteAdminDao;
import ma.zs.stocky.dao.specification.core.commun.EntiteAdminSpecification;
import ma.zs.stocky.service.facade.admin.commun.EntiteAdminAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.commun.EntiteAdminAdminService ;
import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.service.facade.admin.commun.EmployeAdminService ;
import ma.zs.stocky.bean.core.commun.Employe ;

import java.util.List;
@Service
public class EntiteAdminAdminServiceImpl extends AbstractServiceImpl<EntiteAdmin, EntiteAdminCriteria, EntiteAdminDao> implements EntiteAdminAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EntiteAdmin create(EntiteAdmin t) {
        EntiteAdmin saved= super.create(t);
        if (saved != null && t.getEmploye() != null) {
                t.getEmploye().forEach(element-> {
                element.setEntiteAdmin(saved);
                employeService.create(element);
            });
        }
        return saved;

    }

    public EntiteAdmin findWithAssociatedLists(Long id){
        EntiteAdmin result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setEmploye(employeService.findByEntiteAdminId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        employeService.deleteByEntiteAdminId(id);
    }


    public void updateWithAssociatedLists(EntiteAdmin entiteAdmin){
    if(entiteAdmin !=null && entiteAdmin.getId() != null){
            List<List<Employe>> resultEmploye= employeService.getToBeSavedAndToBeDeleted(employeService.findByEntiteAdminId(entiteAdmin.getId()),entiteAdmin.getEmploye());
            employeService.delete(resultEmploye.get(1));
            ListUtil.emptyIfNull(resultEmploye.get(0)).forEach(e -> e.setEntiteAdmin(entiteAdmin));
            employeService.update(resultEmploye.get(0),true);
        }
    }




    public EntiteAdmin findByReferenceEntity(EntiteAdmin t){
        return  dao.findByCode(t.getCode());
    }


    public List<EntiteAdmin> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EntiteAdmin.class, EntiteAdminSpecification.class);
    }


    @Autowired
    private EntiteAdminAdminService entiteAdminService ;
    @Autowired
    private EmployeAdminService employeService ;

    public EntiteAdminAdminServiceImpl(EntiteAdminDao dao) {
        super(dao);
    }

}
