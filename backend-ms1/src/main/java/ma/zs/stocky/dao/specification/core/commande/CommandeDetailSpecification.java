package  ma.zs.stocky.dao.specification.core.commande;

import ma.zs.stocky.dao.criteria.core.commande.CommandeDetailCriteria;
import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class CommandeDetailSpecification extends  AbstractSpecification<CommandeDetailCriteria, CommandeDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicateBigDecimal("qte", criteria.getQte(), criteria.getQteMin(), criteria.getQteMax());
        addPredicateFk("commande","id", criteria.getCommande()==null?null:criteria.getCommande().getId());
        addPredicateFk("commande","id", criteria.getCommandes());
        addPredicateFk("commande","ref", criteria.getCommande()==null?null:criteria.getCommande().getRef());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
    }

    public CommandeDetailSpecification(CommandeDetailCriteria criteria) {
        super(criteria);
    }

    public CommandeDetailSpecification(CommandeDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
