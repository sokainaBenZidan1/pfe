package  ma.zs.stocky.ws.converter.achat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.achat.TypeAchatMaterielConverter;
import ma.zs.stocky.ws.converter.budget.BudgetConverter;
import ma.zs.stocky.ws.converter.achat.AchatMaterielDetailConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.budget.Budget;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.ws.dto.achat.AchatMaterielDto;

@Component
public class AchatMaterielConverter extends AbstractConverter<AchatMateriel, AchatMaterielDto> {

    @Autowired
    private TypeAchatMaterielConverter typeAchatMaterielConverter ;
    @Autowired
    private BudgetConverter budgetConverter ;
    @Autowired
    private AchatMaterielDetailConverter achatMaterielDetailConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean budget;
    private boolean typeAchatMateriel;
    private boolean achatMaterielDetails;

    public  AchatMaterielConverter() {
        super(AchatMateriel.class, AchatMaterielDto.class);
        init(true);
    }

    @Override
    public AchatMateriel toItem(AchatMaterielDto dto) {
        if (dto == null) {
            return null;
        } else {
        AchatMateriel item = new AchatMateriel();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontantTotal()))
                item.setMontantTotal(dto.getMontantTotal());
            if(StringUtil.isNotEmpty(dto.getDateAchat()))
                item.setDateAchat(DateUtil.stringEnToDate(dto.getDateAchat()));
            if(dto.getBudget() != null && dto.getBudget().getId() != null){
                item.setBudget(new Budget());
                item.getBudget().setId(dto.getBudget().getId());
                item.getBudget().setId(dto.getBudget().getId());
            }

            if(this.typeAchatMateriel && dto.getTypeAchatMateriel()!=null)
                item.setTypeAchatMateriel(typeAchatMaterielConverter.toItem(dto.getTypeAchatMateriel())) ;


            if(this.achatMaterielDetails && ListUtil.isNotEmpty(dto.getAchatMaterielDetails()))
                item.setAchatMaterielDetails(achatMaterielDetailConverter.toItem(dto.getAchatMaterielDetails()));


        return item;
        }
    }

    @Override
    public AchatMaterielDto toDto(AchatMateriel item) {
        if (item == null) {
            return null;
        } else {
            AchatMaterielDto dto = new AchatMaterielDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontantTotal()))
                dto.setMontantTotal(item.getMontantTotal());
            if(item.getDateAchat()!=null)
                dto.setDateAchat(DateUtil.dateTimeToString(item.getDateAchat()));
            if(this.budget && item.getBudget()!=null) {
                dto.setBudget(budgetConverter.toDto(item.getBudget())) ;

            }
            if(this.typeAchatMateriel && item.getTypeAchatMateriel()!=null) {
                dto.setTypeAchatMateriel(typeAchatMaterielConverter.toDto(item.getTypeAchatMateriel())) ;

            }
        if(this.achatMaterielDetails && ListUtil.isNotEmpty(item.getAchatMaterielDetails())){
            achatMaterielDetailConverter.init(true);
            achatMaterielDetailConverter.setAchatMateriel(false);
            dto.setAchatMaterielDetails(achatMaterielDetailConverter.toDto(item.getAchatMaterielDetails()));
            achatMaterielDetailConverter.setAchatMateriel(true);

        }


        return dto;
        }
    }

    public void copy(AchatMaterielDto dto, AchatMateriel t) {
    super.copy(dto, t);
    if (dto.getBudget() != null)
        budgetConverter.copy(dto.getBudget(), t.getBudget());
    if (dto.getTypeAchatMateriel() != null)
        typeAchatMaterielConverter.copy(dto.getTypeAchatMateriel(), t.getTypeAchatMateriel());
    if (dto.getAchatMaterielDetails() != null)
        t.setAchatMaterielDetails(achatMaterielDetailConverter.copy(dto.getAchatMaterielDetails()));
    }


    public void initList(boolean value) {
        this.achatMaterielDetails = value;
    }

    public void initObject(boolean value) {
        this.budget = value;
        this.typeAchatMateriel = value;
    }


    public TypeAchatMaterielConverter getTypeAchatMaterielConverter(){
        return this.typeAchatMaterielConverter;
    }
    public void setTypeAchatMaterielConverter(TypeAchatMaterielConverter typeAchatMaterielConverter ){
        this.typeAchatMaterielConverter = typeAchatMaterielConverter;
    }
    public BudgetConverter getBudgetConverter(){
        return this.budgetConverter;
    }
    public void setBudgetConverter(BudgetConverter budgetConverter ){
        this.budgetConverter = budgetConverter;
    }
    public AchatMaterielDetailConverter getAchatMaterielDetailConverter(){
        return this.achatMaterielDetailConverter;
    }
    public void setAchatMaterielDetailConverter(AchatMaterielDetailConverter achatMaterielDetailConverter ){
        this.achatMaterielDetailConverter = achatMaterielDetailConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isBudget(){
        return this.budget;
    }
    public void  setBudget(boolean budget){
        this.budget = budget;
    }
    public boolean  isTypeAchatMateriel(){
        return this.typeAchatMateriel;
    }
    public void  setTypeAchatMateriel(boolean typeAchatMateriel){
        this.typeAchatMateriel = typeAchatMateriel;
    }
    public boolean  isAchatMaterielDetails(){
        return this.achatMaterielDetails ;
    }
    public void  setAchatMaterielDetails(boolean achatMaterielDetails ){
        this.achatMaterielDetails  = achatMaterielDetails ;
    }
}
