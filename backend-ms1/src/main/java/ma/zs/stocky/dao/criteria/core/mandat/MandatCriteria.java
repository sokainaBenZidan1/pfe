package  ma.zs.stocky.dao.criteria.core.mandat;


import ma.zs.stocky.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.stocky.dao.criteria.core.commun.EmployeCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class MandatCriteria extends  BaseCriteria  {

    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;

    private EmployeCriteria employe ;
    private List<EmployeCriteria> employes ;
    private ResponsabiliteCriteria responsabilite ;
    private List<ResponsabiliteCriteria> responsabilites ;
    private EntiteAdminCriteria entiteAdmin ;
    private List<EntiteAdminCriteria> entiteAdmins ;


    public MandatCriteria(){}

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }

    public EmployeCriteria getEmploye(){
        return this.employe;
    }

    public void setEmploye(EmployeCriteria employe){
        this.employe = employe;
    }
    public List<EmployeCriteria> getEmployes(){
        return this.employes;
    }

    public void setEmployes(List<EmployeCriteria> employes){
        this.employes = employes;
    }
    public ResponsabiliteCriteria getResponsabilite(){
        return this.responsabilite;
    }

    public void setResponsabilite(ResponsabiliteCriteria responsabilite){
        this.responsabilite = responsabilite;
    }
    public List<ResponsabiliteCriteria> getResponsabilites(){
        return this.responsabilites;
    }

    public void setResponsabilites(List<ResponsabiliteCriteria> responsabilites){
        this.responsabilites = responsabilites;
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
