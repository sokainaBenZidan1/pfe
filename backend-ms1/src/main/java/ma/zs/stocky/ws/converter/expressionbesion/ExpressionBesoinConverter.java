package  ma.zs.stocky.ws.converter.expressionbesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;
import ma.zs.stocky.ws.converter.expressionbesion.EtatConverter;
import ma.zs.stocky.ws.converter.expressionbesion.ExpressionBesoinDetailConverter;
import ma.zs.stocky.ws.converter.commun.EmployeConverter;
import ma.zs.stocky.ws.converter.produit.ProduitConverter;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.ws.dto.expressionbesion.ExpressionBesoinDto;

@Component
public class ExpressionBesoinConverter extends AbstractConverter<ExpressionBesoin, ExpressionBesoinDto> {

    @Autowired
    private EntiteAdminConverter entiteAdminConverter ;
    @Autowired
    private EtatConverter etatConverter ;
    @Autowired
    private ExpressionBesoinDetailConverter expressionBesoinDetailConverter ;
    @Autowired
    private EmployeConverter employeConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean employe;
    private boolean entiteAdmin;
    private boolean etat;
    private boolean expressionBesoinDetails;

    public  ExpressionBesoinConverter() {
        super(ExpressionBesoin.class, ExpressionBesoinDto.class);
        init(true);
    }

    @Override
    public ExpressionBesoin toItem(ExpressionBesoinDto dto) {
        if (dto == null) {
            return null;
        } else {
        ExpressionBesoin item = new ExpressionBesoin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getDateExpression()))
                item.setDateExpression(DateUtil.stringEnToDate(dto.getDateExpression()));
            if(this.employe && dto.getEmploye()!=null)
                item.setEmploye(employeConverter.toItem(dto.getEmploye())) ;

            if(dto.getEntiteAdmin() != null && dto.getEntiteAdmin().getId() != null){
                item.setEntiteAdmin(new EntiteAdmin());
                item.getEntiteAdmin().setId(dto.getEntiteAdmin().getId());
                item.getEntiteAdmin().setLibelle(dto.getEntiteAdmin().getLibelle());
            }

            if(this.etat && dto.getEtat()!=null)
                item.setEtat(etatConverter.toItem(dto.getEtat())) ;


            if(this.expressionBesoinDetails && ListUtil.isNotEmpty(dto.getExpressionBesoinDetails()))
                item.setExpressionBesoinDetails(expressionBesoinDetailConverter.toItem(dto.getExpressionBesoinDetails()));


        return item;
        }
    }

    @Override
    public ExpressionBesoinDto toDto(ExpressionBesoin item) {
        if (item == null) {
            return null;
        } else {
            ExpressionBesoinDto dto = new ExpressionBesoinDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(item.getDateExpression()!=null)
                dto.setDateExpression(DateUtil.dateTimeToString(item.getDateExpression()));
            if(this.employe && item.getEmploye()!=null) {
                dto.setEmploye(employeConverter.toDto(item.getEmploye())) ;

            }
            if(this.entiteAdmin && item.getEntiteAdmin()!=null) {
                dto.setEntiteAdmin(entiteAdminConverter.toDto(item.getEntiteAdmin())) ;

            }
            if(this.etat && item.getEtat()!=null) {
                dto.setEtat(etatConverter.toDto(item.getEtat())) ;

            }
        if(this.expressionBesoinDetails && ListUtil.isNotEmpty(item.getExpressionBesoinDetails())){
            expressionBesoinDetailConverter.init(true);
            expressionBesoinDetailConverter.setExpressionBesoin(false);
            dto.setExpressionBesoinDetails(expressionBesoinDetailConverter.toDto(item.getExpressionBesoinDetails()));
            expressionBesoinDetailConverter.setExpressionBesoin(true);

        }


        return dto;
        }
    }

    public void copy(ExpressionBesoinDto dto, ExpressionBesoin t) {
    super.copy(dto, t);
    if (dto.getEmploye() != null)
        employeConverter.copy(dto.getEmploye(), t.getEmploye());
    if (dto.getEntiteAdmin() != null)
        entiteAdminConverter.copy(dto.getEntiteAdmin(), t.getEntiteAdmin());
    if (dto.getExpressionBesoinDetails() != null)
        t.setExpressionBesoinDetails(expressionBesoinDetailConverter.copy(dto.getExpressionBesoinDetails()));
    if (dto.getEtat() != null)
        etatConverter.copy(dto.getEtat(), t.getEtat());
    }


    public void initList(boolean value) {
        this.expressionBesoinDetails = value;
    }

    public void initObject(boolean value) {
        this.employe = value;
        this.entiteAdmin = value;
        this.etat = value;
    }


    public EntiteAdminConverter getEntiteAdminConverter(){
        return this.entiteAdminConverter;
    }
    public void setEntiteAdminConverter(EntiteAdminConverter entiteAdminConverter ){
        this.entiteAdminConverter = entiteAdminConverter;
    }
    public EtatConverter getEtatConverter(){
        return this.etatConverter;
    }
    public void setEtatConverter(EtatConverter etatConverter ){
        this.etatConverter = etatConverter;
    }
    public ExpressionBesoinDetailConverter getExpressionBesoinDetailConverter(){
        return this.expressionBesoinDetailConverter;
    }
    public void setExpressionBesoinDetailConverter(ExpressionBesoinDetailConverter expressionBesoinDetailConverter ){
        this.expressionBesoinDetailConverter = expressionBesoinDetailConverter;
    }
    public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
    }
    public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isEmploye(){
        return this.employe;
    }
    public void  setEmploye(boolean employe){
        this.employe = employe;
    }
    public boolean  isEntiteAdmin(){
        return this.entiteAdmin;
    }
    public void  setEntiteAdmin(boolean entiteAdmin){
        this.entiteAdmin = entiteAdmin;
    }
    public boolean  isEtat(){
        return this.etat;
    }
    public void  setEtat(boolean etat){
        this.etat = etat;
    }
    public boolean  isExpressionBesoinDetails(){
        return this.expressionBesoinDetails ;
    }
    public void  setExpressionBesoinDetails(boolean expressionBesoinDetails ){
        this.expressionBesoinDetails  = expressionBesoinDetails ;
    }
}
