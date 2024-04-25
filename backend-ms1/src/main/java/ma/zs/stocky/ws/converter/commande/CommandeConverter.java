package  ma.zs.stocky.ws.converter.commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;
import ma.zs.stocky.ws.converter.commande.CommandeDetailConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.ws.dto.commande.CommandeDto;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto> {

    @Autowired
    private EntiteAdminConverter entiteAdminConverter ;
    @Autowired
    private CommandeDetailConverter commandeDetailConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean entiteAdmin;
    private boolean commandeDetails;

    public  CommandeConverter() {
        super(Commande.class, CommandeDto.class);
        init(true);
    }

    @Override
    public Commande toItem(CommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Commande item = new Commande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaye()))
                item.setTotalPaye(dto.getTotalPaye());
            if(StringUtil.isNotEmpty(dto.getDateCommande()))
                item.setDateCommande(DateUtil.stringEnToDate(dto.getDateCommande()));
            if(dto.getEntiteAdmin() != null && dto.getEntiteAdmin().getId() != null){
                item.setEntiteAdmin(new EntiteAdmin());
                item.getEntiteAdmin().setId(dto.getEntiteAdmin().getId());
                item.getEntiteAdmin().setLibelle(dto.getEntiteAdmin().getLibelle());
            }


            if(this.commandeDetails && ListUtil.isNotEmpty(dto.getCommandeDetails()))
                item.setCommandeDetails(commandeDetailConverter.toItem(dto.getCommandeDetails()));


        return item;
        }
    }

    @Override
    public CommandeDto toDto(Commande item) {
        if (item == null) {
            return null;
        } else {
            CommandeDto dto = new CommandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaye()))
                dto.setTotalPaye(item.getTotalPaye());
            if(item.getDateCommande()!=null)
                dto.setDateCommande(DateUtil.dateTimeToString(item.getDateCommande()));
            if(this.entiteAdmin && item.getEntiteAdmin()!=null) {
                dto.setEntiteAdmin(entiteAdminConverter.toDto(item.getEntiteAdmin())) ;

            }
        if(this.commandeDetails && ListUtil.isNotEmpty(item.getCommandeDetails())){
            commandeDetailConverter.init(true);
            commandeDetailConverter.setCommande(false);
            dto.setCommandeDetails(commandeDetailConverter.toDto(item.getCommandeDetails()));
            commandeDetailConverter.setCommande(true);

        }


        return dto;
        }
    }

    public void copy(CommandeDto dto, Commande t) {
    super.copy(dto, t);
    if (dto.getCommandeDetails() != null)
        t.setCommandeDetails(commandeDetailConverter.copy(dto.getCommandeDetails()));
    if (dto.getEntiteAdmin() != null)
        entiteAdminConverter.copy(dto.getEntiteAdmin(), t.getEntiteAdmin());
    }


    public void initList(boolean value) {
        this.commandeDetails = value;
    }

    public void initObject(boolean value) {
        this.entiteAdmin = value;
    }


    public EntiteAdminConverter getEntiteAdminConverter(){
        return this.entiteAdminConverter;
    }
    public void setEntiteAdminConverter(EntiteAdminConverter entiteAdminConverter ){
        this.entiteAdminConverter = entiteAdminConverter;
    }
    public CommandeDetailConverter getCommandeDetailConverter(){
        return this.commandeDetailConverter;
    }
    public void setCommandeDetailConverter(CommandeDetailConverter commandeDetailConverter ){
        this.commandeDetailConverter = commandeDetailConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void  setEntiteAdmin(boolean entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public boolean  isCommandeDetails(){
        return this.commandeDetails ;
    }
    public void  setCommandeDetails(boolean commandeDetails ){
        this.commandeDetails  = commandeDetails ;
    }
}
