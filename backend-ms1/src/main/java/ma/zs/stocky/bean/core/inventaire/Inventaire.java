package ma.zs.stocky.bean.core.inventaire;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "inventaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="inventaire_seq",sequenceName="inventaire_seq",allocationSize=1, initialValue = 1)
public class Inventaire   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;

    private ResponsableInventaire responsableInv ;

    private List<InventaireDetail> inventaireDetails ;

    public Inventaire(){
        super();
    }

    public Inventaire(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inventaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsable_inv")
    public ResponsableInventaire getResponsableInv(){
        return this.responsableInv;
    }
    public void setResponsableInv(ResponsableInventaire responsableInv){
        this.responsableInv = responsableInv;
    }
    @OneToMany(mappedBy = "inventaire")

    public List<InventaireDetail> getInventaireDetails(){
        return this.inventaireDetails;
    }
    public void setInventaireDetails(List<InventaireDetail> inventaireDetails){
        this.inventaireDetails = inventaireDetails;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventaire inventaire = (Inventaire) o;
        return id != null && id.equals(inventaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

