package  ma.zs.stocky.ws.converter.mandat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;
import ma.zs.stocky.ws.converter.mandat.ResponsabiliteConverter;
import ma.zs.stocky.ws.converter.commun.EmployeConverter;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.mandat.Mandat;
import ma.zs.stocky.ws.dto.mandat.MandatDto;

@Component
public class MandatConverter extends AbstractConverter<Mandat, MandatDto> {

    @Autowired
    private EntiteAdminConverter entiteAdminConverter ;
    @Autowired
    private ResponsabiliteConverter responsabiliteConverter ;
    @Autowired
    private EmployeConverter employeConverter ;
    private boolean employe;
    private boolean responsabilite;
    private boolean entiteAdmin;

    public  MandatConverter() {
        super(Mandat.class, MandatDto.class);
        init(true);
    }

    @Override
    public Mandat toItem(MandatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Mandat item = new Mandat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(this.employe && dto.getEmploye()!=null)
                item.setEmploye(employeConverter.toItem(dto.getEmploye())) ;

            if(this.responsabilite && dto.getResponsabilite()!=null)
                item.setResponsabilite(responsabiliteConverter.toItem(dto.getResponsabilite())) ;

            if(dto.getEntiteAdmin() != null && dto.getEntiteAdmin().getId() != null){
                item.setEntiteAdmin(new EntiteAdmin());
                item.getEntiteAdmin().setId(dto.getEntiteAdmin().getId());
                item.getEntiteAdmin().setLibelle(dto.getEntiteAdmin().getLibelle());
            }




        return item;
        }
    }

    @Override
    public MandatDto toDto(Mandat item) {
        if (item == null) {
            return null;
        } else {
            MandatDto dto = new MandatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(this.employe && item.getEmploye()!=null) {
                dto.setEmploye(employeConverter.toDto(item.getEmploye())) ;

            }
            if(this.responsabilite && item.getResponsabilite()!=null) {
                dto.setResponsabilite(responsabiliteConverter.toDto(item.getResponsabilite())) ;

            }
            if(this.entiteAdmin && item.getEntiteAdmin()!=null) {
                dto.setEntiteAdmin(entiteAdminConverter.toDto(item.getEntiteAdmin())) ;

            }


        return dto;
        }
    }

    public void copy(MandatDto dto, Mandat t) {
    super.copy(dto, t);
    if (dto.getEmploye() != null)
        employeConverter.copy(dto.getEmploye(), t.getEmploye());
    if (dto.getResponsabilite() != null)
        responsabiliteConverter.copy(dto.getResponsabilite(), t.getResponsabilite());
    if (dto.getEntiteAdmin() != null)
        entiteAdminConverter.copy(dto.getEntiteAdmin(), t.getEntiteAdmin());
    }



    public void initObject(boolean value) {
        this.employe = value;
        this.responsabilite = value;
        this.entiteAdmin = value;
    }


    public EntiteAdminConverter getEntiteAdminConverter(){
        return this.entiteAdminConverter;
    }
    public void setEntiteAdminConverter(EntiteAdminConverter entiteAdminConverter ){
        this.entiteAdminConverter = entiteAdminConverter;
    }
    public ResponsabiliteConverter getResponsabiliteConverter(){
        return this.responsabiliteConverter;
    }
    public void setResponsabiliteConverter(ResponsabiliteConverter responsabiliteConverter ){
        this.responsabiliteConverter = responsabiliteConverter;
    }
    public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
    }
    public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
    }
    public boolean  isEmploye(){
        return this.employe;
    }
    public void  setEmploye(boolean employe){
        this.employe = employe;
    }
    public boolean  isResponsabilite(){
        return this.responsabilite;
    }
    public void  setResponsabilite(boolean responsabilite){
        this.responsabilite = responsabilite;
    }
    public boolean  isEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void  setEntiteAdmin(boolean entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
}
