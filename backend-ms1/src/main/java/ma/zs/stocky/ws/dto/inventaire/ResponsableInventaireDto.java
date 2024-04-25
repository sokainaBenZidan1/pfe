package  ma.zs.stocky.ws.dto.inventaire;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsableInventaireDto  extends AuditBaseDto {

    private String nom  ;
    private String prenom  ;
    private String login  ;
    private String mdp  ;




    public ResponsableInventaireDto(){
        super();
    }



    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    @Log
    public String getMdp(){
        return this.mdp;
    }
    public void setMdp(String mdp){
        this.mdp = mdp;
    }








}
