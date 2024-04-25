package ma.zs.stocky.bean.core.commande;

import java.util.Objects;





import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "commande_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="commande_detail_seq",sequenceName="commande_detail_seq",allocationSize=1, initialValue = 1)
public class CommandeDetail   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal prix = BigDecimal.ZERO;
    private BigDecimal qte = BigDecimal.ZERO;

    private Commande commande ;
    private Produit produit ;


    public CommandeDetail(){
        super();
    }

    public CommandeDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="commande_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }
    public BigDecimal getQte(){
        return this.qte;
    }
    public void setQte(BigDecimal qte){
        this.qte = qte;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande")
    public Commande getCommande(){
        return this.commande;
    }
    public void setCommande(Commande commande){
        this.commande = commande;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit")
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeDetail commandeDetail = (CommandeDetail) o;
        return id != null && id.equals(commandeDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

