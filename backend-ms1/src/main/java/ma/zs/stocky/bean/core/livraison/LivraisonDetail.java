package ma.zs.stocky.bean.core.livraison;

import java.util.Objects;





import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "livraison_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="livraison_detail_seq",sequenceName="livraison_detail_seq",allocationSize=1, initialValue = 1)
public class LivraisonDetail   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal qte = BigDecimal.ZERO;

    private Magasin magasin ;
    private Produit produit ;
    private Livraison livraison ;


    public LivraisonDetail(){
        super();
    }

    public LivraisonDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="livraison_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getQte(){
        return this.qte;
    }
    public void setQte(BigDecimal qte){
        this.qte = qte;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magasin")
    public Magasin getMagasin(){
        return this.magasin;
    }
    public void setMagasin(Magasin magasin){
        this.magasin = magasin;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit")
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livraison")
    public Livraison getLivraison(){
        return this.livraison;
    }
    public void setLivraison(Livraison livraison){
        this.livraison = livraison;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivraisonDetail livraisonDetail = (LivraisonDetail) o;
        return id != null && id.equals(livraisonDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

