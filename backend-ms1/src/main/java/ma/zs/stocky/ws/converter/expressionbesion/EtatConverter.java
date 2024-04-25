package  ma.zs.stocky.ws.converter.expressionbesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.expressionbesion.Etat;
import ma.zs.stocky.ws.dto.expressionbesion.EtatDto;

@Component
public class EtatConverter extends AbstractConverter<Etat, EtatDto> {


    public  EtatConverter() {
        super(Etat.class, EtatDto.class);
    }

    @Override
    public Etat toItem(EtatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Etat item = new Etat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatDto toDto(Etat item) {
        if (item == null) {
            return null;
        } else {
            EtatDto dto = new EtatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
