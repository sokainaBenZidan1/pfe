package ma.zs.stocky.bean.core.expressionbesion;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_seq",sequenceName="etat_seq",allocationSize=1, initialValue = 1)
public class Etat   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public Etat(){
        super();
    }

    public Etat(Long id){
        this.id = id;
    }

    public Etat(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Etat(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etat etat = (Etat) o;
        return id != null && id.equals(etat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

