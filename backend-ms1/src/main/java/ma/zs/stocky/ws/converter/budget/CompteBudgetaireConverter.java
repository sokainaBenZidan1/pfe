package  ma.zs.stocky.ws.converter.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.ws.dto.budget.CompteBudgetaireDto;

@Component
public class CompteBudgetaireConverter extends AbstractConverter<CompteBudgetaire, CompteBudgetaireDto> {


    public  CompteBudgetaireConverter() {
        super(CompteBudgetaire.class, CompteBudgetaireDto.class);
    }

    @Override
    public CompteBudgetaire toItem(CompteBudgetaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        CompteBudgetaire item = new CompteBudgetaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getMontantMax()))
                item.setMontantMax(dto.getMontantMax());



        return item;
        }
    }

    @Override
    public CompteBudgetaireDto toDto(CompteBudgetaire item) {
        if (item == null) {
            return null;
        } else {
            CompteBudgetaireDto dto = new CompteBudgetaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getMontantMax()))
                dto.setMontantMax(item.getMontantMax());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
