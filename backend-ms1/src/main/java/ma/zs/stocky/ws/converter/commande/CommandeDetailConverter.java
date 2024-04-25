package  ma.zs.stocky.ws.converter.commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commande.CommandeConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.commande.Commande;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.ws.dto.commande.CommandeDetailDto;

@Component
public class CommandeDetailConverter extends AbstractConverter<CommandeDetail, CommandeDetailDto> {

    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean commande;
    private boolean produit;

    public  CommandeDetailConverter() {
        super(CommandeDetail.class, CommandeDetailDto.class);
        init(true);
    }

    @Override
    public CommandeDetail toItem(CommandeDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        CommandeDetail item = new CommandeDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(StringUtil.isNotEmpty(dto.getQte()))
                item.setQte(dto.getQte());
            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
                item.getCommande().setRef(dto.getCommande().getRef());
            }

            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;




        return item;
        }
    }

    @Override
    public CommandeDetailDto toDto(CommandeDetail item) {
        if (item == null) {
            return null;
        } else {
            CommandeDetailDto dto = new CommandeDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
            if(StringUtil.isNotEmpty(item.getQte()))
                dto.setQte(item.getQte());
            if(this.commande && item.getCommande()!=null) {
                dto.setCommande(commandeConverter.toDto(item.getCommande())) ;

            }
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }


        return dto;
        }
    }

    public void copy(CommandeDetailDto dto, CommandeDetail t) {
    super.copy(dto, t);
    if (dto.getCommande() != null)
        commandeConverter.copy(dto.getCommande(), t.getCommande());
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    }



    public void initObject(boolean value) {
        this.commande = value;
        this.produit = value;
    }


    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
}
