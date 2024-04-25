package  ma.zs.stocky.ws.dto.achat;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatMaterielDetailDto  extends AuditBaseDto {

    private BigDecimal qteAchetee  ;
    private BigDecimal qteRecue  ;
    private BigDecimal qteLivree  ;

    private ProduitDto produit ;
    private AchatMaterielDto achatMateriel ;



    public AchatMaterielDetailDto(){
        super();
    }



    @Log
    public BigDecimal getQteAchetee(){
        return this.qteAchetee;
    }
    public void setQteAchetee(BigDecimal qteAchetee){
        this.qteAchetee = qteAchetee;
    }

    @Log
    public BigDecimal getQteRecue(){
        return this.qteRecue;
    }
    public void setQteRecue(BigDecimal qteRecue){
        this.qteRecue = qteRecue;
    }

    @Log
    public BigDecimal getQteLivree(){
        return this.qteLivree;
    }
    public void setQteLivree(BigDecimal qteLivree){
        this.qteLivree = qteLivree;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public AchatMaterielDto getAchatMateriel(){
        return this.achatMateriel;
    }

    public void setAchatMateriel(AchatMaterielDto achatMateriel){
        this.achatMateriel = achatMateriel;
    }






}
