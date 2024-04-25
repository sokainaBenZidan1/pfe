package  ma.zs.stocky.ws.dto.expressionbesion;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpressionBesoinDetailDto  extends AuditBaseDto {

    private BigDecimal qteDemandee  ;
    private BigDecimal qteAccordee  ;
    private BigDecimal qteLivre  ;

    private ExpressionBesoinDto expressionBesoin ;
    private ProduitDto produit ;



    public ExpressionBesoinDetailDto(){
        super();
    }



    @Log
    public BigDecimal getQteDemandee(){
        return this.qteDemandee;
    }
    public void setQteDemandee(BigDecimal qteDemandee){
        this.qteDemandee = qteDemandee;
    }

    @Log
    public BigDecimal getQteAccordee(){
        return this.qteAccordee;
    }
    public void setQteAccordee(BigDecimal qteAccordee){
        this.qteAccordee = qteAccordee;
    }

    @Log
    public BigDecimal getQteLivre(){
        return this.qteLivre;
    }
    public void setQteLivre(BigDecimal qteLivre){
        this.qteLivre = qteLivre;
    }


    public ExpressionBesoinDto getExpressionBesoin(){
        return this.expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoinDto expressionBesoin){
        this.expressionBesoin = expressionBesoin;
    }
    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }






}
