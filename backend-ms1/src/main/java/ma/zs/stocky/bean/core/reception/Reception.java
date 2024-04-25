package ma.zs.stocky.bean.core.reception;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.bean.core.reception.ReceptionDetail;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "reception")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="reception_seq",sequenceName="reception_seq",allocationSize=1, initialValue = 1)
public class Reception   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private LocalDateTime dateReception ;
    @Column(length = 500)
    private String libelle;

    private Commande commande ;

    private List<ReceptionDetail> receptionDetails ;

    public Reception(){
        super();
    }

    public Reception(Long id){
        this.id = id;
    }

    public Reception(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Reception(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="reception_seq")
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
    public LocalDateTime getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(LocalDateTime dateReception){
        this.dateReception = dateReception;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande")
    public Commande getCommande(){
        return this.commande;
    }
    public void setCommande(Commande commande){
        this.commande = commande;
    }
    @OneToMany(mappedBy = "reception")

    public List<ReceptionDetail> getReceptionDetails(){
        return this.receptionDetails;
    }
    public void setReceptionDetails(List<ReceptionDetail> receptionDetails){
        this.receptionDetails = receptionDetails;
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
        Reception reception = (Reception) o;
        return id != null && id.equals(reception.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

