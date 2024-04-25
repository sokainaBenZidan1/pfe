package  ma.zs.stocky.dao.specification.core.inventaire;

import ma.zs.stocky.dao.criteria.core.inventaire.ResponsableInventaireCriteria;
import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ResponsableInventaireSpecification extends  AbstractSpecification<ResponsableInventaireCriteria, ResponsableInventaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("login", criteria.getLogin(),criteria.getLoginLike());
        addPredicate("mdp", criteria.getMdp(),criteria.getMdpLike());
    }

    public ResponsableInventaireSpecification(ResponsableInventaireCriteria criteria) {
        super(criteria);
    }

    public ResponsableInventaireSpecification(ResponsableInventaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
