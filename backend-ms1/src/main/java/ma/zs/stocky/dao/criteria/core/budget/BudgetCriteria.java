package  ma.zs.stocky.dao.criteria.core.budget;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class BudgetCriteria extends  BaseCriteria  {

    private LocalDateTime dateBudget;
    private LocalDateTime dateBudgetFrom;
    private LocalDateTime dateBudgetTo;
    private String montant;
    private String montantMin;
    private String montantMax;
    private String montantInvestissement;
    private String montantInvestissementMin;
    private String montantInvestissementMax;
    private String montantFonction;
    private String montantFonctionMin;
    private String montantFonctionMax;



    public BudgetCriteria(){}

    public LocalDateTime getDateBudget(){
        return this.dateBudget;
    }
    public void setDateBudget(LocalDateTime dateBudget){
        this.dateBudget = dateBudget;
    }
    public LocalDateTime getDateBudgetFrom(){
        return this.dateBudgetFrom;
    }
    public void setDateBudgetFrom(LocalDateTime dateBudgetFrom){
        this.dateBudgetFrom = dateBudgetFrom;
    }
    public LocalDateTime getDateBudgetTo(){
        return this.dateBudgetTo;
    }
    public void setDateBudgetTo(LocalDateTime dateBudgetTo){
        this.dateBudgetTo = dateBudgetTo;
    }
    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      
    public String getMontantInvestissement(){
        return this.montantInvestissement;
    }
    public void setMontantInvestissement(String montantInvestissement){
        this.montantInvestissement = montantInvestissement;
    }   
    public String getMontantInvestissementMin(){
        return this.montantInvestissementMin;
    }
    public void setMontantInvestissementMin(String montantInvestissementMin){
        this.montantInvestissementMin = montantInvestissementMin;
    }
    public String getMontantInvestissementMax(){
        return this.montantInvestissementMax;
    }
    public void setMontantInvestissementMax(String montantInvestissementMax){
        this.montantInvestissementMax = montantInvestissementMax;
    }
      
    public String getMontantFonction(){
        return this.montantFonction;
    }
    public void setMontantFonction(String montantFonction){
        this.montantFonction = montantFonction;
    }   
    public String getMontantFonctionMin(){
        return this.montantFonctionMin;
    }
    public void setMontantFonctionMin(String montantFonctionMin){
        this.montantFonctionMin = montantFonctionMin;
    }
    public String getMontantFonctionMax(){
        return this.montantFonctionMax;
    }
    public void setMontantFonctionMax(String montantFonctionMax){
        this.montantFonctionMax = montantFonctionMax;
    }
      

}
