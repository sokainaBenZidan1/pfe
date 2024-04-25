package  ma.zs.stocky.dao.criteria.core.commun;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EmployeCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;

    private EntiteAdminCriteria entiteAdmin ;
    private List<EntiteAdminCriteria> entiteAdmins ;


    public EmployeCriteria(){}

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


    public EntiteAdminCriteria getEntiteAdmin(){
        return this.entiteAdmin;
    }

    public void setEntiteAdmin(EntiteAdminCriteria entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public List<EntiteAdminCriteria> getEntiteAdmins(){
        return this.entiteAdmins;
    }

    public void setEntiteAdmins(List<EntiteAdminCriteria> entiteAdmins){
        this.entiteAdmins = entiteAdmins;
    }
}
