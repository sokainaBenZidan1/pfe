package ma.zs.stocky.bean.core.livraison;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "livraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="livraison_seq",sequenceName="livraison_seq",allocationSize=1, initialValue = 1)
public class Livraison   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private LocalDateTime datelivraison ;

    private Reception reception ;

    private List<LivraisonDetail> livraisonDetails ;

    public Livraison(){
        super();
    }

    public Livraison(Long id){
        this.id = id;
    }

    public Livraison(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Livraison(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="livraison_seq")
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
    public LocalDateTime getDatelivraison(){
        return this.datelivraison;
    }
    public void setDatelivraison(LocalDateTime datelivraison){
        this.datelivraison = datelivraison;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reception")
    public Reception getReception(){
        return this.reception;
    }
    public void setReception(Reception reception){
        this.reception = reception;
    }
    @OneToMany(mappedBy = "livraison")

    public List<LivraisonDetail> getLivraisonDetails(){
        return this.livraisonDetails;
    }
    public void setLivraisonDetails(List<LivraisonDetail> livraisonDetails){
        this.livraisonDetails = livraisonDetails;
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
        Livraison livraison = (Livraison) o;
        return id != null && id.equals(livraison.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

