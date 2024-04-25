package  ma.zs.stocky.ws.dto.commun;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntiteAdminDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;


    private List<EmployeDto> employe ;


    public EntiteAdminDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }





    public List<EmployeDto> getEmploye(){
        return this.employe;
    }

    public void setEmploye(List<EmployeDto> employe){
        this.employe = employe;
    }



}
