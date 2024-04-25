package  ma.zs.stocky.ws.dto.budget;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.EntiteAdminDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BudgetDto  extends AuditBaseDto {

    private String dateBudget ;
    private BigDecimal montant  ;
    private BigDecimal montantInvestissement  ;
    private BigDecimal montantFonction  ;


    private List<BudgetEntiteAdminDto> budgetEntiteAdmins ;


    public BudgetDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateBudget(){
        return this.dateBudget;
    }
    public void setDateBudget(String dateBudget){
        this.dateBudget = dateBudget;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    public BigDecimal getMontantInvestissement(){
        return this.montantInvestissement;
    }
    public void setMontantInvestissement(BigDecimal montantInvestissement){
        this.montantInvestissement = montantInvestissement;
    }

    @Log
    public BigDecimal getMontantFonction(){
        return this.montantFonction;
    }
    public void setMontantFonction(BigDecimal montantFonction){
        this.montantFonction = montantFonction;
    }





    public List<BudgetEntiteAdminDto> getBudgetEntiteAdmins(){
        return this.budgetEntiteAdmins;
    }

    public void setBudgetEntiteAdmins(List<BudgetEntiteAdminDto> budgetEntiteAdmins){
        this.budgetEntiteAdmins = budgetEntiteAdmins;
    }



}
