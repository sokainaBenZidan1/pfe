package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.commun.EmployeConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.ws.dto.commun.EntiteAdminDto;

@Component
public class EntiteAdminConverter extends AbstractConverter<EntiteAdmin, EntiteAdminDto> {

    @Autowired
    private EmployeConverter employeConverter ;
    private boolean employe;

    public  EntiteAdminConverter() {
        super(EntiteAdmin.class, EntiteAdminDto.class);
        init(true);
    }

    @Override
    public EntiteAdmin toItem(EntiteAdminDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntiteAdmin item = new EntiteAdmin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());

            if(this.employe && ListUtil.isNotEmpty(dto.getEmploye()))
                item.setEmploye(employeConverter.toItem(dto.getEmploye()));


        return item;
        }
    }

    @Override
    public EntiteAdminDto toDto(EntiteAdmin item) {
        if (item == null) {
            return null;
        } else {
            EntiteAdminDto dto = new EntiteAdminDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.employe && ListUtil.isNotEmpty(item.getEmploye())){
            employeConverter.init(true);
            employeConverter.setEntiteAdmin(false);
            dto.setEmploye(employeConverter.toDto(item.getEmploye()));
            employeConverter.setEntiteAdmin(true);

        }


        return dto;
        }
    }

    public void copy(EntiteAdminDto dto, EntiteAdmin t) {
    super.copy(dto, t);
    if (dto.getEmploye() != null)
        t.setEmploye(employeConverter.copy(dto.getEmploye()));
    }


    public void initList(boolean value) {
        this.employe = value;
    }

    public void initObject(boolean value) {
    }


    public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
    }
    public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
    }
    public boolean  isEmploye(){
        return this.employe ;
    }
    public void  setEmploye(boolean employe ){
        this.employe  = employe ;
    }
}
