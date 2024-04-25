package  ma.zs.stocky.dao.criteria.core.stock;


import ma.zs.stocky.dao.criteria.core.produit.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class OperationStockDetailCriteria extends  BaseCriteria  {

    private String qte;
    private String qteMin;
    private String qteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private OperationStockCriteria operationStock ;
    private List<OperationStockCriteria> operationStocks ;


    public OperationStockDetailCriteria(){}

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
    public OperationStockCriteria getOperationStock(){
        return this.operationStock;
    }

    public void setOperationStock(OperationStockCriteria operationStock){
        this.operationStock = operationStock;
    }
    public List<OperationStockCriteria> getOperationStocks(){
        return this.operationStocks;
    }

    public void setOperationStocks(List<OperationStockCriteria> operationStocks){
        this.operationStocks = operationStocks;
    }
}
