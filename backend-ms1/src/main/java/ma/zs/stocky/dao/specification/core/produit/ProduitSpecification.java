package  ma.zs.stocky.dao.specification.core.produit;

import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;
import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ProduitSpecification extends  AbstractSpecification<ProduitCriteria, Produit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("categorieProduit","id", criteria.getCategorieProduit()==null?null:criteria.getCategorieProduit().getId());
        addPredicateFk("categorieProduit","id", criteria.getCategorieProduits());
    }

    public ProduitSpecification(ProduitCriteria criteria) {
        super(criteria);
    }

    public ProduitSpecification(ProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
