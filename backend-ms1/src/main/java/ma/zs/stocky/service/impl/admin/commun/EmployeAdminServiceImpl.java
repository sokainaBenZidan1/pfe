package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Employe;
import ma.zs.stocky.dao.criteria.core.commun.EmployeCriteria;
import ma.zs.stocky.dao.facade.core.commun.EmployeDao;
import ma.zs.stocky.dao.specification.core.commun.EmployeSpecification;
import ma.zs.stocky.service.facade.admin.commun.EmployeAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.EntiteAdminAdminService ;
import ma.zs.stocky.bean.core.commun.EntiteAdmin ;

import java.util.List;
@Service
public class EmployeAdminServiceImpl extends AbstractServiceImpl<Employe, EmployeCriteria, EmployeDao> implements EmployeAdminService {






    public Employe findByReferenceEntity(Employe t){
        return  dao.findByNom(t.getNom());
    }
    public void findOrSaveAssociatedObject(Employe t){
        if( t != null) {
            t.setEntiteAdmin(entiteAdminService.findOrSave(t.getEntiteAdmin()));
        }
    }

    public List<Employe> findByEntiteAdminId(Long id){
        return dao.findByEntiteAdminId(id);
    }
    public int deleteByEntiteAdminId(Long id){
        return dao.deleteByEntiteAdminId(id);
    }
    public long countByEntiteAdminCode(String code){
        return dao.countByEntiteAdminCode(code);
    }

    public List<Employe> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Employe.class, EmployeSpecification.class);
    }


    @Autowired
    private EntiteAdminAdminService entiteAdminService ;

    public EmployeAdminServiceImpl(EmployeDao dao) {
        super(dao);
    }

}
