package  ma.zs.stocky.ws.dto.produit;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.stocky.ws.dto.budget.CompteBudgetaireDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieProduitDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;

    private CompteBudgetaireDto compteBudgetaire ;



    public CategorieProduitDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }


    public CompteBudgetaireDto getCompteBudgetaire(){
        return this.compteBudgetaire;
    }

    public void setCompteBudgetaire(CompteBudgetaireDto compteBudgetaire){
        this.compteBudgetaire = compteBudgetaire;
    }






}
