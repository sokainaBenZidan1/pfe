package ma.zs.stocky.bean.core.stock;

import java.util.Objects;





import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "operation_stock_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="operation_stock_detail_seq",sequenceName="operation_stock_detail_seq",allocationSize=1, initialValue = 1)
public class OperationStockDetail   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal qte = BigDecimal.ZERO;

    private Produit produit ;
    private OperationStock operationStock ;


    public OperationStockDetail(){
        super();
    }

    public OperationStockDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="operation_stock_detail_seq")
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
    @JoinColumn(name = "produit")
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_stock")
    public OperationStock getOperationStock(){
        return this.operationStock;
    }
    public void setOperationStock(OperationStock operationStock){
        this.operationStock = operationStock;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationStockDetail operationStockDetail = (OperationStockDetail) o;
        return id != null && id.equals(operationStockDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

