package ma.zs.stocky.bean.core.expressionbesion;

import java.util.Objects;





import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "expression_besoin_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="expression_besoin_detail_seq",sequenceName="expression_besoin_detail_seq",allocationSize=1, initialValue = 1)
public class ExpressionBesoinDetail   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal qteDemandee = BigDecimal.ZERO;
    private BigDecimal qteAccordee = BigDecimal.ZERO;
    private BigDecimal qteLivre = BigDecimal.ZERO;

    private ExpressionBesoin expressionBesoin ;
    private Produit produit ;


    public ExpressionBesoinDetail(){
        super();
    }

    public ExpressionBesoinDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="expression_besoin_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getQteDemandee(){
        return this.qteDemandee;
    }
    public void setQteDemandee(BigDecimal qteDemandee){
        this.qteDemandee = qteDemandee;
    }
    public BigDecimal getQteAccordee(){
        return this.qteAccordee;
    }
    public void setQteAccordee(BigDecimal qteAccordee){
        this.qteAccordee = qteAccordee;
    }
    public BigDecimal getQteLivre(){
        return this.qteLivre;
    }
    public void setQteLivre(BigDecimal qteLivre){
        this.qteLivre = qteLivre;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expression_besoin")
    public ExpressionBesoin getExpressionBesoin(){
        return this.expressionBesoin;
    }
    public void setExpressionBesoin(ExpressionBesoin expressionBesoin){
        this.expressionBesoin = expressionBesoin;
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
        ExpressionBesoinDetail expressionBesoinDetail = (ExpressionBesoinDetail) o;
        return id != null && id.equals(expressionBesoinDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

