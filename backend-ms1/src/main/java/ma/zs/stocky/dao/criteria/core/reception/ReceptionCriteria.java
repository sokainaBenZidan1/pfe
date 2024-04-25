package  ma.zs.stocky.dao.criteria.core.reception;


import ma.zs.stocky.dao.criteria.core.commande.CommandeCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReceptionCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private LocalDateTime dateReception;
    private LocalDateTime dateReceptionFrom;
    private LocalDateTime dateReceptionTo;
    private String libelle;
    private String libelleLike;

    private CommandeCriteria commande ;
    private List<CommandeCriteria> commandes ;


    public ReceptionCriteria(){}

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

    public LocalDateTime getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(LocalDateTime dateReception){
        this.dateReception = dateReception;
    }
    public LocalDateTime getDateReceptionFrom(){
        return this.dateReceptionFrom;
    }
    public void setDateReceptionFrom(LocalDateTime dateReceptionFrom){
        this.dateReceptionFrom = dateReceptionFrom;
    }
    public LocalDateTime getDateReceptionTo(){
        return this.dateReceptionTo;
    }
    public void setDateReceptionTo(LocalDateTime dateReceptionTo){
        this.dateReceptionTo = dateReceptionTo;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }


    public CommandeCriteria getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeCriteria commande){
        this.commande = commande;
    }
    public List<CommandeCriteria> getCommandes(){
        return this.commandes;
    }

    public void setCommandes(List<CommandeCriteria> commandes){
        this.commandes = commandes;
    }
}
