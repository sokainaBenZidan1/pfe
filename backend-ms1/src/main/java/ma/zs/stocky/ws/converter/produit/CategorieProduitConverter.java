package  ma.zs.stocky.ws.converter.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.budget.CompteBudgetaireConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.ws.dto.produit.CategorieProduitDto;

@Component
public class CategorieProduitConverter extends AbstractConverter<CategorieProduit, CategorieProduitDto> {

    @Autowired
    private CompteBudgetaireConverter compteBudgetaireConverter ;
    private boolean compteBudgetaire;

    public  CategorieProduitConverter() {
        super(CategorieProduit.class, CategorieProduitDto.class);
        init(true);
    }

    @Override
    public CategorieProduit toItem(CategorieProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieProduit item = new CategorieProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.compteBudgetaire && dto.getCompteBudgetaire()!=null)
                item.setCompteBudgetaire(compteBudgetaireConverter.toItem(dto.getCompteBudgetaire())) ;




        return item;
        }
    }

    @Override
    public CategorieProduitDto toDto(CategorieProduit item) {
        if (item == null) {
            return null;
        } else {
            CategorieProduitDto dto = new CategorieProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(this.compteBudgetaire && item.getCompteBudgetaire()!=null) {
                dto.setCompteBudgetaire(compteBudgetaireConverter.toDto(item.getCompteBudgetaire())) ;

            }


        return dto;
        }
    }

    public void copy(CategorieProduitDto dto, CategorieProduit t) {
    super.copy(dto, t);
    if (dto.getCompteBudgetaire() != null)
        compteBudgetaireConverter.copy(dto.getCompteBudgetaire(), t.getCompteBudgetaire());
    }



    public void initObject(boolean value) {
        this.compteBudgetaire = value;
    }


    public CompteBudgetaireConverter getCompteBudgetaireConverter(){
        return this.compteBudgetaireConverter;
    }
    public void setCompteBudgetaireConverter(CompteBudgetaireConverter compteBudgetaireConverter ){
        this.compteBudgetaireConverter = compteBudgetaireConverter;
    }
    public boolean  isCompteBudgetaire(){
        return this.compteBudgetaire;
    }
    public void  setCompteBudgetaire(boolean compteBudgetaire){
        this.compteBudgetaire = compteBudgetaire;
    }
}
