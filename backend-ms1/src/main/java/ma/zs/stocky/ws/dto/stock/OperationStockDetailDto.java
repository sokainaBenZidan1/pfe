package  ma.zs.stocky.ws.dto.stock;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationStockDetailDto  extends AuditBaseDto {

    private BigDecimal qte  ;

    private ProduitDto produit ;
    private OperationStockDto operationStock ;



    public OperationStockDetailDto(){
        super();
    }



    @Log
    public BigDecimal getQte(){
        return this.qte;
    }
    public void setQte(BigDecimal qte){
        this.qte = qte;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public OperationStockDto getOperationStock(){
        return this.operationStock;
    }

    public void setOperationStock(OperationStockDto operationStock){
        this.operationStock = operationStock;
    }






}
