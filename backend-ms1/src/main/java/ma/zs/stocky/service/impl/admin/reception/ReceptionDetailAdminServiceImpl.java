package ma.zs.stocky.service.impl.admin.reception;


import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.dao.criteria.core.reception.ReceptionDetailCriteria;
import ma.zs.stocky.dao.facade.core.reception.ReceptionDetailDao;
import ma.zs.stocky.dao.specification.core.reception.ReceptionDetailSpecification;
import ma.zs.stocky.service.facade.admin.reception.ReceptionDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.stock.MagasinAdminService ;
import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.service.facade.admin.reception.ReceptionAdminService ;
import ma.zs.stocky.bean.core.reception.Reception ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class ReceptionDetailAdminServiceImpl extends AbstractServiceImpl<ReceptionDetail, ReceptionDetailCriteria, ReceptionDetailDao> implements ReceptionDetailAdminService {






    public void findOrSaveAssociatedObject(ReceptionDetail t){
        if( t != null) {
            t.setMagasin(magasinService.findOrSave(t.getMagasin()));
            t.setProduit(produitService.findOrSave(t.getProduit()));
            t.setReception(receptionService.findOrSave(t.getReception()));
        }
    }

    public List<ReceptionDetail> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public long countByMagasinId(Long id){
        return dao.countByMagasinId(id);
    }
    public List<ReceptionDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }
    public List<ReceptionDetail> findByReceptionId(Long id){
        return dao.findByReceptionId(id);
    }
    public int deleteByReceptionId(Long id){
        return dao.deleteByReceptionId(id);
    }
    public long countByReceptionRef(String ref){
        return dao.countByReceptionRef(ref);
    }






    public void configure() {
        super.configure(ReceptionDetail.class, ReceptionDetailSpecification.class);
    }


    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private ReceptionAdminService receptionService ;
    @Autowired
    private ProduitAdminService produitService ;

    public ReceptionDetailAdminServiceImpl(ReceptionDetailDao dao) {
        super(dao);
    }

}
