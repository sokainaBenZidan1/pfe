package  ma.zs.stocky.dao.criteria.core.achat;


import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class AchatMaterielDetailCriteria extends  BaseCriteria  {

    private String qteAchetee;
    private String qteAcheteeMin;
    private String qteAcheteeMax;
    private String qteRecue;
    private String qteRecueMin;
    private String qteRecueMax;
    private String qteLivree;
    private String qteLivreeMin;
    private String qteLivreeMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private AchatMaterielCriteria achatMateriel ;
    private List<AchatMaterielCriteria> achatMateriels ;


    public AchatMaterielDetailCriteria(){}

    public String getQteAchetee(){
        return this.qteAchetee;
    }
    public void setQteAchetee(String qteAchetee){
        this.qteAchetee = qteAchetee;
    }   
    public String getQteAcheteeMin(){
        return this.qteAcheteeMin;
    }
    public void setQteAcheteeMin(String qteAcheteeMin){
        this.qteAcheteeMin = qteAcheteeMin;
    }
    public String getQteAcheteeMax(){
        return this.qteAcheteeMax;
    }
    public void setQteAcheteeMax(String qteAcheteeMax){
        this.qteAcheteeMax = qteAcheteeMax;
    }
      
    public String getQteRecue(){
        return this.qteRecue;
    }
    public void setQteRecue(String qteRecue){
        this.qteRecue = qteRecue;
    }   
    public String getQteRecueMin(){
        return this.qteRecueMin;
    }
    public void setQteRecueMin(String qteRecueMin){
        this.qteRecueMin = qteRecueMin;
    }
    public String getQteRecueMax(){
        return this.qteRecueMax;
    }
    public void setQteRecueMax(String qteRecueMax){
        this.qteRecueMax = qteRecueMax;
    }
      
    public String getQteLivree(){
        return this.qteLivree;
    }
    public void setQteLivree(String qteLivree){
        this.qteLivree = qteLivree;
    }   
    public String getQteLivreeMin(){
        return this.qteLivreeMin;
    }
    public void setQteLivreeMin(String qteLivreeMin){
        this.qteLivreeMin = qteLivreeMin;
    }
    public String getQteLivreeMax(){
        return this.qteLivreeMax;
    }
    public void setQteLivreeMax(String qteLivreeMax){
        this.qteLivreeMax = qteLivreeMax;
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
    public AchatMaterielCriteria getAchatMateriel(){
        return this.achatMateriel;
    }

    public void setAchatMateriel(AchatMaterielCriteria achatMateriel){
        this.achatMateriel = achatMateriel;
    }
    public List<AchatMaterielCriteria> getAchatMateriels(){
        return this.achatMateriels;
    }

    public void setAchatMateriels(List<AchatMaterielCriteria> achatMateriels){
        this.achatMateriels = achatMateriels;
    }
}
