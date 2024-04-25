package ma.zs.stocky.bean.core.inventaire;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "responsable_inventaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="responsable_inventaire_seq",sequenceName="responsable_inventaire_seq",allocationSize=1, initialValue = 1)
public class ResponsableInventaire   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String login;
    @Column(length = 500)
    private String mdp;



    public ResponsableInventaire(){
        super();
    }

    public ResponsableInventaire(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="responsable_inventaire_seq")
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
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getMdp(){
        return this.mdp;
    }
    public void setMdp(String mdp){
        this.mdp = mdp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsableInventaire responsableInventaire = (ResponsableInventaire) o;
        return id != null && id.equals(responsableInventaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

