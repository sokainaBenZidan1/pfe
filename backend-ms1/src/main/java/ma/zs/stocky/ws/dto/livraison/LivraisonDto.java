package  ma.zs.stocky.ws.dto.livraison;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.stock.MagasinDto;
import ma.zs.stocky.ws.dto.reception.ReceptionDto;
import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LivraisonDto  extends AuditBaseDto {

    private String ref  ;
    private String datelivraison ;

    private ReceptionDto reception ;

    private List<LivraisonDetailDto> livraisonDetails ;


    public LivraisonDto(){
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
    public String getDatelivraison(){
        return this.datelivraison;
    }
    public void setDatelivraison(String datelivraison){
        this.datelivraison = datelivraison;
    }


    public ReceptionDto getReception(){
        return this.reception;
    }

    public void setReception(ReceptionDto reception){
        this.reception = reception;
    }



    public List<LivraisonDetailDto> getLivraisonDetails(){
        return this.livraisonDetails;
    }

    public void setLivraisonDetails(List<LivraisonDetailDto> livraisonDetails){
        this.livraisonDetails = livraisonDetails;
    }



}
