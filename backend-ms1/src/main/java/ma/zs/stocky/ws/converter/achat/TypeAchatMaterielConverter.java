package  ma.zs.stocky.ws.converter.achat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.ws.dto.achat.TypeAchatMaterielDto;

@Component
public class TypeAchatMaterielConverter extends AbstractConverter<TypeAchatMateriel, TypeAchatMaterielDto> {


    public  TypeAchatMaterielConverter() {
        super(TypeAchatMateriel.class, TypeAchatMaterielDto.class);
    }

    @Override
    public TypeAchatMateriel toItem(TypeAchatMaterielDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeAchatMateriel item = new TypeAchatMateriel();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public TypeAchatMaterielDto toDto(TypeAchatMateriel item) {
        if (item == null) {
            return null;
        } else {
            TypeAchatMaterielDto dto = new TypeAchatMaterielDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
