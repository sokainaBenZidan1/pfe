package ma.zs.stocky.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "operation_stock")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="operation_stock_seq",sequenceName="operation_stock_seq",allocationSize=1, initialValue = 1)
public class OperationStock   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private LocalDateTime dateOS ;
    @Column(length = 500)
    private String discription;

    private Magasin magasinSource ;
    private Magasin magasinDest ;

    private List<OperationStockDetail> operationStockDetails ;

    public OperationStock(){
        super();
    }

    public OperationStock(Long id){
        this.id = id;
    }

    public OperationStock(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public OperationStock(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="operation_stock_seq")
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
    public LocalDateTime getDateOS(){
        return this.dateOS;
    }
    public void setDateOS(LocalDateTime dateOS){
        this.dateOS = dateOS;
    }
    public String getDiscription(){
        return this.discription;
    }
    public void setDiscription(String discription){
        this.discription = discription;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magasin_source")
    public Magasin getMagasinSource(){
        return this.magasinSource;
    }
    public void setMagasinSource(Magasin magasinSource){
        this.magasinSource = magasinSource;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magasin_dest")
    public Magasin getMagasinDest(){
        return this.magasinDest;
    }
    public void setMagasinDest(Magasin magasinDest){
        this.magasinDest = magasinDest;
    }
    @OneToMany(mappedBy = "operationStock")

    public List<OperationStockDetail> getOperationStockDetails(){
        return this.operationStockDetails;
    }
    public void setOperationStockDetails(List<OperationStockDetail> operationStockDetails){
        this.operationStockDetails = operationStockDetails;
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
        OperationStock operationStock = (OperationStock) o;
        return id != null && id.equals(operationStock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

