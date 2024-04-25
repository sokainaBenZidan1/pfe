package ma.zs.stocky.bean.core.achat;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.bean.core.budget.Budget;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "achat_materiel")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="achat_materiel_seq",sequenceName="achat_materiel_seq",allocationSize=1, initialValue = 1)
public class AchatMateriel   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal montantTotal = BigDecimal.ZERO;
    private LocalDateTime dateAchat ;

    private Budget budget ;
    private TypeAchatMateriel typeAchatMateriel ;

    private List<AchatMaterielDetail> achatMaterielDetails ;

    public AchatMateriel(){
        super();
    }

    public AchatMateriel(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="achat_materiel_seq")
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
    public BigDecimal getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal){
        this.montantTotal = montantTotal;
    }
    public LocalDateTime getDateAchat(){
        return this.dateAchat;
    }
    public void setDateAchat(LocalDateTime dateAchat){
        this.dateAchat = dateAchat;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_achat_materiel")
    public TypeAchatMateriel getTypeAchatMateriel(){
        return this.typeAchatMateriel;
    }
    public void setTypeAchatMateriel(TypeAchatMateriel typeAchatMateriel){
        this.typeAchatMateriel = typeAchatMateriel;
    }
    @OneToMany(mappedBy = "achatMateriel")

    public List<AchatMaterielDetail> getAchatMaterielDetails(){
        return this.achatMaterielDetails;
    }
    public void setAchatMaterielDetails(List<AchatMaterielDetail> achatMaterielDetails){
        this.achatMaterielDetails = achatMaterielDetails;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchatMateriel achatMateriel = (AchatMateriel) o;
        return id != null && id.equals(achatMateriel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

