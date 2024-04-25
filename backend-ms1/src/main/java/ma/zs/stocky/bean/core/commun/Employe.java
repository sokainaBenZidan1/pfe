package ma.zs.stocky.bean.core.commun;

import java.util.Objects;





import ma.zs.stocky.bean.core.commun.EntiteAdmin;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "employe")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="employe_seq",sequenceName="employe_seq",allocationSize=1, initialValue = 1)
public class Employe   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;

    private EntiteAdmin entiteAdmin ;


    public Employe(){
        super();
    }

    public Employe(Long id){
        this.id = id;
    }

    public Employe(Long id,String nom){
        this.id = id;
        this.nom = nom ;
    }
    public Employe(String nom){
        this.nom = nom ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="employe_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_admin")
    public EntiteAdmin getEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void setEntiteAdmin(EntiteAdmin entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }

    @Transient
    public String getLabel() {
        label = nom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id != null && id.equals(employe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

