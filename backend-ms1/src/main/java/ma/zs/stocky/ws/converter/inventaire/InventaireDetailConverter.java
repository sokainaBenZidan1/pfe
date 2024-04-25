package  ma.zs.stocky.ws.converter.inventaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.inventaire.InventaireConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.inventaire.Inventaire;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.ws.dto.inventaire.InventaireDetailDto;

@Component
public class InventaireDetailConverter extends AbstractConverter<InventaireDetail, InventaireDetailDto> {

    @Autowired
    private InventaireConverter inventaireConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean inventaire;

    public  InventaireDetailConverter() {
        super(InventaireDetail.class, InventaireDetailDto.class);
        init(true);
    }

    @Override
    public InventaireDetail toItem(InventaireDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        InventaireDetail item = new InventaireDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQteCalculee()))
                item.setQteCalculee(dto.getQteCalculee());
            if(StringUtil.isNotEmpty(dto.getQteStock()))
                item.setQteStock(dto.getQteStock());
            if(StringUtil.isNotEmpty(dto.getEcart()))
                item.setEcart(dto.getEcart());
            if(StringUtil.isNotEmpty(dto.getMagasin()))
                item.setMagasin(dto.getMagasin());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getInventaire() != null && dto.getInventaire().getId() != null){
                item.setInventaire(new Inventaire());
                item.getInventaire().setId(dto.getInventaire().getId());
                item.getInventaire().setId(dto.getInventaire().getId());
            }




        return item;
        }
    }

    @Override
    public InventaireDetailDto toDto(InventaireDetail item) {
        if (item == null) {
            return null;
        } else {
            InventaireDetailDto dto = new InventaireDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQteCalculee()))
                dto.setQteCalculee(item.getQteCalculee());
            if(StringUtil.isNotEmpty(item.getQteStock()))
                dto.setQteStock(item.getQteStock());
            if(StringUtil.isNotEmpty(item.getEcart()))
                dto.setEcart(item.getEcart());
            if(StringUtil.isNotEmpty(item.getMagasin()))
                dto.setMagasin(item.getMagasin());
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }
            if(this.inventaire && item.getInventaire()!=null) {
                dto.setInventaire(inventaireConverter.toDto(item.getInventaire())) ;

            }


        return dto;
        }
    }

    public void copy(InventaireDetailDto dto, InventaireDetail t) {
    super.copy(dto, t);
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    if (dto.getInventaire() != null)
        inventaireConverter.copy(dto.getInventaire(), t.getInventaire());
    }



    public void initObject(boolean value) {
        this.produit = value;
        this.inventaire = value;
    }


    public InventaireConverter getInventaireConverter(){
        return this.inventaireConverter;
    }
    public void setInventaireConverter(InventaireConverter inventaireConverter ){
        this.inventaireConverter = inventaireConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isInventaire(){
        return this.inventaire;
    }
    public void  setInventaire(boolean inventaire){
        this.inventaire = inventaire;
    }
}
