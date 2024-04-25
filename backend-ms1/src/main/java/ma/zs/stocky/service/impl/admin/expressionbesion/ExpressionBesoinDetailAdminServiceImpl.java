package ma.zs.stocky.service.impl.admin.expressionbesion;


import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinDetailCriteria;
import ma.zs.stocky.dao.facade.core.expressionbesion.ExpressionBesoinDetailDao;
import ma.zs.stocky.dao.specification.core.expressionbesion.ExpressionBesoinDetailSpecification;
import ma.zs.stocky.service.facade.admin.expressionbesion.ExpressionBesoinDetailAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.expressionbesion.ExpressionBesoinAdminService ;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin ;
import ma.zs.stocky.service.facade.admin.produit.ProduitAdminService ;
import ma.zs.stocky.bean.core.produit.Produit ;

import java.util.List;
@Service
public class ExpressionBesoinDetailAdminServiceImpl extends AbstractServiceImpl<ExpressionBesoinDetail, ExpressionBesoinDetailCriteria, ExpressionBesoinDetailDao> implements ExpressionBesoinDetailAdminService {






    public void findOrSaveAssociatedObject(ExpressionBesoinDetail t){
        if( t != null) {
            t.setExpressionBesoin(expressionBesoinService.findOrSave(t.getExpressionBesoin()));
            t.setProduit(produitService.findOrSave(t.getProduit()));
        }
    }

    public List<ExpressionBesoinDetail> findByExpressionBesoinId(Long id){
        return dao.findByExpressionBesoinId(id);
    }
    public int deleteByExpressionBesoinId(Long id){
        return dao.deleteByExpressionBesoinId(id);
    }
    public long countByExpressionBesoinId(Long id){
        return dao.countByExpressionBesoinId(id);
    }
    public List<ExpressionBesoinDetail> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitCode(String code){
        return dao.countByProduitCode(code);
    }






    public void configure() {
        super.configure(ExpressionBesoinDetail.class, ExpressionBesoinDetailSpecification.class);
    }


    @Autowired
    private ExpressionBesoinAdminService expressionBesoinService ;
    @Autowired
    private ProduitAdminService produitService ;

    public ExpressionBesoinDetailAdminServiceImpl(ExpressionBesoinDetailDao dao) {
        super(dao);
    }

}
