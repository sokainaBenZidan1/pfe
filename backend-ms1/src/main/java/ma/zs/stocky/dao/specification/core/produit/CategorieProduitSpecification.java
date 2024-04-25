package  ma.zs.stocky.dao.specification.core.produit;

import ma.zs.stocky.dao.criteria.core.produit.CategorieProduitCriteria;
import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class CategorieProduitSpecification extends  AbstractSpecification<CategorieProduitCriteria, CategorieProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("compteBudgetaire","id", criteria.getCompteBudgetaire()==null?null:criteria.getCompteBudgetaire().getId());
        addPredicateFk("compteBudgetaire","id", criteria.getCompteBudgetaires());
    }

    public CategorieProduitSpecification(CategorieProduitCriteria criteria) {
        super(criteria);
    }

    public CategorieProduitSpecification(CategorieProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
