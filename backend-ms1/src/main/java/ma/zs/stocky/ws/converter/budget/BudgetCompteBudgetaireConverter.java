package  ma.zs.stocky.ws.converter.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.budget.BudgetConverter;
import ma.zs.stocky.ws.converter.budget.CompteBudgetaireConverter;

import ma.zs.stocky.bean.core.budget.Budget;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import ma.zs.stocky.ws.dto.budget.BudgetCompteBudgetaireDto;

@Component
public class BudgetCompteBudgetaireConverter extends AbstractConverter<BudgetCompteBudgetaire, BudgetCompteBudgetaireDto> {

    @Autowired
    private BudgetConverter budgetConverter ;
    @Autowired
    private CompteBudgetaireConverter compteBudgetaireConverter ;
    private boolean budget;
    private boolean compteBudgetaire;

    public  BudgetCompteBudgetaireConverter() {
        super(BudgetCompteBudgetaire.class, BudgetCompteBudgetaireDto.class);
        init(true);
    }

    @Override
    public BudgetCompteBudgetaire toItem(BudgetCompteBudgetaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        BudgetCompteBudgetaire item = new BudgetCompteBudgetaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(dto.getBudget() != null && dto.getBudget().getId() != null){
                item.setBudget(new Budget());
                item.getBudget().setId(dto.getBudget().getId());
                item.getBudget().setId(dto.getBudget().getId());
            }

            if(this.compteBudgetaire && dto.getCompteBudgetaire()!=null)
                item.setCompteBudgetaire(compteBudgetaireConverter.toItem(dto.getCompteBudgetaire())) ;




        return item;
        }
    }

    @Override
    public BudgetCompteBudgetaireDto toDto(BudgetCompteBudgetaire item) {
        if (item == null) {
            return null;
        } else {
            BudgetCompteBudgetaireDto dto = new BudgetCompteBudgetaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(this.budget && item.getBudget()!=null) {
                dto.setBudget(budgetConverter.toDto(item.getBudget())) ;

            }
            if(this.compteBudgetaire && item.getCompteBudgetaire()!=null) {
                dto.setCompteBudgetaire(compteBudgetaireConverter.toDto(item.getCompteBudgetaire())) ;

            }


        return dto;
        }
    }

    public void copy(BudgetCompteBudgetaireDto dto, BudgetCompteBudgetaire t) {
    super.copy(dto, t);
    if (dto.getBudget() != null)
        budgetConverter.copy(dto.getBudget(), t.getBudget());
    if (dto.getCompteBudgetaire() != null)
        compteBudgetaireConverter.copy(dto.getCompteBudgetaire(), t.getCompteBudgetaire());
    }



    public void initObject(boolean value) {
        this.budget = value;
        this.compteBudgetaire = value;
    }


    public BudgetConverter getBudgetConverter(){
        return this.budgetConverter;
    }
    public void setBudgetConverter(BudgetConverter budgetConverter ){
        this.budgetConverter = budgetConverter;
    }
    public CompteBudgetaireConverter getCompteBudgetaireConverter(){
        return this.compteBudgetaireConverter;
    }
    public void setCompteBudgetaireConverter(CompteBudgetaireConverter compteBudgetaireConverter ){
        this.compteBudgetaireConverter = compteBudgetaireConverter;
    }
    public boolean  isBudget(){
        return this.budget;
    }
    public void  setBudget(boolean budget){
        this.budget = budget;
    }
    public boolean  isCompteBudgetaire(){
        return this.compteBudgetaire;
    }
    public void  setCompteBudgetaire(boolean compteBudgetaire){
        this.compteBudgetaire = compteBudgetaire;
    }
}
