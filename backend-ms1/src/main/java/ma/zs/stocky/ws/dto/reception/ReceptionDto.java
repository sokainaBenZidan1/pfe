package  ma.zs.stocky.ws.dto.reception;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.stock.MagasinDto;
import ma.zs.stocky.ws.dto.commande.CommandeDto;
import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceptionDto  extends AuditBaseDto {

    private String ref  ;
    private String dateReception ;
    private String libelle  ;

    private CommandeDto commande ;

    private List<ReceptionDetailDto> receptionDetails ;


    public ReceptionDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(String dateReception){
        this.dateReception = dateReception;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    public CommandeDto getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeDto commande){
        this.commande = commande;
    }



    public List<ReceptionDetailDto> getReceptionDetails(){
        return this.receptionDetails;
    }

    public void setReceptionDetails(List<ReceptionDetailDto> receptionDetails){
        this.receptionDetails = receptionDetails;
    }



}
