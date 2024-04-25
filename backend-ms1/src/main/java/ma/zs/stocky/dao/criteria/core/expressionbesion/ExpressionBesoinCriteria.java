package  ma.zs.stocky.dao.criteria.core.expressionbesion;


import ma.zs.stocky.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.stocky.dao.criteria.core.commun.EmployeCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ExpressionBesoinCriteria extends  BaseCriteria  {

    private String description;
    private String descriptionLike;
    private LocalDateTime dateExpression;
    private LocalDateTime dateExpressionFrom;
    private LocalDateTime dateExpressionTo;

    private EmployeCriteria employe ;
    private List<EmployeCriteria> employes ;
    private EntiteAdminCriteria entiteAdmin ;
    private List<EntiteAdminCriteria> entiteAdmins ;
    private EtatCriteria etat ;
    private List<EtatCriteria> etats ;


    public ExpressionBesoinCriteria(){}

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public LocalDateTime getDateExpression(){
        return this.dateExpression;
    }
    public void setDateExpression(LocalDateTime dateExpression){
        this.dateExpression = dateExpression;
    }
    public LocalDateTime getDateExpressionFrom(){
        return this.dateExpressionFrom;
    }
    public void setDateExpressionFrom(LocalDateTime dateExpressionFrom){
        this.dateExpressionFrom = dateExpressionFrom;
    }
    public LocalDateTime getDateExpressionTo(){
        return this.dateExpressionTo;
    }
    public void setDateExpressionTo(LocalDateTime dateExpressionTo){
        this.dateExpressionTo = dateExpressionTo;
    }

    public EmployeCriteria getEmploye(){
        return this.employe;
    }

    public void setEmploye(EmployeCriteria employe){
        this.employe = employe;
    }
    public List<EmployeCriteria> getEmployes(){
        return this.employes;
    }

    public void setEmployes(List<EmployeCriteria> employes){
        this.employes = employes;
    }
    public EntiteAdminCriteria getEntiteAdmin(){
        return this.entiteAdmin;
    }

    public void setEntiteAdmin(EntiteAdminCriteria entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public List<EntiteAdminCriteria> getEntiteAdmins(){
        return this.entiteAdmins;
    }

    public void setEntiteAdmins(List<EntiteAdminCriteria> entiteAdmins){
        this.entiteAdmins = entiteAdmins;
    }
    public EtatCriteria getEtat(){
        return this.etat;
    }

    public void setEtat(EtatCriteria etat){
        this.etat = etat;
    }
    public List<EtatCriteria> getEtats(){
        return this.etats;
    }

    public void setEtats(List<EtatCriteria> etats){
        this.etats = etats;
    }
}
