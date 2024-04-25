package  ma.zs.stocky.ws.dto.stock;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockDto  extends AuditBaseDto {

    private BigDecimal qte  ;
    private BigDecimal qteDeffectueuse  ;

    private MagasinDto magasin ;
    private ProduitDto produit ;



    public StockDto(){
        super();
    }



    @Log
    public BigDecimal getQte(){
        return this.qte;
    }
    public void setQte(BigDecimal qte){
        this.qte = qte;
    }

    @Log
    public BigDecimal getQteDeffectueuse(){
        return this.qteDeffectueuse;
    }
    public void setQteDeffectueuse(BigDecimal qteDeffectueuse){
        this.qteDeffectueuse = qteDeffectueuse;
    }


    public MagasinDto getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinDto magasin){
        this.magasin = magasin;
    }
    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }






}
