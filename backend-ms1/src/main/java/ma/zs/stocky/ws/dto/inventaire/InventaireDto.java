package  ma.zs.stocky.ws.dto.inventaire;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireDto  extends AuditBaseDto {

    private String dateDebut ;
    private String dateFin ;

    private ResponsableInventaireDto responsableInv ;

    private List<InventaireDetailDto> inventaireDetails ;


    public InventaireDto(){
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


    public ResponsableInventaireDto getResponsableInv(){
        return this.responsableInv;
    }

    public void setResponsableInv(ResponsableInventaireDto responsableInv){
        this.responsableInv = responsableInv;
    }



    public List<InventaireDetailDto> getInventaireDetails(){
        return this.inventaireDetails;
    }

    public void setInventaireDetails(List<InventaireDetailDto> inventaireDetails){
        this.inventaireDetails = inventaireDetails;
    }



}
