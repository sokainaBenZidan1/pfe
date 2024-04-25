package  ma.zs.stocky.dao.specification.core.reception;

import ma.zs.stocky.dao.criteria.core.reception.ReceptionDetailCriteria;
import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ReceptionDetailSpecification extends  AbstractSpecification<ReceptionDetailCriteria, ReceptionDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("qte", criteria.getQte(), criteria.getQteMin(), criteria.getQteMax());
        addPredicateFk("magasin","id", criteria.getMagasin()==null?null:criteria.getMagasin().getId());
        addPredicateFk("magasin","id", criteria.getMagasins());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","code", criteria.getProduit()==null?null:criteria.getProduit().getCode());
        addPredicateFk("reception","id", criteria.getReception()==null?null:criteria.getReception().getId());
        addPredicateFk("reception","id", criteria.getReceptions());
        addPredicateFk("reception","ref", criteria.getReception()==null?null:criteria.getReception().getRef());
    }

    public ReceptionDetailSpecification(ReceptionDetailCriteria criteria) {
        super(criteria);
    }

    public ReceptionDetailSpecification(ReceptionDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
