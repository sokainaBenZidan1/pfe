package ma.zs.stocky.service.impl.admin.achat;


import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.dao.criteria.core.achat.TypeAchatMaterielCriteria;
import ma.zs.stocky.dao.facade.core.achat.TypeAchatMaterielDao;
import ma.zs.stocky.dao.specification.core.achat.TypeAchatMaterielSpecification;
import ma.zs.stocky.service.facade.admin.achat.TypeAchatMaterielAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeAchatMaterielAdminServiceImpl extends AbstractServiceImpl<TypeAchatMateriel, TypeAchatMaterielCriteria, TypeAchatMaterielDao> implements TypeAchatMaterielAdminService {








    public List<TypeAchatMateriel> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeAchatMateriel.class, TypeAchatMaterielSpecification.class);
    }



    public TypeAchatMaterielAdminServiceImpl(TypeAchatMaterielDao dao) {
        super(dao);
    }

}
