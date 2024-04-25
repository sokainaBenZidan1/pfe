package  ma.zs.stocky.ws.converter.expressionbesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.expressionbesion.ExpressionBesoinConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.ws.dto.expressionbesion.ExpressionBesoinDetailDto;

@Component
public class ExpressionBesoinDetailConverter extends AbstractConverter<ExpressionBesoinDetail, ExpressionBesoinDetailDto> {

    @Autowired
    private ExpressionBesoinConverter expressionBesoinConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean expressionBesoin;
    private boolean produit;

    public  ExpressionBesoinDetailConverter() {
        super(ExpressionBesoinDetail.class, ExpressionBesoinDetailDto.class);
        init(true);
    }

    @Override
    public ExpressionBesoinDetail toItem(ExpressionBesoinDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        ExpressionBesoinDetail item = new ExpressionBesoinDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQteDemandee()))
                item.setQteDemandee(dto.getQteDemandee());
            if(StringUtil.isNotEmpty(dto.getQteAccordee()))
                item.setQteAccordee(dto.getQteAccordee());
            if(StringUtil.isNotEmpty(dto.getQteLivre()))
                item.setQteLivre(dto.getQteLivre());
            if(dto.getExpressionBesoin() != null && dto.getExpressionBesoin().getId() != null){
                item.setExpressionBesoin(new ExpressionBesoin());
                item.getExpressionBesoin().setId(dto.getExpressionBesoin().getId());
                item.getExpressionBesoin().setId(dto.getExpressionBesoin().getId());
            }

            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;




        return item;
        }
    }

    @Override
    public ExpressionBesoinDetailDto toDto(ExpressionBesoinDetail item) {
        if (item == null) {
            return null;
        } else {
            ExpressionBesoinDetailDto dto = new ExpressionBesoinDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQteDemandee()))
                dto.setQteDemandee(item.getQteDemandee());
            if(StringUtil.isNotEmpty(item.getQteAccordee()))
                dto.setQteAccordee(item.getQteAccordee());
            if(StringUtil.isNotEmpty(item.getQteLivre()))
                dto.setQteLivre(item.getQteLivre());
            if(this.expressionBesoin && item.getExpressionBesoin()!=null) {
                dto.setExpressionBesoin(expressionBesoinConverter.toDto(item.getExpressionBesoin())) ;

            }
            if(this.produit && item.getProduit()!=null) {
                dto.setProduit(produitConverter.toDto(item.getProduit())) ;

            }


        return dto;
        }
    }

    public void copy(ExpressionBesoinDetailDto dto, ExpressionBesoinDetail t) {
    super.copy(dto, t);
    if (dto.getExpressionBesoin() != null)
        expressionBesoinConverter.copy(dto.getExpressionBesoin(), t.getExpressionBesoin());
    if (dto.getProduit() != null)
        produitConverter.copy(dto.getProduit(), t.getProduit());
    }



    public void initObject(boolean value) {
        this.expressionBesoin = value;
        this.produit = value;
    }


    public ExpressionBesoinConverter getExpressionBesoinConverter(){
        return this.expressionBesoinConverter;
    }
    public void setExpressionBesoinConverter(ExpressionBesoinConverter expressionBesoinConverter ){
        this.expressionBesoinConverter = expressionBesoinConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isExpressionBesoin(){
        return this.expressionBesoin;
    }
    public void  setExpressionBesoin(boolean expressionBesoin){
        this.expressionBesoin = expressionBesoin;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
}
