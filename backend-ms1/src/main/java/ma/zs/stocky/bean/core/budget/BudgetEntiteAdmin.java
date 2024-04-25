package ma.zs.stocky.bean.core.budget;

import java.util.Objects;





import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.bean.core.budget.Budget;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "budget_entite_admin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="budget_entite_admin_seq",sequenceName="budget_entite_admin_seq",allocationSize=1, initialValue = 1)
public class BudgetEntiteAdmin   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal montantEntite = BigDecimal.ZERO;
    private BigDecimal montantInvEntite = BigDecimal.ZERO;
    private BigDecimal montantFctEntite = BigDecimal.ZERO;

    private EntiteAdmin entiteAdmin ;
    private Budget budget ;


    public BudgetEntiteAdmin(){
        super();
    }

    public BudgetEntiteAdmin(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="budget_entite_admin_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_admin")
    public EntiteAdmin getEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void setEntiteAdmin(EntiteAdmin entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public BigDecimal getMontantEntite(){
        return this.montantEntite;
    }
    public void setMontantEntite(BigDecimal montantEntite){
        this.montantEntite = montantEntite;
    }
    public BigDecimal getMontantInvEntite(){
        return this.montantInvEntite;
    }
    public void setMontantInvEntite(BigDecimal montantInvEntite){
        this.montantInvEntite = montantInvEntite;
    }
    public BigDecimal getMontantFctEntite(){
        return this.montantFctEntite;
    }
    public void setMontantFctEntite(BigDecimal montantFctEntite){
        this.montantFctEntite = montantFctEntite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget")
    public Budget getBudget(){
        return this.budget;
    }
    public void setBudget(Budget budget){
        this.budget = budget;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetEntiteAdmin budgetEntiteAdmin = (BudgetEntiteAdmin) o;
        return id != null && id.equals(budgetEntiteAdmin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

