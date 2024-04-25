package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.converter.stock.OperationStockDetailConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.ws.dto.stock.OperationStockDto;

@Component
public class OperationStockConverter extends AbstractConverter<OperationStock, OperationStockDto> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private OperationStockDetailConverter operationStockDetailConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean magasinSource;
    private boolean magasinDest;
    private boolean operationStockDetails;

    public  OperationStockConverter() {
        super(OperationStock.class, OperationStockDto.class);
        init(true);
    }

    @Override
    public OperationStock toItem(OperationStockDto dto) {
        if (dto == null) {
            return null;
        } else {
        OperationStock item = new OperationStock();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDateOS()))
                item.setDateOS(DateUtil.stringEnToDate(dto.getDateOS()));
            if(StringUtil.isNotEmpty(dto.getDiscription()))
                item.setDiscription(dto.getDiscription());
            if(this.magasinSource && dto.getMagasinSource()!=null)
                item.setMagasinSource(magasinConverter.toItem(dto.getMagasinSource())) ;

            if(this.magasinDest && dto.getMagasinDest()!=null)
                item.setMagasinDest(magasinConverter.toItem(dto.getMagasinDest())) ;


            if(this.operationStockDetails && ListUtil.isNotEmpty(dto.getOperationStockDetails()))
                item.setOperationStockDetails(operationStockDetailConverter.toItem(dto.getOperationStockDetails()));


        return item;
        }
    }

    @Override
    public OperationStockDto toDto(OperationStock item) {
        if (item == null) {
            return null;
        } else {
            OperationStockDto dto = new OperationStockDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(item.getDateOS()!=null)
                dto.setDateOS(DateUtil.dateTimeToString(item.getDateOS()));
            if(StringUtil.isNotEmpty(item.getDiscription()))
                dto.setDiscription(item.getDiscription());
            if(this.magasinSource && item.getMagasinSource()!=null) {
                dto.setMagasinSource(magasinConverter.toDto(item.getMagasinSource())) ;

            }
            if(this.magasinDest && item.getMagasinDest()!=null) {
                dto.setMagasinDest(magasinConverter.toDto(item.getMagasinDest())) ;

            }
        if(this.operationStockDetails && ListUtil.isNotEmpty(item.getOperationStockDetails())){
            operationStockDetailConverter.init(true);
            operationStockDetailConverter.setOperationStock(false);
            dto.setOperationStockDetails(operationStockDetailConverter.toDto(item.getOperationStockDetails()));
            operationStockDetailConverter.setOperationStock(true);

        }


        return dto;
        }
    }

    public void copy(OperationStockDto dto, OperationStock t) {
    super.copy(dto, t);
    if (dto.getMagasinSource() != null)
        magasinConverter.copy(dto.getMagasinSource(), t.getMagasinSource());
    if (dto.getMagasinDest() != null)
        magasinConverter.copy(dto.getMagasinDest(), t.getMagasinDest());
    if (dto.getOperationStockDetails() != null)
        t.setOperationStockDetails(operationStockDetailConverter.copy(dto.getOperationStockDetails()));
    }


    public void initList(boolean value) {
        this.operationStockDetails = value;
    }

    public void initObject(boolean value) {
        this.magasinSource = value;
        this.magasinDest = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public OperationStockDetailConverter getOperationStockDetailConverter(){
        return this.operationStockDetailConverter;
    }
    public void setOperationStockDetailConverter(OperationStockDetailConverter operationStockDetailConverter ){
        this.operationStockDetailConverter = operationStockDetailConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isMagasinSource(){
        return this.magasinSource;
    }
    public void  setMagasinSource(boolean magasinSource){
        this.magasinSource = magasinSource;
    }
    public boolean  isMagasinDest(){
        return this.magasinDest;
    }
    public void  setMagasinDest(boolean magasinDest){
        this.magasinDest = magasinDest;
    }
    public boolean  isOperationStockDetails(){
        return this.operationStockDetails ;
    }
    public void  setOperationStockDetails(boolean operationStockDetails ){
        this.operationStockDetails  = operationStockDetails ;
    }
}
