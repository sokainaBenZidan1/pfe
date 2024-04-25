package ma.zs.stocky.bean.core.mandat;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.bean.core.mandat.Responsabilite;
import ma.zs.stocky.bean.core.commun.Employe;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "mandat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="mandat_seq",sequenceName="mandat_seq",allocationSize=1, initialValue = 1)
public class Mandat   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;

    private Employe employe ;
    private Responsabilite responsabilite ;
    private EntiteAdmin entiteAdmin ;


    public Mandat(){
        super();
    }

    public Mandat(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="mandat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employe")
    public Employe getEmploye(){
        return this.employe;
    }
    public void setEmploye(Employe employe){
        this.employe = employe;
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
    @JoinColumn(name = "responsabilite")
    public Responsabilite getResponsabilite(){
        return this.responsabilite;
    }
    public void setResponsabilite(Responsabilite responsabilite){
        this.responsabilite = responsabilite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_admin")
    public EntiteAdmin getEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void setEntiteAdmin(EntiteAdmin entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mandat mandat = (Mandat) o;
        return id != null && id.equals(mandat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

