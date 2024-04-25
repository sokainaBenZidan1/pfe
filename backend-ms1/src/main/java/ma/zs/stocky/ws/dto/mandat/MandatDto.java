package  ma.zs.stocky.ws.dto.mandat;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.commun.EntiteAdminDto;
import ma.zs.stocky.ws.dto.commun.EmployeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MandatDto  extends AuditBaseDto {

    private String dateDebut ;
    private String dateFin ;

    private EmployeDto employe ;
    private ResponsabiliteDto responsabilite ;
    private EntiteAdminDto entiteAdmin ;



    public MandatDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }


    public EmployeDto getEmploye(){
        return this.employe;
    }

    public void setEmploye(EmployeDto employe){
        this.employe = employe;
    }
    public ResponsabiliteDto getResponsabilite(){
        return this.responsabilite;
    }

    public void setResponsabilite(ResponsabiliteDto responsabilite){
        this.responsabilite = responsabilite;
    }
    public EntiteAdminDto getEntiteAdmin(){
        return this.entiteAdmin;
    }

    public void setEntiteAdmin(EntiteAdminDto entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }






}
