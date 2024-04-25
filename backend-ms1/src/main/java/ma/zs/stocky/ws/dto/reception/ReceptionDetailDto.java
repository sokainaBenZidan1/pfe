package  ma.zs.stocky.ws.dto.reception;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.stock.MagasinDto;
import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceptionDetailDto  extends AuditBaseDto {

    private BigDecimal qte  ;

    private MagasinDto magasin ;
    private ProduitDto produit ;
    private ReceptionDto reception ;



    public ReceptionDetailDto(){
        super();
    }



    @Log
    public BigDecimal getQte(){
        return this.qte;
    }
    public void setQte(BigDecimal qte){
        this.qte = qte;
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
    public ReceptionDto getReception(){
        return this.reception;
    }

    public void setReception(ReceptionDto reception){
        this.reception = reception;
    }






}
