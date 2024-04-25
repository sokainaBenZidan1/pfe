package  ma.zs.stocky.dao.criteria.core.reception;


import ma.zs.stocky.dao.criteria.core.stock.MagasinCriteria;
import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ReceptionDetailCriteria extends  BaseCriteria  {

    private String qte;
    private String qteMin;
    private String qteMax;

    private MagasinCriteria magasin ;
    private List<MagasinCriteria> magasins ;
    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private ReceptionCriteria reception ;
    private List<ReceptionCriteria> receptions ;


    public ReceptionDetailCriteria(){}

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
    public ReceptionCriteria getReception(){
        return this.reception;
    }

    public void setReception(ReceptionCriteria reception){
        this.reception = reception;
    }
    public List<ReceptionCriteria> getReceptions(){
        return this.receptions;
    }

    public void setReceptions(List<ReceptionCriteria> receptions){
        this.receptions = receptions;
    }
}
