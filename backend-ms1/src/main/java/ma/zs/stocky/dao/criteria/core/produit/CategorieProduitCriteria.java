package  ma.zs.stocky.dao.criteria.core.produit;


import ma.zs.stocky.dao.criteria.core.budget.CompteBudgetaireCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CategorieProduitCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private CompteBudgetaireCriteria compteBudgetaire ;
    private List<CompteBudgetaireCriteria> compteBudgetaires ;


    public CategorieProduitCriteria(){}

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


    public CompteBudgetaireCriteria getCompteBudgetaire(){
        return this.compteBudgetaire;
    }

    public void setCompteBudgetaire(CompteBudgetaireCriteria compteBudgetaire){
        this.compteBudgetaire = compteBudgetaire;
    }
    public List<CompteBudgetaireCriteria> getCompteBudgetaires(){
        return this.compteBudgetaires;
    }

    public void setCompteBudgetaires(List<CompteBudgetaireCriteria> compteBudgetaires){
        this.compteBudgetaires = compteBudgetaires;
    }
}
