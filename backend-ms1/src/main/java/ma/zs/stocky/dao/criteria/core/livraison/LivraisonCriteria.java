package  ma.zs.stocky.dao.criteria.core.livraison;


import ma.zs.stocky.dao.criteria.core.reception.ReceptionCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class LivraisonCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private LocalDateTime datelivraison;
    private LocalDateTime datelivraisonFrom;
    private LocalDateTime datelivraisonTo;

    private ReceptionCriteria reception ;
    private List<ReceptionCriteria> receptions ;


    public LivraisonCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public LocalDateTime getDatelivraison(){
        return this.datelivraison;
    }
    public void setDatelivraison(LocalDateTime datelivraison){
        this.datelivraison = datelivraison;
    }
    public LocalDateTime getDatelivraisonFrom(){
        return this.datelivraisonFrom;
    }
    public void setDatelivraisonFrom(LocalDateTime datelivraisonFrom){
        this.datelivraisonFrom = datelivraisonFrom;
    }
    public LocalDateTime getDatelivraisonTo(){
        return this.datelivraisonTo;
    }
    public void setDatelivraisonTo(LocalDateTime datelivraisonTo){
        this.datelivraisonTo = datelivraisonTo;
    }

    public ReceptionCriteria getReception(){
        return this.reception;
    }

    public void setReception(ReceptionCriteria reception){
        this.reception = reception;
    }
    public List<ReceptionCriteria> getReceptions(){
        return this.receptions;
    }

    public void setReceptions(List<ReceptionCriteria> receptions){
        this.receptions = receptions;
    }
}
