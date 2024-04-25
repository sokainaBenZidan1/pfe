package  ma.zs.stocky.dao.specification.core.livraison;

import ma.zs.stocky.dao.criteria.core.livraison.LivraisonDetailCriteria;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class LivraisonDetailSpecification extends  AbstractSpecification<LivraisonDetailCriteria, LivraisonDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qte", criteria.getQte(), criteria.getQteMin(), criteria.getQteMax());
        addPredicateFk("magasin","id", criteria.getMagasin()==null?null:criteria.getMagasin().getId());
        addPredicateFk("magasin","id", criteria.getMagasins());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
        addPredicateFk("livraison","id", criteria.getLivraison()==null?null:criteria.getLivraison().getId());
        addPredicateFk("livraison","id", criteria.getLivraisons());
        addPredicateFk("livraison","ref", criteria.getLivraison()==null?null:criteria.getLivraison().getRef());
    }

    public LivraisonDetailSpecification(LivraisonDetailCriteria criteria) {
        super(criteria);
    }

    public LivraisonDetailSpecification(LivraisonDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
