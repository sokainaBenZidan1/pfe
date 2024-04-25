package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Employe;
import ma.zs.stocky.ws.dto.commun.EmployeDto;

@Component
public class EmployeConverter extends AbstractConverter<Employe, EmployeDto> {

    @Autowired
    private EntiteAdminConverter entiteAdminConverter ;
    private boolean entiteAdmin;

    public  EmployeConverter() {
        super(Employe.class, EmployeDto.class);
        init(true);
    }

    @Override
    public Employe toItem(EmployeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Employe item = new Employe();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(dto.getEntiteAdmin() != null && dto.getEntiteAdmin().getId() != null){
                item.setEntiteAdmin(new EntiteAdmin());
                item.getEntiteAdmin().setId(dto.getEntiteAdmin().getId());
                item.getEntiteAdmin().setLibelle(dto.getEntiteAdmin().getLibelle());
            }




        return item;
        }
    }

    @Override
    public EmployeDto toDto(Employe item) {
        if (item == null) {
            return null;
        } else {
            EmployeDto dto = new EmployeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(this.entiteAdmin && item.getEntiteAdmin()!=null) {
                dto.setEntiteAdmin(entiteAdminConverter.toDto(item.getEntiteAdmin())) ;

            }


        return dto;
        }
    }

    public void copy(EmployeDto dto, Employe t) {
    super.copy(dto, t);
    if (dto.getEntiteAdmin() != null)
        entiteAdminConverter.copy(dto.getEntiteAdmin(), t.getEntiteAdmin());
    }



    public void initObject(boolean value) {
        this.entiteAdmin = value;
    }


    public EntiteAdminConverter getEntiteAdminConverter(){
        return this.entiteAdminConverter;
    }
    public void setEntiteAdminConverter(EntiteAdminConverter entiteAdminConverter ){
        this.entiteAdminConverter = entiteAdminConverter;
    }
    public boolean  isEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void  setEntiteAdmin(boolean entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
}
