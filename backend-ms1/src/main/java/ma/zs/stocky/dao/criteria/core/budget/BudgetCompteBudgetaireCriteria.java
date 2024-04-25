package  ma.zs.stocky.dao.criteria.core.budget;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class BudgetCompteBudgetaireCriteria extends  BaseCriteria  {

    private String montant;
    private String montantMin;
    private String montantMax;

    private BudgetCriteria budget ;
    private List<BudgetCriteria> budgets ;
    private CompteBudgetaireCriteria compteBudgetaire ;
    private List<CompteBudgetaireCriteria> compteBudgetaires ;


    public BudgetCompteBudgetaireCriteria(){}

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
