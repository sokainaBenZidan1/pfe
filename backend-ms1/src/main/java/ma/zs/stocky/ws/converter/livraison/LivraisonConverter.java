package  ma.zs.stocky.ws.converter.livraison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.converter.reception.ReceptionConverter;
import ma.zs.stocky.ws.converter.livraison.LivraisonDetailConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.reception.Reception;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.ws.dto.livraison.LivraisonDto;

@Component
public class LivraisonConverter extends AbstractConverter<Livraison, LivraisonDto> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private ReceptionConverter receptionConverter ;
    @Autowired
    private LivraisonDetailConverter livraisonDetailConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean reception;
    private boolean livraisonDetails;

    public  LivraisonConverter() {
        super(Livraison.class, LivraisonDto.class);
        init(true);
    }

    @Override
    public Livraison toItem(LivraisonDto dto) {
        if (dto == null) {
            return null;
        } else {
        Livraison item = new Livraison();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDatelivraison()))
                item.setDatelivraison(DateUtil.stringEnToDate(dto.getDatelivraison()));
            if(dto.getReception() != null && dto.getReception().getId() != null){
                item.setReception(new Reception());
                item.getReception().setId(dto.getReception().getId());
                item.getReception().setRef(dto.getReception().getRef());
            }


            if(this.livraisonDetails && ListUtil.isNotEmpty(dto.getLivraisonDetails()))
                item.setLivraisonDetails(livraisonDetailConverter.toItem(dto.getLivraisonDetails()));


        return item;
        }
    }

    @Override
    public LivraisonDto toDto(Livraison item) {
        if (item == null) {
            return null;
        } else {
            LivraisonDto dto = new LivraisonDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(item.getDatelivraison()!=null)
                dto.setDatelivraison(DateUtil.dateTimeToString(item.getDatelivraison()));
            if(this.reception && item.getReception()!=null) {
                dto.setReception(receptionConverter.toDto(item.getReception())) ;

            }
        if(this.livraisonDetails && ListUtil.isNotEmpty(item.getLivraisonDetails())){
            livraisonDetailConverter.init(true);
            livraisonDetailConverter.setLivraison(false);
            dto.setLivraisonDetails(livraisonDetailConverter.toDto(item.getLivraisonDetails()));
            livraisonDetailConverter.setLivraison(true);

        }


        return dto;
        }
    }

    public void copy(LivraisonDto dto, Livraison t) {
    super.copy(dto, t);
    if (dto.getReception() != null)
        receptionConverter.copy(dto.getReception(), t.getReception());
    if (dto.getLivraisonDetails() != null)
        t.setLivraisonDetails(livraisonDetailConverter.copy(dto.getLivraisonDetails()));
    }


    public void initList(boolean value) {
        this.livraisonDetails = value;
    }

    public void initObject(boolean value) {
        this.reception = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public ReceptionConverter getReceptionConverter(){
        return this.receptionConverter;
    }
    public void setReceptionConverter(ReceptionConverter receptionConverter ){
        this.receptionConverter = receptionConverter;
    }
    public LivraisonDetailConverter getLivraisonDetailConverter(){
        return this.livraisonDetailConverter;
    }
    public void setLivraisonDetailConverter(LivraisonDetailConverter livraisonDetailConverter ){
        this.livraisonDetailConverter = livraisonDetailConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isReception(){
        return this.reception;
    }
    public void  setReception(boolean reception){
        this.reception = reception;
    }
    public boolean  isLivraisonDetails(){
        return this.livraisonDetails ;
    }
    public void  setLivraisonDetails(boolean livraisonDetails ){
        this.livraisonDetails  = livraisonDetails ;
    }
}
