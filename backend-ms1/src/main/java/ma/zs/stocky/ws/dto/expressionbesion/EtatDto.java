package  ma.zs.stocky.ws.dto.expressionbesion;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtatDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;




    public EtatDto(){
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








}
