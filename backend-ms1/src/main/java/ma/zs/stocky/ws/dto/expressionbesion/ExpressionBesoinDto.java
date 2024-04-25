package  ma.zs.stocky.ws.dto.expressionbesion;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.commun.EntiteAdminDto;
import ma.zs.stocky.ws.dto.commun.EmployeDto;
import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpressionBesoinDto  extends AuditBaseDto {

    private String description  ;
    private String dateExpression ;

    private EmployeDto employe ;
    private EntiteAdminDto entiteAdmin ;
    private EtatDto etat ;

    private List<ExpressionBesoinDetailDto> expressionBesoinDetails ;


    public ExpressionBesoinDto(){
        super();
    }



    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateExpression(){
        return this.dateExpression;
    }
    public void setDateExpression(String dateExpression){
        this.dateExpression = dateExpression;
    }


    public EmployeDto getEmploye(){
        return this.employe;
    }

    public void setEmploye(EmployeDto employe){
        this.employe = employe;
    }
    public EntiteAdminDto getEntiteAdmin(){
        return this.entiteAdmin;
    }

    public void setEntiteAdmin(EntiteAdminDto entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public EtatDto getEtat(){
        return this.etat;
    }

    public void setEtat(EtatDto etat){
        this.etat = etat;
    }



    public List<ExpressionBesoinDetailDto> getExpressionBesoinDetails(){
        return this.expressionBesoinDetails;
    }

    public void setExpressionBesoinDetails(List<ExpressionBesoinDetailDto> expressionBesoinDetails){
        this.expressionBesoinDetails = expressionBesoinDetails;
    }



}
