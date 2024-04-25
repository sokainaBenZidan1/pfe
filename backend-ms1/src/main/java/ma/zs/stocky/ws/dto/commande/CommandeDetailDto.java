package  ma.zs.stocky.ws.dto.commande;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.produit.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandeDetailDto  extends AuditBaseDto {

    private BigDecimal prix  ;
    private BigDecimal qte  ;

    private CommandeDto commande ;
    private ProduitDto produit ;



    public CommandeDetailDto(){
        super();
    }



    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Log
    public BigDecimal getQte(){
        return this.qte;
    }
    public void setQte(BigDecimal qte){
        this.qte = qte;
    }


    public CommandeDto getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeDto commande){
        this.commande = commande;
    }
    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }






}
