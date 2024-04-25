package ma.zs.stocky.bean.core.stock;

import java.util.Objects;





import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "stock")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="stock_seq",sequenceName="stock_seq",allocationSize=1, initialValue = 1)
public class Stock   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal qte = BigDecimal.ZERO;
    private BigDecimal qteDeffectueuse = BigDecimal.ZERO;

    private Magasin magasin ;
    private Produit produit ;


    public Stock(){
        super();
    }

    public Stock(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="stock_seq")
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
    public BigDecimal getQteDeffectueuse(){
        return this.qteDeffectueuse;
    }
    public void setQteDeffectueuse(BigDecimal qteDeffectueuse){
        this.qteDeffectueuse = qteDeffectueuse;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return id != null && id.equals(stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

