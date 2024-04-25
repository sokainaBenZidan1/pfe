package ma.zs.stocky.service.facade.admin.expressionbesion;

import java.util.List;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ExpressionBesoinAdminService extends  IService<ExpressionBesoin,ExpressionBesoinCriteria>  {

    List<ExpressionBesoin> findByEmployeId(Long id);
    int deleteByEmployeId(Long id);
    long countByEmployeNom(String nom);
    List<ExpressionBesoin> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);
    List<ExpressionBesoin> findByEtatId(Long id);
    int deleteByEtatId(Long id);
    long countByEtatCode(String code);




}
