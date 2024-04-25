package ma.zs.stocky.bean.core.inventaire;

import java.util.Objects;





import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "inventaire_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="inventaire_detail_seq",sequenceName="inventaire_detail_seq",allocationSize=1, initialValue = 1)
public class InventaireDetail   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal qteCalculee = BigDecimal.ZERO;
    private BigDecimal qteStock = BigDecimal.ZERO;
    private BigDecimal ecart = BigDecimal.ZERO;
    @Column(length = 500)
    private String magasin;

    private Produit produit ;
    private Inventaire inventaire ;


    public InventaireDetail(){
        super();
    }

    public InventaireDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inventaire_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getQteCalculee(){
        return this.qteCalculee;
    }
    public void setQteCalculee(BigDecimal qteCalculee){
        this.qteCalculee = qteCalculee;
    }
    public BigDecimal getQteStock(){
        return this.qteStock;
    }
    public void setQteStock(BigDecimal qteStock){
        this.qteStock = qteStock;
    }
    public BigDecimal getEcart(){
        return this.ecart;
    }
    public void setEcart(BigDecimal ecart){
        this.ecart = ecart;
    }
    public String getMagasin(){
        return this.magasin;
    }
    public void setMagasin(String magasin){
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
    @JoinColumn(name = "inventaire")
    public Inventaire getInventaire(){
        return this.inventaire;
    }
    public void setInventaire(Inventaire inventaire){
        this.inventaire = inventaire;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventaireDetail inventaireDetail = (InventaireDetail) o;
        return id != null && id.equals(inventaireDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

