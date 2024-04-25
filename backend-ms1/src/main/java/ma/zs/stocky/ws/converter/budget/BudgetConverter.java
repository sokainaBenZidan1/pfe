package  ma.zs.stocky.ws.converter.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;
import ma.zs.stocky.ws.converter.budget.BudgetEntiteAdminConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.budget.Budget;
import ma.zs.stocky.ws.dto.budget.BudgetDto;

@Component
public class BudgetConverter extends AbstractConverter<Budget, BudgetDto> {

    @Autowired
    private EntiteAdminConverter entiteAdminConverter ;
    @Autowired
    private BudgetEntiteAdminConverter budgetEntiteAdminConverter ;
    private boolean budgetEntiteAdmins;

    public  BudgetConverter() {
        super(Budget.class, BudgetDto.class);
        init(true);
    }

    @Override
    public Budget toItem(BudgetDto dto) {
        if (dto == null) {
            return null;
        } else {
        Budget item = new Budget();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateBudget()))
                item.setDateBudget(DateUtil.stringEnToDate(dto.getDateBudget()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getMontantInvestissement()))
                item.setMontantInvestissement(dto.getMontantInvestissement());
            if(StringUtil.isNotEmpty(dto.getMontantFonction()))
                item.setMontantFonction(dto.getMontantFonction());

            if(this.budgetEntiteAdmins && ListUtil.isNotEmpty(dto.getBudgetEntiteAdmins()))
                item.setBudgetEntiteAdmins(budgetEntiteAdminConverter.toItem(dto.getBudgetEntiteAdmins()));


        return item;
        }
    }

    @Override
    public BudgetDto toDto(Budget item) {
        if (item == null) {
            return null;
        } else {
            BudgetDto dto = new BudgetDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateBudget()!=null)
                dto.setDateBudget(DateUtil.dateTimeToString(item.getDateBudget()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getMontantInvestissement()))
                dto.setMontantInvestissement(item.getMontantInvestissement());
            if(StringUtil.isNotEmpty(item.getMontantFonction()))
                dto.setMontantFonction(item.getMontantFonction());
        if(this.budgetEntiteAdmins && ListUtil.isNotEmpty(item.getBudgetEntiteAdmins())){
            budgetEntiteAdminConverter.init(true);
            budgetEntiteAdminConverter.setBudget(false);
            dto.setBudgetEntiteAdmins(budgetEntiteAdminConverter.toDto(item.getBudgetEntiteAdmins()));
            budgetEntiteAdminConverter.setBudget(true);

        }


        return dto;
        }
    }

    public void copy(BudgetDto dto, Budget t) {
    super.copy(dto, t);
    if (dto.getBudgetEntiteAdmins() != null)
        t.setBudgetEntiteAdmins(budgetEntiteAdminConverter.copy(dto.getBudgetEntiteAdmins()));
    }


    public void initList(boolean value) {
        this.budgetEntiteAdmins = value;
    }

    public void initObject(boolean value) {
    }


    public EntiteAdminConverter getEntiteAdminConverter(){
        return this.entiteAdminConverter;
    }
    public void setEntiteAdminConverter(EntiteAdminConverter entiteAdminConverter ){
        this.entiteAdminConverter = entiteAdminConverter;
    }
    public BudgetEntiteAdminConverter getBudgetEntiteAdminConverter(){
        return this.budgetEntiteAdminConverter;
    }
    public void setBudgetEntiteAdminConverter(BudgetEntiteAdminConverter budgetEntiteAdminConverter ){
        this.budgetEntiteAdminConverter = budgetEntiteAdminConverter;
    }
    public boolean  isBudgetEntiteAdmins(){
        return this.budgetEntiteAdmins ;
    }
    public void  setBudgetEntiteAdmins(boolean budgetEntiteAdmins ){
        this.budgetEntiteAdmins  = budgetEntiteAdmins ;
    }
}
