package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.stock.OperationStockConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.stock.OperationStock;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.ws.dto.stock.OperationStockDetailDto;

@Component
public class OperationStockDetailConverter extends AbstractConverter<OperationStockDetail, OperationStockDetailDto> {

    @Autowired
    private OperationStockConverter operationStockConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean operationStock;

    public  OperationStockDetailConverter() {
        super(OperationStockDetail.class, OperationStockDetailDto.class);
        init(true);
    }

    @Override
    public OperationStockDetail toItem(OperationStockDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        OperationStockDetail item = new OperationStockDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQte()))
                item.setQte(dto.getQte());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getOperationStock() != null && dto.getOperationStock().getId() != null){
                item.setOperationStock(new OperationStock());
                item.getOperationStock().setId(dto.getOperationStock().getId());
                item.getOperationStock().setRef(dto.getOperationStock().getRef());
            }




        return item;
        }
    }

    @Override
    public OperationStockDetailDto toDto(OperationStockDetail item) {
        if (item == null) {
            return null;
        } else {
            OperationStockDetailDto dto = new OperationStockDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQte()))
                dto.setQte(item.getQte());
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }
            if(this.operationStock && item.getOperationStock()!=null) {
                dto.setOperationStock(operationStockConverter.toDto(item.getOperationStock())) ;

            }


        return dto;
        }
    }

    public void copy(OperationStockDetailDto dto, OperationStockDetail t) {
    super.copy(dto, t);
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    if (dto.getOperationStock() != null)
        operationStockConverter.copy(dto.getOperationStock(), t.getOperationStock());
    }



    public void initObject(boolean value) {
        this.produit = value;
        this.operationStock = value;
    }


    public OperationStockConverter getOperationStockConverter(){
        return this.operationStockConverter;
    }
    public void setOperationStockConverter(OperationStockConverter operationStockConverter ){
        this.operationStockConverter = operationStockConverter;
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
    public boolean  isOperationStock(){
        return this.operationStock;
    }
    public void  setOperationStock(boolean operationStock){
        this.operationStock = operationStock;
    }
}
