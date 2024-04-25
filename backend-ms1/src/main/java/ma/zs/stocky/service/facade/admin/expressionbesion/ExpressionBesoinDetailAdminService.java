package ma.zs.stocky.service.facade.admin.expressionbesion;

import java.util.List;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinDetailCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ExpressionBesoinDetailAdminService extends  IService<ExpressionBesoinDetail,ExpressionBesoinDetailCriteria>  {

    List<ExpressionBesoinDetail> findByExpressionBesoinId(Long id);
    int deleteByExpressionBesoinId(Long id);
    long countByExpressionBesoinId(Long id);
    List<ExpressionBesoinDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);




}
