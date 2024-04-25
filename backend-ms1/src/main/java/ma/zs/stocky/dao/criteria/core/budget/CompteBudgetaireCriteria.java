package  ma.zs.stocky.dao.criteria.core.budget;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CompteBudgetaireCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;
    private String montantMax;
    private String montantMaxMin;
    private String montantMaxMax;



    public CompteBudgetaireCriteria(){}

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

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }   
    public String getMontantMaxMin(){
        return this.montantMaxMin;
    }
    public void setMontantMaxMin(String montantMaxMin){
        this.montantMaxMin = montantMaxMin;
    }
    public String getMontantMaxMax(){
        return this.montantMaxMax;
    }
    public void setMontantMaxMax(String montantMaxMax){
        this.montantMaxMax = montantMaxMax;
    }
      

}
