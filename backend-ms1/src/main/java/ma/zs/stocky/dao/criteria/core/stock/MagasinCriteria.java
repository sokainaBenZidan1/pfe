package  ma.zs.stocky.dao.criteria.core.stock;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class MagasinCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String adresse;
    private String adresseLike;



    public MagasinCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresseLike(){
        return this.adresseLike;
    }
    public void setAdresseLike(String adresseLike){
        this.adresseLike = adresseLike;
    }


}
