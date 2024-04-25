package  ma.zs.stocky.dao.criteria.core.inventaire;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ResponsableInventaireCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String login;
    private String loginLike;
    private String mdp;
    private String mdpLike;



    public ResponsableInventaireCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLoginLike(){
        return this.loginLike;
    }
    public void setLoginLike(String loginLike){
        this.loginLike = loginLike;
    }

    public String getMdp(){
        return this.mdp;
    }
    public void setMdp(String mdp){
        this.mdp = mdp;
    }
    public String getMdpLike(){
        return this.mdpLike;
    }
    public void setMdpLike(String mdpLike){
        this.mdpLike = mdpLike;
    }


}
