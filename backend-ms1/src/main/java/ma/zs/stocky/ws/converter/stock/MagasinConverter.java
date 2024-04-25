package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.ws.dto.stock.MagasinDto;

@Component
public class MagasinConverter extends AbstractConverter<Magasin, MagasinDto> {


    public  MagasinConverter() {
        super(Magasin.class, MagasinDto.class);
    }

    @Override
    public Magasin toItem(MagasinDto dto) {
        if (dto == null) {
            return null;
        } else {
        Magasin item = new Magasin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());



        return item;
        }
    }

    @Override
    public MagasinDto toDto(Magasin item) {
        if (item == null) {
            return null;
        } else {
            MagasinDto dto = new MagasinDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
