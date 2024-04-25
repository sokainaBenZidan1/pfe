package ma.zs.stocky.bean.core.achat;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "type_achat_materiel")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_achat_materiel_seq",sequenceName="type_achat_materiel_seq",allocationSize=1, initialValue = 1)
public class TypeAchatMateriel   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public TypeAchatMateriel(){
        super();
    }

    public TypeAchatMateriel(Long id){
        this.id = id;
    }

    public TypeAchatMateriel(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeAchatMateriel(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_achat_materiel_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
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
        TypeAchatMateriel typeAchatMateriel = (TypeAchatMateriel) o;
        return id != null && id.equals(typeAchatMateriel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

