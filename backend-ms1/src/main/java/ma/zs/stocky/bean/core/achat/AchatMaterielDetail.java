package ma.zs.stocky.bean.core.achat;

import java.util.Objects;





import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.bean.core.achat.AchatMateriel;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "achat_materiel_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="achat_materiel_detail_seq",sequenceName="achat_materiel_detail_seq",allocationSize=1, initialValue = 1)
public class AchatMaterielDetail   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal qteAchetee = BigDecimal.ZERO;
    private BigDecimal qteRecue = BigDecimal.ZERO;
    private BigDecimal qteLivree = BigDecimal.ZERO;

    private Produit produit ;
    private AchatMateriel achatMateriel ;


    public AchatMaterielDetail(){
        super();
    }

    public AchatMaterielDetail(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="achat_materiel_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit")
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQteAchetee(){
        return this.qteAchetee;
    }
    public void setQteAchetee(BigDecimal qteAchetee){
        this.qteAchetee = qteAchetee;
    }
    public BigDecimal getQteRecue(){
        return this.qteRecue;
    }
    public void setQteRecue(BigDecimal qteRecue){
        this.qteRecue = qteRecue;
    }
    public BigDecimal getQteLivree(){
        return this.qteLivree;
    }
    public void setQteLivree(BigDecimal qteLivree){
        this.qteLivree = qteLivree;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "achat_materiel")
    public AchatMateriel getAchatMateriel(){
        return this.achatMateriel;
    }
    public void setAchatMateriel(AchatMateriel achatMateriel){
        this.achatMateriel = achatMateriel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchatMaterielDetail achatMaterielDetail = (AchatMaterielDetail) o;
        return id != null && id.equals(achatMaterielDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

