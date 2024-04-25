package ma.zs.stocky.bean.core.expressionbesion;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.bean.core.expressionbesion.Etat;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.bean.core.commun.Employe;
import ma.zs.stocky.bean.core.produit.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "expression_besoin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="expression_besoin_seq",sequenceName="expression_besoin_seq",allocationSize=1, initialValue = 1)
public class ExpressionBesoin   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String description;
    private LocalDateTime dateExpression ;

    private Employe employe ;
    private EntiteAdmin entiteAdmin ;
    private Etat etat ;

    private List<ExpressionBesoinDetail> expressionBesoinDetails ;

    public ExpressionBesoin(){
        super();
    }

    public ExpressionBesoin(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="expression_besoin_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_admin")
    public EntiteAdmin getEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void setEntiteAdmin(EntiteAdmin entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public LocalDateTime getDateExpression(){
        return this.dateExpression;
    }
    public void setDateExpression(LocalDateTime dateExpression){
        this.dateExpression = dateExpression;
    }
    @OneToMany(mappedBy = "expressionBesoin")

    public List<ExpressionBesoinDetail> getExpressionBesoinDetails(){
        return this.expressionBesoinDetails;
    }
    public void setExpressionBesoinDetails(List<ExpressionBesoinDetail> expressionBesoinDetails){
        this.expressionBesoinDetails = expressionBesoinDetails;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat")
    public Etat getEtat(){
        return this.etat;
    }
    public void setEtat(Etat etat){
        this.etat = etat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionBesoin expressionBesoin = (ExpressionBesoin) o;
        return id != null && id.equals(expressionBesoin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

