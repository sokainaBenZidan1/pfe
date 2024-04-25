package  ma.zs.stocky.dao.criteria.core.achat;


import ma.zs.stocky.dao.criteria.core.budget.BudgetCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AchatMaterielCriteria extends  BaseCriteria  {

    private String montantTotal;
    private String montantTotalMin;
    private String montantTotalMax;
    private LocalDateTime dateAchat;
    private LocalDateTime dateAchatFrom;
    private LocalDateTime dateAchatTo;

    private BudgetCriteria budget ;
    private List<BudgetCriteria> budgets ;
    private TypeAchatMaterielCriteria typeAchatMateriel ;
    private List<TypeAchatMaterielCriteria> typeAchatMateriels ;


    public AchatMaterielCriteria(){}

    public String getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(String montantTotal){
        this.montantTotal = montantTotal;
    }   
    public String getMontantTotalMin(){
        return this.montantTotalMin;
    }
    public void setMontantTotalMin(String montantTotalMin){
        this.montantTotalMin = montantTotalMin;
    }
    public String getMontantTotalMax(){
        return this.montantTotalMax;
    }
    public void setMontantTotalMax(String montantTotalMax){
        this.montantTotalMax = montantTotalMax;
    }
      
    public LocalDateTime getDateAchat(){
        return this.dateAchat;
    }
    public void setDateAchat(LocalDateTime dateAchat){
        this.dateAchat = dateAchat;
    }
    public LocalDateTime getDateAchatFrom(){
        return this.dateAchatFrom;
    }
    public void setDateAchatFrom(LocalDateTime dateAchatFrom){
        this.dateAchatFrom = dateAchatFrom;
    }
    public LocalDateTime getDateAchatTo(){
        return this.dateAchatTo;
    }
    public void setDateAchatTo(LocalDateTime dateAchatTo){
        this.dateAchatTo = dateAchatTo;
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
    public TypeAchatMaterielCriteria getTypeAchatMateriel(){
        return this.typeAchatMateriel;
    }

    public void setTypeAchatMateriel(TypeAchatMaterielCriteria typeAchatMateriel){
        this.typeAchatMateriel = typeAchatMateriel;
    }
    public List<TypeAchatMaterielCriteria> getTypeAchatMateriels(){
        return this.typeAchatMateriels;
    }

    public void setTypeAchatMateriels(List<TypeAchatMaterielCriteria> typeAchatMateriels){
        this.typeAchatMateriels = typeAchatMateriels;
    }
}
