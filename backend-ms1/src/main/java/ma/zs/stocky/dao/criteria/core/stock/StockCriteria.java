package  ma.zs.stocky.dao.criteria.core.stock;


import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class StockCriteria extends  BaseCriteria  {

    private String qte;
    private String qteMin;
    private String qteMax;
    private String qteDeffectueuse;
    private String qteDeffectueuseMin;
    private String qteDeffectueuseMax;

    private MagasinCriteria magasin ;
    private List<MagasinCriteria> magasins ;
    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;


    public StockCriteria(){}

    public String getQte(){
        return this.qte;
    }
    public void setQte(String qte){
        this.qte = qte;
    }   
    public String getQteMin(){
        return this.qteMin;
    }
    public void setQteMin(String qteMin){
        this.qteMin = qteMin;
    }
    public String getQteMax(){
        return this.qteMax;
    }
    public void setQteMax(String qteMax){
        this.qteMax = qteMax;
    }
      
    public String getQteDeffectueuse(){
        return this.qteDeffectueuse;
    }
    public void setQteDeffectueuse(String qteDeffectueuse){
        this.qteDeffectueuse = qteDeffectueuse;
    }   
    public String getQteDeffectueuseMin(){
        return this.qteDeffectueuseMin;
    }
    public void setQteDeffectueuseMin(String qteDeffectueuseMin){
        this.qteDeffectueuseMin = qteDeffectueuseMin;
    }
    public String getQteDeffectueuseMax(){
        return this.qteDeffectueuseMax;
    }
    public void setQteDeffectueuseMax(String qteDeffectueuseMax){
        this.qteDeffectueuseMax = qteDeffectueuseMax;
    }
      

    public MagasinCriteria getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinCriteria magasin){
        this.magasin = magasin;
    }
    public List<MagasinCriteria> getMagasins(){
        return this.magasins;
    }

    public void setMagasins(List<MagasinCriteria> magasins){
        this.magasins = magasins;
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
}
