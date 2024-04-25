package ma.zs.stocky.dao.facade.core.expressionbesion;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ExpressionBesoinDetailDao extends AbstractRepository<ExpressionBesoinDetail,Long>  {

    List<ExpressionBesoinDetail> findByExpressionBesoinId(Long id);
    int deleteByExpressionBesoinId(Long id);
    long countByExpressionBesoinId(Long id);
    List<ExpressionBesoinDetail> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitCode(String code);


}
