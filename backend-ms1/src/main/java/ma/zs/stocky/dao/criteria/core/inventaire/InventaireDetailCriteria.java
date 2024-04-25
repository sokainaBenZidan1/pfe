package  ma.zs.stocky.dao.criteria.core.inventaire;


import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class InventaireDetailCriteria extends  BaseCriteria  {

    private String qteCalculee;
    private String qteCalculeeMin;
    private String qteCalculeeMax;
    private String qteStock;
    private String qteStockMin;
    private String qteStockMax;
    private String ecart;
    private String ecartMin;
    private String ecartMax;
    private String magasin;
    private String magasinLike;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private InventaireCriteria inventaire ;
    private List<InventaireCriteria> inventaires ;


    public InventaireDetailCriteria(){}

    public String getQteCalculee(){
        return this.qteCalculee;
    }
    public void setQteCalculee(String qteCalculee){
        this.qteCalculee = qteCalculee;
    }   
    public String getQteCalculeeMin(){
        return this.qteCalculeeMin;
    }
    public void setQteCalculeeMin(String qteCalculeeMin){
        this.qteCalculeeMin = qteCalculeeMin;
    }
    public String getQteCalculeeMax(){
        return this.qteCalculeeMax;
    }
    public void setQteCalculeeMax(String qteCalculeeMax){
        this.qteCalculeeMax = qteCalculeeMax;
    }
      
    public String getQteStock(){
        return this.qteStock;
    }
    public void setQteStock(String qteStock){
        this.qteStock = qteStock;
    }   
    public String getQteStockMin(){
        return this.qteStockMin;
    }
    public void setQteStockMin(String qteStockMin){
        this.qteStockMin = qteStockMin;
    }
    public String getQteStockMax(){
        return this.qteStockMax;
    }
    public void setQteStockMax(String qteStockMax){
        this.qteStockMax = qteStockMax;
    }
      
    public String getEcart(){
        return this.ecart;
    }
    public void setEcart(String ecart){
        this.ecart = ecart;
    }   
    public String getEcartMin(){
        return this.ecartMin;
    }
    public void setEcartMin(String ecartMin){
        this.ecartMin = ecartMin;
    }
    public String getEcartMax(){
        return this.ecartMax;
    }
    public void setEcartMax(String ecartMax){
        this.ecartMax = ecartMax;
    }
      
    public String getMagasin(){
        return this.magasin;
    }
    public void setMagasin(String magasin){
        this.magasin = magasin;
    }
    public String getMagasinLike(){
        return this.magasinLike;
    }
    public void setMagasinLike(String magasinLike){
        this.magasinLike = magasinLike;
    }


    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public InventaireCriteria getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(InventaireCriteria inventaire){
        this.inventaire = inventaire;
    }
    public List<InventaireCriteria> getInventaires(){
        return this.inventaires;
    }

    public void setInventaires(List<InventaireCriteria> inventaires){
        this.inventaires = inventaires;
    }
}
