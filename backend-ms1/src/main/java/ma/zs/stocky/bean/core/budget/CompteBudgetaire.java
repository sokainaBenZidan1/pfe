package ma.zs.stocky.bean.core.budget;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "compte_budgetaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="compte_budgetaire_seq",sequenceName="compte_budgetaire_seq",allocationSize=1, initialValue = 1)
public class CompteBudgetaire   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;
    private BigDecimal montantMax = BigDecimal.ZERO;



    public CompteBudgetaire(){
        super();
    }

    public CompteBudgetaire(Long id){
        this.id = id;
    }

    public CompteBudgetaire(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public CompteBudgetaire(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="compte_budgetaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public BigDecimal getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(BigDecimal montantMax){
        this.montantMax = montantMax;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteBudgetaire compteBudgetaire = (CompteBudgetaire) o;
        return id != null && id.equals(compteBudgetaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

