package  ma.zs.stocky.dao.criteria.core.stock;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class OperationStockCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private LocalDateTime dateOS;
    private LocalDateTime dateOSFrom;
    private LocalDateTime dateOSTo;
    private String discription;
    private String discriptionLike;

    private MagasinCriteria magasinSource ;
    private List<MagasinCriteria> magasinSources ;
    private MagasinCriteria magasinDest ;
    private List<MagasinCriteria> magasinDests ;


    public OperationStockCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public LocalDateTime getDateOS(){
        return this.dateOS;
    }
    public void setDateOS(LocalDateTime dateOS){
        this.dateOS = dateOS;
    }
    public LocalDateTime getDateOSFrom(){
        return this.dateOSFrom;
    }
    public void setDateOSFrom(LocalDateTime dateOSFrom){
        this.dateOSFrom = dateOSFrom;
    }
    public LocalDateTime getDateOSTo(){
        return this.dateOSTo;
    }
    public void setDateOSTo(LocalDateTime dateOSTo){
        this.dateOSTo = dateOSTo;
    }
    public String getDiscription(){
        return this.discription;
    }
    public void setDiscription(String discription){
        this.discription = discription;
    }
    public String getDiscriptionLike(){
        return this.discriptionLike;
    }
    public void setDiscriptionLike(String discriptionLike){
        this.discriptionLike = discriptionLike;
    }


    public MagasinCriteria getMagasinSource(){
        return this.magasinSource;
    }

    public void setMagasinSource(MagasinCriteria magasinSource){
        this.magasinSource = magasinSource;
    }
    public List<MagasinCriteria> getMagasinSources(){
        return this.magasinSources;
    }

    public void setMagasinSources(List<MagasinCriteria> magasinSources){
        this.magasinSources = magasinSources;
    }
    public MagasinCriteria getMagasinDest(){
        return this.magasinDest;
    }

    public void setMagasinDest(MagasinCriteria magasinDest){
        this.magasinDest = magasinDest;
    }
    public List<MagasinCriteria> getMagasinDests(){
        return this.magasinDests;
    }

    public void setMagasinDests(List<MagasinCriteria> magasinDests){
        this.magasinDests = magasinDests;
    }
}
