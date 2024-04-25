package ma.zs.stocky.bean.core.budget;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "budget")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="budget_seq",sequenceName="budget_seq",allocationSize=1, initialValue = 1)
public class Budget   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateBudget ;
    private BigDecimal montant = BigDecimal.ZERO;
    private BigDecimal montantInvestissement = BigDecimal.ZERO;
    private BigDecimal montantFonction = BigDecimal.ZERO;


    private List<BudgetEntiteAdmin> budgetEntiteAdmins ;

    public Budget(){
        super();
    }

    public Budget(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="budget_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateBudget(){
        return this.dateBudget;
    }
    public void setDateBudget(LocalDateTime dateBudget){
        this.dateBudget = dateBudget;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public BigDecimal getMontantInvestissement(){
        return this.montantInvestissement;
    }
    public void setMontantInvestissement(BigDecimal montantInvestissement){
        this.montantInvestissement = montantInvestissement;
    }
    public BigDecimal getMontantFonction(){
        return this.montantFonction;
    }
    public void setMontantFonction(BigDecimal montantFonction){
        this.montantFonction = montantFonction;
    }
    @OneToMany(mappedBy = "budget")

    public List<BudgetEntiteAdmin> getBudgetEntiteAdmins(){
        return this.budgetEntiteAdmins;
    }
    public void setBudgetEntiteAdmins(List<BudgetEntiteAdmin> budgetEntiteAdmins){
        this.budgetEntiteAdmins = budgetEntiteAdmins;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return id != null && id.equals(budget.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

