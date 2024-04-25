package  ma.zs.stocky.ws.dto.achat;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.budget.BudgetDto;
import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatMaterielDto  extends AuditBaseDto {

    private BigDecimal montantTotal  ;
    private String dateAchat ;

    private BudgetDto budget ;
    private TypeAchatMaterielDto typeAchatMateriel ;

    private List<AchatMaterielDetailDto> achatMaterielDetails ;


    public AchatMaterielDto(){
        super();
    }



    @Log
    public BigDecimal getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal){
        this.montantTotal = montantTotal;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAchat(){
        return this.dateAchat;
    }
    public void setDateAchat(String dateAchat){
        this.dateAchat = dateAchat;
    }


    public BudgetDto getBudget(){
        return this.budget;
    }

    public void setBudget(BudgetDto budget){
        this.budget = budget;
    }
    public TypeAchatMaterielDto getTypeAchatMateriel(){
        return this.typeAchatMateriel;
    }

    public void setTypeAchatMateriel(TypeAchatMaterielDto typeAchatMateriel){
        this.typeAchatMateriel = typeAchatMateriel;
    }



    public List<AchatMaterielDetailDto> getAchatMaterielDetails(){
        return this.achatMaterielDetails;
    }

    public void setAchatMaterielDetails(List<AchatMaterielDetailDto> achatMaterielDetails){
        this.achatMaterielDetails = achatMaterielDetails;
    }



}
