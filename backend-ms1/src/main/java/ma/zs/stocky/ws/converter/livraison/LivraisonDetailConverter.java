package  ma.zs.stocky.ws.converter.livraison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.converter.livraison.LivraisonConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.livraison.Livraison;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.ws.dto.livraison.LivraisonDetailDto;

@Component
public class LivraisonDetailConverter extends AbstractConverter<LivraisonDetail, LivraisonDetailDto> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private LivraisonConverter livraisonConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean magasin;
    private boolean produit;
    private boolean livraison;

    public  LivraisonDetailConverter() {
        super(LivraisonDetail.class, LivraisonDetailDto.class);
        init(true);
    }

    @Override
    public LivraisonDetail toItem(LivraisonDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        LivraisonDetail item = new LivraisonDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQte()))
                item.setQte(dto.getQte());
            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getLivraison() != null && dto.getLivraison().getId() != null){
                item.setLivraison(new Livraison());
                item.getLivraison().setId(dto.getLivraison().getId());
                item.getLivraison().setRef(dto.getLivraison().getRef());
            }




        return item;
        }
    }

    @Override
    public LivraisonDetailDto toDto(LivraisonDetail item) {
        if (item == null) {
            return null;
        } else {
            LivraisonDetailDto dto = new LivraisonDetailDto();
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
            if(this.livraison && item.getLivraison()!=null) {
                dto.setLivraison(livraisonConverter.toDto(item.getLivraison())) ;

            }


        return dto;
        }
    }

    public void copy(LivraisonDetailDto dto, LivraisonDetail t) {
    super.copy(dto, t);
    if (dto.getMagasin() != null)
        magasinConverter.copy(dto.getMagasin(), t.getMagasin());
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    if (dto.getLivraison() != null)
        livraisonConverter.copy(dto.getLivraison(), t.getLivraison());
    }



    public void initObject(boolean value) {
        this.magasin = value;
        this.produit = value;
        this.livraison = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public LivraisonConverter getLivraisonConverter(){
        return this.livraisonConverter;
    }
    public void setLivraisonConverter(LivraisonConverter livraisonConverter ){
        this.livraisonConverter = livraisonConverter;
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
    public boolean  isLivraison(){
        return this.livraison;
    }
    public void  setLivraison(boolean livraison){
        this.livraison = livraison;
    }
}
