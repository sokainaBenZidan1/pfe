package  ma.zs.stocky.ws.converter.reception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.converter.commande.CommandeConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;
import ma.zs.stocky.ws.converter.reception.ReceptionDetailConverter;

import ma.zs.stocky.bean.core.commande.Commande;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.ws.dto.reception.ReceptionDto;

@Component
public class ReceptionConverter extends AbstractConverter<Reception, ReceptionDto> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ReceptionDetailConverter receptionDetailConverter ;
    private boolean commande;
    private boolean receptionDetails;

    public  ReceptionConverter() {
        super(Reception.class, ReceptionDto.class);
        init(true);
    }

    @Override
    public Reception toItem(ReceptionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Reception item = new Reception();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDateReception()))
                item.setDateReception(DateUtil.stringEnToDate(dto.getDateReception()));
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
                item.getCommande().setRef(dto.getCommande().getRef());
            }


            if(this.receptionDetails && ListUtil.isNotEmpty(dto.getReceptionDetails()))
                item.setReceptionDetails(receptionDetailConverter.toItem(dto.getReceptionDetails()));


        return item;
        }
    }

    @Override
    public ReceptionDto toDto(Reception item) {
        if (item == null) {
            return null;
        } else {
            ReceptionDto dto = new ReceptionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(item.getDateReception()!=null)
                dto.setDateReception(DateUtil.dateTimeToString(item.getDateReception()));
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.commande && item.getCommande()!=null) {
                dto.setCommande(commandeConverter.toDto(item.getCommande())) ;

            }
        if(this.receptionDetails && ListUtil.isNotEmpty(item.getReceptionDetails())){
            receptionDetailConverter.init(true);
            receptionDetailConverter.setReception(false);
            dto.setReceptionDetails(receptionDetailConverter.toDto(item.getReceptionDetails()));
            receptionDetailConverter.setReception(true);

        }


        return dto;
        }
    }

    public void copy(ReceptionDto dto, Reception t) {
    super.copy(dto, t);
    if (dto.getCommande() != null)
        commandeConverter.copy(dto.getCommande(), t.getCommande());
    if (dto.getReceptionDetails() != null)
        t.setReceptionDetails(receptionDetailConverter.copy(dto.getReceptionDetails()));
    }


    public void initList(boolean value) {
        this.receptionDetails = value;
    }

    public void initObject(boolean value) {
        this.commande = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
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
    public ReceptionDetailConverter getReceptionDetailConverter(){
        return this.receptionDetailConverter;
    }
    public void setReceptionDetailConverter(ReceptionDetailConverter receptionDetailConverter ){
        this.receptionDetailConverter = receptionDetailConverter;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
    public boolean  isReceptionDetails(){
        return this.receptionDetails ;
    }
    public void  setReceptionDetails(boolean receptionDetails ){
        this.receptionDetails  = receptionDetails ;
    }
}
