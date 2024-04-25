package ma.zs.stocky.bean.core.commande;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "commande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="commande_seq",sequenceName="commande_seq",allocationSize=1, initialValue = 1)
public class Commande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal totalPaye = BigDecimal.ZERO;
    private LocalDateTime dateCommande ;

    private EntiteAdmin entiteAdmin ;

    private List<CommandeDetail> commandeDetails ;

    public Commande(){
        super();
    }

    public Commande(Long id){
        this.id = id;
    }

    public Commande(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Commande(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="commande_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public BigDecimal getTotalPaye(){
        return this.totalPaye;
    }
    public void setTotalPaye(BigDecimal totalPaye){
        this.totalPaye = totalPaye;
    }
    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }
    @OneToMany(mappedBy = "commande")

    public List<CommandeDetail> getCommandeDetails(){
        return this.commandeDetails;
    }
    public void setCommandeDetails(List<CommandeDetail> commandeDetails){
        this.commandeDetails = commandeDetails;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_admin")
    public EntiteAdmin getEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void setEntiteAdmin(EntiteAdmin entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id != null && id.equals(commande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

