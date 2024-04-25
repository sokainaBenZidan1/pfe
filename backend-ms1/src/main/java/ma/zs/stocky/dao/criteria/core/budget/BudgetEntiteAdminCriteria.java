package  ma.zs.stocky.dao.criteria.core.budget;


import ma.zs.stocky.dao.criteria.core.commun.EntiteAdminCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class BudgetEntiteAdminCriteria extends  BaseCriteria  {

    private String montantEntite;
    private String montantEntiteMin;
    private String montantEntiteMax;
    private String montantInvEntite;
    private String montantInvEntiteMin;
    private String montantInvEntiteMax;
    private String montantFctEntite;
    private String montantFctEntiteMin;
    private String montantFctEntiteMax;

    private EntiteAdminCriteria entiteAdmin ;
    private List<EntiteAdminCriteria> entiteAdmins ;
    private BudgetCriteria budget ;
    private List<BudgetCriteria> budgets ;


    public BudgetEntiteAdminCriteria(){}

    public String getMontantEntite(){
        return this.montantEntite;
    }
    public void setMontantEntite(String montantEntite){
        this.montantEntite = montantEntite;
    }   
    public String getMontantEntiteMin(){
        return this.montantEntiteMin;
    }
    public void setMontantEntiteMin(String montantEntiteMin){
        this.montantEntiteMin = montantEntiteMin;
    }
    public String getMontantEntiteMax(){
        return this.montantEntiteMax;
    }
    public void setMontantEntiteMax(String montantEntiteMax){
        this.montantEntiteMax = montantEntiteMax;
    }
      
    public String getMontantInvEntite(){
        return this.montantInvEntite;
    }
    public void setMontantInvEntite(String montantInvEntite){
        this.montantInvEntite = montantInvEntite;
    }   
    public String getMontantInvEntiteMin(){
        return this.montantInvEntiteMin;
    }
    public void setMontantInvEntiteMin(String montantInvEntiteMin){
        this.montantInvEntiteMin = montantInvEntiteMin;
    }
    public String getMontantInvEntiteMax(){
        return this.montantInvEntiteMax;
    }
    public void setMontantInvEntiteMax(String montantInvEntiteMax){
        this.montantInvEntiteMax = montantInvEntiteMax;
    }
      
    public String getMontantFctEntite(){
        return this.montantFctEntite;
    }
    public void setMontantFctEntite(String montantFctEntite){
        this.montantFctEntite = montantFctEntite;
    }   
    public String getMontantFctEntiteMin(){
        return this.montantFctEntiteMin;
    }
    public void setMontantFctEntiteMin(String montantFctEntiteMin){
        this.montantFctEntiteMin = montantFctEntiteMin;
    }
    public String getMontantFctEntiteMax(){
        return this.montantFctEntiteMax;
    }
    public void setMontantFctEntiteMax(String montantFctEntiteMax){
        this.montantFctEntiteMax = montantFctEntiteMax;
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
    public BudgetCriteria getBudget(){
        return this.budget;
    }

    public void setBudget(BudgetCriteria budget){
        this.budget = budget;
    }
    public List<BudgetCriteria> getBudgets(){
        return this.budgets;
    }

    public void setBudgets(List<BudgetCriteria> budgets){
        this.budgets = budgets;
    }
}
