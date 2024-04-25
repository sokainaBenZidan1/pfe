package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.Stock;
import ma.zs.stocky.ws.dto.stock.StockDto;

@Component
public class StockConverter extends AbstractConverter<Stock, StockDto> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean magasin;
    private boolean produit;

    public  StockConverter() {
        super(Stock.class, StockDto.class);
        init(true);
    }

    @Override
    public Stock toItem(StockDto dto) {
        if (dto == null) {
            return null;
        } else {
        Stock item = new Stock();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQte()))
                item.setQte(dto.getQte());
            if(StringUtil.isNotEmpty(dto.getQteDeffectueuse()))
                item.setQteDeffectueuse(dto.getQteDeffectueuse());
            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;




        return item;
        }
    }

    @Override
    public StockDto toDto(Stock item) {
        if (item == null) {
            return null;
        } else {
            StockDto dto = new StockDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQte()))
                dto.setQte(item.getQte());
            if(StringUtil.isNotEmpty(item.getQteDeffectueuse()))
                dto.setQteDeffectueuse(item.getQteDeffectueuse());
            if(this.magasin && item.getMagasin()!=null) {
                dto.setMagasin(magasinConverter.toDto(item.getMagasin())) ;

            }
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }


        return dto;
        }
    }

    public void copy(StockDto dto, Stock t) {
    super.copy(dto, t);
    if (dto.getMagasin() != null)
        magasinConverter.copy(dto.getMagasin(), t.getMagasin());
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    }



    public void initObject(boolean value) {
        this.magasin = value;
        this.produit = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
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
}
