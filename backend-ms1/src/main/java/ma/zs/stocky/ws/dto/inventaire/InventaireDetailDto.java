package  ma.zs.stocky.ws.dto.inventaire;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireDetailDto  extends AuditBaseDto {

    private BigDecimal qteCalculee  ;
    private BigDecimal qteStock  ;
    private BigDecimal ecart  ;
    private String magasin  ;

    private ProduitDto produit ;
    private InventaireDto inventaire ;



    public InventaireDetailDto(){
        super();
    }



    @Log
    public BigDecimal getQteCalculee(){
        return this.qteCalculee;
    }
    public void setQteCalculee(BigDecimal qteCalculee){
        this.qteCalculee = qteCalculee;
    }

    @Log
    public BigDecimal getQteStock(){
        return this.qteStock;
    }
    public void setQteStock(BigDecimal qteStock){
        this.qteStock = qteStock;
    }

    @Log
    public BigDecimal getEcart(){
        return this.ecart;
    }
    public void setEcart(BigDecimal ecart){
        this.ecart = ecart;
    }

    @Log
    public String getMagasin(){
        return this.magasin;
    }
    public void setMagasin(String magasin){
        this.magasin = magasin;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public InventaireDto getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(InventaireDto inventaire){
        this.inventaire = inventaire;
    }






}
