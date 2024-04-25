package  ma.zs.stocky.dao.specification.core.achat;

import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielDetailCriteria;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class AchatMaterielDetailSpecification extends  AbstractSpecification<AchatMaterielDetailCriteria, AchatMaterielDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qteAchetee", criteria.getQteAchetee(), criteria.getQteAcheteeMin(), criteria.getQteAcheteeMax());
        addPredicateBigDecimal("qteRecue", criteria.getQteRecue(), criteria.getQteRecueMin(), criteria.getQteRecueMax());
        addPredicateBigDecimal("qteLivree", criteria.getQteLivree(), criteria.getQteLivreeMin(), criteria.getQteLivreeMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
        addPredicateFk("achatMateriel","id", criteria.getAchatMateriel()==null?null:criteria.getAchatMateriel().getId());
        addPredicateFk("achatMateriel","id", criteria.getAchatMateriels());
    }

    public AchatMaterielDetailSpecification(AchatMaterielDetailCriteria criteria) {
        super(criteria);
    }

    public AchatMaterielDetailSpecification(AchatMaterielDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
