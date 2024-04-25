package  ma.zs.stocky.ws.converter.reception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.converter.reception.ReceptionConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.reception.Reception;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.ws.dto.reception.ReceptionDetailDto;

@Component
public class ReceptionDetailConverter extends AbstractConverter<ReceptionDetail, ReceptionDetailDto> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private ReceptionConverter receptionConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean magasin;
    private boolean produit;
    private boolean reception;

    public  ReceptionDetailConverter() {
        super(ReceptionDetail.class, ReceptionDetailDto.class);
        init(true);
    }

    @Override
    public ReceptionDetail toItem(ReceptionDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReceptionDetail item = new ReceptionDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQte()))
                item.setQte(dto.getQte());
            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getReception() != null && dto.getReception().getId() != null){
                item.setReception(new Reception());
                item.getReception().setId(dto.getReception().getId());
                item.getReception().setRef(dto.getReception().getRef());
            }




        return item;
        }
    }

    @Override
    public ReceptionDetailDto toDto(ReceptionDetail item) {
        if (item == null) {
            return null;
        } else {
            ReceptionDetailDto dto = new ReceptionDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQte()))
                dto.setQte(item.getQte());
            if(this.magasin && item.getMagasin()!=null) {
                dto.setMagasin(magasinConverter.toDto(item.getMagasin())) ;

            }
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }
            if(this.reception && item.getReception()!=null) {
                dto.setReception(receptionConverter.toDto(item.getReception())) ;

            }


        return dto;
        }
    }

    public void copy(ReceptionDetailDto dto, ReceptionDetail t) {
    super.copy(dto, t);
    if (dto.getMagasin() != null)
        magasinConverter.copy(dto.getMagasin(), t.getMagasin());
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    if (dto.getReception() != null)
        receptionConverter.copy(dto.getReception(), t.getReception());
    }



    public void initObject(boolean value) {
        this.magasin = value;
        this.produit = value;
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
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isMagasin(){
        return this.magasin;
    }
    public void  setMagasin(boolean magasin){
        this.magasin = magasin;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isReception(){
        return this.reception;
    }
    public void  setReception(boolean reception){
        this.reception = reception;
    }
}
