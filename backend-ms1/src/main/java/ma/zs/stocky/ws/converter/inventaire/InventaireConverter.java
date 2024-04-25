package  ma.zs.stocky.ws.converter.inventaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.inventaire.ResponsableInventaireConverter;
import ma.zs.stocky.ws.converter.inventaire.InventaireDetailConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.ws.dto.inventaire.InventaireDto;

@Component
public class InventaireConverter extends AbstractConverter<Inventaire, InventaireDto> {

    @Autowired
    private ResponsableInventaireConverter responsableInventaireConverter ;
    @Autowired
    private InventaireDetailConverter inventaireDetailConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean responsableInv;
    private boolean inventaireDetails;

    public  InventaireConverter() {
        super(Inventaire.class, InventaireDto.class);
        init(true);
    }

    @Override
    public Inventaire toItem(InventaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Inventaire item = new Inventaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(this.responsableInv && dto.getResponsableInv()!=null)
                item.setResponsableInv(responsableInventaireConverter.toItem(dto.getResponsableInv())) ;


            if(this.inventaireDetails && ListUtil.isNotEmpty(dto.getInventaireDetails()))
                item.setInventaireDetails(inventaireDetailConverter.toItem(dto.getInventaireDetails()));


        return item;
        }
    }

    @Override
    public InventaireDto toDto(Inventaire item) {
        if (item == null) {
            return null;
        } else {
            InventaireDto dto = new InventaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(this.responsableInv && item.getResponsableInv()!=null) {
                dto.setResponsableInv(responsableInventaireConverter.toDto(item.getResponsableInv())) ;

            }
        if(this.inventaireDetails && ListUtil.isNotEmpty(item.getInventaireDetails())){
            inventaireDetailConverter.init(true);
            inventaireDetailConverter.setInventaire(false);
            dto.setInventaireDetails(inventaireDetailConverter.toDto(item.getInventaireDetails()));
            inventaireDetailConverter.setInventaire(true);

        }


        return dto;
        }
    }

    public void copy(InventaireDto dto, Inventaire t) {
    super.copy(dto, t);
    if (dto.getResponsableInv() != null)
        responsableInventaireConverter.copy(dto.getResponsableInv(), t.getResponsableInv());
    if (dto.getInventaireDetails() != null)
        t.setInventaireDetails(inventaireDetailConverter.copy(dto.getInventaireDetails()));
    }


    public void initList(boolean value) {
        this.inventaireDetails = value;
    }

    public void initObject(boolean value) {
        this.responsableInv = value;
    }


    public ResponsableInventaireConverter getResponsableInventaireConverter(){
        return this.responsableInventaireConverter;
    }
    public void setResponsableInventaireConverter(ResponsableInventaireConverter responsableInventaireConverter ){
        this.responsableInventaireConverter = responsableInventaireConverter;
    }
    public InventaireDetailConverter getInventaireDetailConverter(){
        return this.inventaireDetailConverter;
    }
    public void setInventaireDetailConverter(InventaireDetailConverter inventaireDetailConverter ){
        this.inventaireDetailConverter = inventaireDetailConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isResponsableInv(){
        return this.responsableInv;
    }
    public void  setResponsableInv(boolean responsableInv){
        this.responsableInv = responsableInv;
    }
    public boolean  isInventaireDetails(){
        return this.inventaireDetails ;
    }
    public void  setInventaireDetails(boolean inventaireDetails ){
        this.inventaireDetails  = inventaireDetails ;
    }
}
