package  ma.zs.stocky.ws.converter.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;
import ma.zs.stocky.ws.converter.budget.BudgetConverter;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.bean.core.budget.Budget;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import ma.zs.stocky.ws.dto.budget.BudgetEntiteAdminDto;

@Component
public class BudgetEntiteAdminConverter extends AbstractConverter<BudgetEntiteAdmin, BudgetEntiteAdminDto> {

    @Autowired
    private EntiteAdminConverter entiteAdminConverter ;
    @Autowired
    private BudgetConverter budgetConverter ;
    private boolean entiteAdmin;
    private boolean budget;

    public  BudgetEntiteAdminConverter() {
        super(BudgetEntiteAdmin.class, BudgetEntiteAdminDto.class);
        init(true);
    }

    @Override
    public BudgetEntiteAdmin toItem(BudgetEntiteAdminDto dto) {
        if (dto == null) {
            return null;
        } else {
        BudgetEntiteAdmin item = new BudgetEntiteAdmin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontantEntite()))
                item.setMontantEntite(dto.getMontantEntite());
            if(StringUtil.isNotEmpty(dto.getMontantInvEntite()))
                item.setMontantInvEntite(dto.getMontantInvEntite());
            if(StringUtil.isNotEmpty(dto.getMontantFctEntite()))
                item.setMontantFctEntite(dto.getMontantFctEntite());
            if(dto.getEntiteAdmin() != null && dto.getEntiteAdmin().getId() != null){
                item.setEntiteAdmin(new EntiteAdmin());
                item.getEntiteAdmin().setId(dto.getEntiteAdmin().getId());
                item.getEntiteAdmin().setLibelle(dto.getEntiteAdmin().getLibelle());
            }

            if(dto.getBudget() != null && dto.getBudget().getId() != null){
                item.setBudget(new Budget());
                item.getBudget().setId(dto.getBudget().getId());
                item.getBudget().setId(dto.getBudget().getId());
            }




        return item;
        }
    }

    @Override
    public BudgetEntiteAdminDto toDto(BudgetEntiteAdmin item) {
        if (item == null) {
            return null;
        } else {
            BudgetEntiteAdminDto dto = new BudgetEntiteAdminDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontantEntite()))
                dto.setMontantEntite(item.getMontantEntite());
            if(StringUtil.isNotEmpty(item.getMontantInvEntite()))
                dto.setMontantInvEntite(item.getMontantInvEntite());
            if(StringUtil.isNotEmpty(item.getMontantFctEntite()))
                dto.setMontantFctEntite(item.getMontantFctEntite());
            if(this.entiteAdmin && item.getEntiteAdmin()!=null) {
                dto.setEntiteAdmin(entiteAdminConverter.toDto(item.getEntiteAdmin())) ;

            }
            if(this.budget && item.getBudget()!=null) {
                dto.setBudget(budgetConverter.toDto(item.getBudget())) ;

            }


        return dto;
        }
    }

    public void copy(BudgetEntiteAdminDto dto, BudgetEntiteAdmin t) {
    super.copy(dto, t);
    if (dto.getEntiteAdmin() != null)
        entiteAdminConverter.copy(dto.getEntiteAdmin(), t.getEntiteAdmin());
    if (dto.getBudget() != null)
        budgetConverter.copy(dto.getBudget(), t.getBudget());
    }



    public void initObject(boolean value) {
        this.entiteAdmin = value;
        this.budget = value;
    }


    public EntiteAdminConverter getEntiteAdminConverter(){
        return this.entiteAdminConverter;
    }
    public void setEntiteAdminConverter(EntiteAdminConverter entiteAdminConverter ){
        this.entiteAdminConverter = entiteAdminConverter;
    }
    public BudgetConverter getBudgetConverter(){
        return this.budgetConverter;
    }
    public void setBudgetConverter(BudgetConverter budgetConverter ){
        this.budgetConverter = budgetConverter;
    }
    public boolean  isEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void  setEntiteAdmin(boolean entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public boolean  isBudget(){
        return this.budget;
    }
    public void  setBudget(boolean budget){
        this.budget = budget;
    }
}
