package ma.zs.stocky.bean.core.budget;

import java.util.Objects;





import ma.zs.stocky.bean.core.budget.Budget;
import ma.zs.stocky.bean.core.budget.CompteBudgetaire;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "budget_compte_budgetaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="budget_compte_budgetaire_seq",sequenceName="budget_compte_budgetaire_seq",allocationSize=1, initialValue = 1)
public class BudgetCompteBudgetaire   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal montant = BigDecimal.ZERO;

    private Budget budget ;
    private CompteBudgetaire compteBudgetaire ;


    public BudgetCompteBudgetaire(){
        super();
    }

    public BudgetCompteBudgetaire(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="budget_compte_budgetaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget")
    public Budget getBudget(){
        return this.budget;
    }
    public void setBudget(Budget budget){
        this.budget = budget;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compte_budgetaire")
    public CompteBudgetaire getCompteBudgetaire(){
        return this.compteBudgetaire;
    }
    public void setCompteBudgetaire(CompteBudgetaire compteBudgetaire){
        this.compteBudgetaire = compteBudgetaire;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetCompteBudgetaire budgetCompteBudgetaire = (BudgetCompteBudgetaire) o;
        return id != null && id.equals(budgetCompteBudgetaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

