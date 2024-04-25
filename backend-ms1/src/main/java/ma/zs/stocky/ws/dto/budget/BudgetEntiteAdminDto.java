package  ma.zs.stocky.ws.dto.budget;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.EntiteAdminDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BudgetEntiteAdminDto  extends AuditBaseDto {

    private BigDecimal montantEntite  ;
    private BigDecimal montantInvEntite  ;
    private BigDecimal montantFctEntite  ;

    private EntiteAdminDto entiteAdmin ;
    private BudgetDto budget ;



    public BudgetEntiteAdminDto(){
        super();
    }



    @Log
    public BigDecimal getMontantEntite(){
        return this.montantEntite;
    }
    public void setMontantEntite(BigDecimal montantEntite){
        this.montantEntite = montantEntite;
    }

    @Log
    public BigDecimal getMontantInvEntite(){
        return this.montantInvEntite;
    }
    public void setMontantInvEntite(BigDecimal montantInvEntite){
        this.montantInvEntite = montantInvEntite;
    }

    @Log
    public BigDecimal getMontantFctEntite(){
        return this.montantFctEntite;
    }
    public void setMontantFctEntite(BigDecimal montantFctEntite){
        this.montantFctEntite = montantFctEntite;
    }


    public EntiteAdminDto getEntiteAdmin(){
        return this.entiteAdmin;
    }

    public void setEntiteAdmin(EntiteAdminDto entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public BudgetDto getBudget(){
        return this.budget;
    }

    public void setBudget(BudgetDto budget){
        this.budget = budget;
    }






}
