package  ma.zs.stocky.ws.dto.stock;

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
public class OperationStockDto  extends AuditBaseDto {

    private String ref  ;
    private String dateOS ;
    private String discription  ;

    private MagasinDto magasinSource ;
    private MagasinDto magasinDest ;

    private List<OperationStockDetailDto> operationStockDetails ;


    public OperationStockDto(){
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
    public String getDateOS(){
        return this.dateOS;
    }
    public void setDateOS(String dateOS){
        this.dateOS = dateOS;
    }

    @Log
    public String getDiscription(){
        return this.discription;
    }
    public void setDiscription(String discription){
        this.discription = discription;
    }


    public MagasinDto getMagasinSource(){
        return this.magasinSource;
    }

    public void setMagasinSource(MagasinDto magasinSource){
        this.magasinSource = magasinSource;
    }
    public MagasinDto getMagasinDest(){
        return this.magasinDest;
    }

    public void setMagasinDest(MagasinDto magasinDest){
        this.magasinDest = magasinDest;
    }



    public List<OperationStockDetailDto> getOperationStockDetails(){
        return this.operationStockDetails;
    }

    public void setOperationStockDetails(List<OperationStockDetailDto> operationStockDetails){
        this.operationStockDetails = operationStockDetails;
    }



}
