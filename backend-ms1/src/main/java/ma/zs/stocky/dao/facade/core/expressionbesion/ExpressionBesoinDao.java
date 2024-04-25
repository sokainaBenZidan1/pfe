package ma.zs.stocky.dao.facade.core.expressionbesion;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ExpressionBesoinDao extends AbstractRepository<ExpressionBesoin,Long>  {

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
