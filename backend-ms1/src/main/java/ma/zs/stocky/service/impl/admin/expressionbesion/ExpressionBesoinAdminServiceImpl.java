package ma.zs.stocky.service.impl.admin.expressionbesion;


import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinCriteria;
import ma.zs.stocky.dao.facade.core.expressionbesion.ExpressionBesoinDao;
import ma.zs.stocky.dao.specification.core.expressionbesion.ExpressionBesoinSpecification;
import ma.zs.stocky.service.facade.admin.expressionbesion.ExpressionBesoinAdminService;
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
import ma.zs.stocky.service.facade.admin.expressionbesion.EtatAdminService ;
import ma.zs.stocky.bean.core.expressionbesion.Etat ;
import ma.zs.stocky.service.facade.admin.expressionbesion.ExpressionBesoinDetailAdminService ;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail ;
import ma.zs.stocky.service.facade.admin.expressionbesion.ExpressionBesoinAdminService ;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin ;
import ma.zs.stocky.service.facade.admin.commun.EmployeAdminService ;
import ma.zs.stocky.bean.core.commun.Employe ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class ExpressionBesoinAdminServiceImpl extends AbstractServiceImpl<ExpressionBesoin, ExpressionBesoinCriteria, ExpressionBesoinDao> implements ExpressionBesoinAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ExpressionBesoin create(ExpressionBesoin t) {
        ExpressionBesoin saved= super.create(t);
        if (saved != null && t.getExpressionBesoinDetails() != null) {
                t.getExpressionBesoinDetails().forEach(element-> {
                element.setExpressionBesoin(saved);
                expressionBesoinDetailService.create(element);
            });
        }
        return saved;

    }

    public ExpressionBesoin findWithAssociatedLists(Long id){
        ExpressionBesoin result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setExpressionBesoinDetails(expressionBesoinDetailService.findByExpressionBesoinId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        expressionBesoinDetailService.deleteByExpressionBesoinId(id);
    }


    public void updateWithAssociatedLists(ExpressionBesoin expressionBesoin){
    if(expressionBesoin !=null && expressionBesoin.getId() != null){
            List<List<ExpressionBesoinDetail>> resultExpressionBesoinDetails= expressionBesoinDetailService.getToBeSavedAndToBeDeleted(expressionBesoinDetailService.findByExpressionBesoinId(expressionBesoin.getId()),expressionBesoin.getExpressionBesoinDetails());
            expressionBesoinDetailService.delete(resultExpressionBesoinDetails.get(1));
            ListUtil.emptyIfNull(resultExpressionBesoinDetails.get(0)).forEach(e -> e.setExpressionBesoin(expressionBesoin));
            expressionBesoinDetailService.update(resultExpressionBesoinDetails.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(ExpressionBesoin t){
        if( t != null) {
            t.setEmploye(employeService.findOrSave(t.getEmploye()));
            t.setEntiteAdmin(entiteAdminService.findOrSave(t.getEntiteAdmin()));
            t.setEtat(etatService.findOrSave(t.getEtat()));
        }
    }

    public List<ExpressionBesoin> findByEmployeId(Long id){
        return dao.findByEmployeId(id);
    }
    public int deleteByEmployeId(Long id){
        return dao.deleteByEmployeId(id);
    }
    public long countByEmployeNom(String nom){
        return dao.countByEmployeNom(nom);
    }
    public List<ExpressionBesoin> findByEntiteAdminId(Long id){
        return dao.findByEntiteAdminId(id);
    }
    public int deleteByEntiteAdminId(Long id){
        return dao.deleteByEntiteAdminId(id);
    }
    public long countByEntiteAdminCode(String code){
        return dao.countByEntiteAdminCode(code);
    }
    public List<ExpressionBesoin> findByEtatId(Long id){
        return dao.findByEtatId(id);
    }
    public int deleteByEtatId(Long id){
        return dao.deleteByEtatId(id);
    }
    public long countByEtatCode(String code){
        return dao.countByEtatCode(code);
    }






    public void configure() {
        super.configure(ExpressionBesoin.class, ExpressionBesoinSpecification.class);
    }


    @Autowired
    private EntiteAdminAdminService entiteAdminService ;
    @Autowired
    private EtatAdminService etatService ;
    @Autowired
    private ExpressionBesoinDetailAdminService expressionBesoinDetailService ;
    @Autowired
    private ExpressionBesoinAdminService expressionBesoinService ;
    @Autowired
    private EmployeAdminService employeService ;
    @Autowired
    private ProduitAdminService produitService ;

    public ExpressionBesoinAdminServiceImpl(ExpressionBesoinDao dao) {
        super(dao);
    }

}
