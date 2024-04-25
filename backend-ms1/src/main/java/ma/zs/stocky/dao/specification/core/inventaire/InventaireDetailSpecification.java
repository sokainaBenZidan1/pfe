package  ma.zs.stocky.dao.specification.core.inventaire;

import ma.zs.stocky.dao.criteria.core.inventaire.InventaireDetailCriteria;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class InventaireDetailSpecification extends  AbstractSpecification<InventaireDetailCriteria, InventaireDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qteCalculee", criteria.getQteCalculee(), criteria.getQteCalculeeMin(), criteria.getQteCalculeeMax());
        addPredicateBigDecimal("qteStock", criteria.getQteStock(), criteria.getQteStockMin(), criteria.getQteStockMax());
        addPredicateBigDecimal("ecart", criteria.getEcart(), criteria.getEcartMin(), criteria.getEcartMax());
        addPredicate("magasin", criteria.getMagasin(),criteria.getMagasinLike());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
        addPredicateFk("inventaire","id", criteria.getInventaire()==null?null:criteria.getInventaire().getId());
        addPredicateFk("inventaire","id", criteria.getInventaires());
    }

    public InventaireDetailSpecification(InventaireDetailCriteria criteria) {
        super(criteria);
    }

    public InventaireDetailSpecification(InventaireDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
