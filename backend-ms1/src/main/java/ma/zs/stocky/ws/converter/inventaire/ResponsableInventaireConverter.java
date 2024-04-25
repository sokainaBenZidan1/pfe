package  ma.zs.stocky.ws.converter.inventaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.ws.dto.inventaire.ResponsableInventaireDto;

@Component
public class ResponsableInventaireConverter extends AbstractConverter<ResponsableInventaire, ResponsableInventaireDto> {


    public  ResponsableInventaireConverter() {
        super(ResponsableInventaire.class, ResponsableInventaireDto.class);
    }

    @Override
    public ResponsableInventaire toItem(ResponsableInventaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        ResponsableInventaire item = new ResponsableInventaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getLogin()))
                item.setLogin(dto.getLogin());
            if(StringUtil.isNotEmpty(dto.getMdp()))
                item.setMdp(dto.getMdp());



        return item;
        }
    }

    @Override
    public ResponsableInventaireDto toDto(ResponsableInventaire item) {
        if (item == null) {
            return null;
        } else {
            ResponsableInventaireDto dto = new ResponsableInventaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getLogin()))
                dto.setLogin(item.getLogin());
            if(StringUtil.isNotEmpty(item.getMdp()))
                dto.setMdp(item.getMdp());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
