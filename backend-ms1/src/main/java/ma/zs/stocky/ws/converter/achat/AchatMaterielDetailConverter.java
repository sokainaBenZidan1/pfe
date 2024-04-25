package  ma.zs.stocky.ws.converter.achat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.produit.ProduitConverter;
import ma.zs.stocky.ws.converter.achat.AchatMaterielConverter;

import ma.zs.stocky.bean.core.achat.AchatMateriel;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.ws.dto.achat.AchatMaterielDetailDto;

@Component
public class AchatMaterielDetailConverter extends AbstractConverter<AchatMaterielDetail, AchatMaterielDetailDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AchatMaterielConverter achatMaterielConverter ;
    private boolean produit;
    private boolean achatMateriel;

    public  AchatMaterielDetailConverter() {
        super(AchatMaterielDetail.class, AchatMaterielDetailDto.class);
        init(true);
    }

    @Override
    public AchatMaterielDetail toItem(AchatMaterielDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        AchatMaterielDetail item = new AchatMaterielDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQteAchetee()))
                item.setQteAchetee(dto.getQteAchetee());
            if(StringUtil.isNotEmpty(dto.getQteRecue()))
                item.setQteRecue(dto.getQteRecue());
            if(StringUtil.isNotEmpty(dto.getQteLivree()))
                item.setQteLivree(dto.getQteLivree());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getAchatMateriel() != null && dto.getAchatMateriel().getId() != null){
                item.setAchatMateriel(new AchatMateriel());
                item.getAchatMateriel().setId(dto.getAchatMateriel().getId());
                item.getAchatMateriel().setId(dto.getAchatMateriel().getId());
            }




        return item;
        }
    }

    @Override
    public AchatMaterielDetailDto toDto(AchatMaterielDetail item) {
        if (item == null) {
            return null;
        } else {
            AchatMaterielDetailDto dto = new AchatMaterielDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQteAchetee()))
                dto.setQteAchetee(item.getQteAchetee());
            if(StringUtil.isNotEmpty(item.getQteRecue()))
                dto.setQteRecue(item.getQteRecue());
            if(StringUtil.isNotEmpty(item.getQteLivree()))
                dto.setQteLivree(item.getQteLivree());
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }
            if(this.achatMateriel && item.getAchatMateriel()!=null) {
                dto.setAchatMateriel(achatMaterielConverter.toDto(item.getAchatMateriel())) ;

            }


        return dto;
        }
    }

    public void copy(AchatMaterielDetailDto dto, AchatMaterielDetail t) {
    super.copy(dto, t);
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    if (dto.getAchatMateriel() != null)
        achatMaterielConverter.copy(dto.getAchatMateriel(), t.getAchatMateriel());
    }



    public void initObject(boolean value) {
        this.produit = value;
        this.achatMateriel = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AchatMaterielConverter getAchatMaterielConverter(){
        return this.achatMaterielConverter;
    }
    public void setAchatMaterielConverter(AchatMaterielConverter achatMaterielConverter ){
        this.achatMaterielConverter = achatMaterielConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isAchatMateriel(){
        return this.achatMateriel;
    }
    public void  setAchatMateriel(boolean achatMateriel){
        this.achatMateriel = achatMateriel;
    }
}
