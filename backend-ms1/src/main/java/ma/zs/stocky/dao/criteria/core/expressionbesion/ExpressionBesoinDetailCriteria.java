package  ma.zs.stocky.dao.criteria.core.expressionbesion;


import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ExpressionBesoinDetailCriteria extends  BaseCriteria  {

    private String qteDemandee;
    private String qteDemandeeMin;
    private String qteDemandeeMax;
    private String qteAccordee;
    private String qteAccordeeMin;
    private String qteAccordeeMax;
    private String qteLivre;
    private String qteLivreMin;
    private String qteLivreMax;

    private ExpressionBesoinCriteria expressionBesoin ;
    private List<ExpressionBesoinCriteria> expressionBesoins ;
    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;


    public ExpressionBesoinDetailCriteria(){}

    public String getQteDemandee(){
        return this.qteDemandee;
    }
    public void setQteDemandee(String qteDemandee){
        this.qteDemandee = qteDemandee;
    }   
    public String getQteDemandeeMin(){
        return this.qteDemandeeMin;
    }
    public void setQteDemandeeMin(String qteDemandeeMin){
        this.qteDemandeeMin = qteDemandeeMin;
    }
    public String getQteDemandeeMax(){
        return this.qteDemandeeMax;
    }
    public void setQteDemandeeMax(String qteDemandeeMax){
        this.qteDemandeeMax = qteDemandeeMax;
    }
      
    public String getQteAccordee(){
        return this.qteAccordee;
    }
    public void setQteAccordee(String qteAccordee){
        this.qteAccordee = qteAccordee;
    }   
    public String getQteAccordeeMin(){
        return this.qteAccordeeMin;
    }
    public void setQteAccordeeMin(String qteAccordeeMin){
        this.qteAccordeeMin = qteAccordeeMin;
    }
    public String getQteAccordeeMax(){
        return this.qteAccordeeMax;
    }
    public void setQteAccordeeMax(String qteAccordeeMax){
        this.qteAccordeeMax = qteAccordeeMax;
    }
      
    public String getQteLivre(){
        return this.qteLivre;
    }
    public void setQteLivre(String qteLivre){
        this.qteLivre = qteLivre;
    }   
    public String getQteLivreMin(){
        return this.qteLivreMin;
    }
    public void setQteLivreMin(String qteLivreMin){
        this.qteLivreMin = qteLivreMin;
    }
    public String getQteLivreMax(){
        return this.qteLivreMax;
    }
    public void setQteLivreMax(String qteLivreMax){
        this.qteLivreMax = qteLivreMax;
    }
      

    public ExpressionBesoinCriteria getExpressionBesoin(){
        return this.expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoinCriteria expressionBesoin){
        this.expressionBesoin = expressionBesoin;
    }
    public List<ExpressionBesoinCriteria> getExpressionBesoins(){
        return this.expressionBesoins;
    }

    public void setExpressionBesoins(List<ExpressionBesoinCriteria> expressionBesoins){
        this.expressionBesoins = expressionBesoins;
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
