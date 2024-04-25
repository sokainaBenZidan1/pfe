package ma.zs.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commun.Employe;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.commun.Employe;
import java.util.List;


@Repository
public interface EmployeDao extends AbstractRepository<Employe,Long>  {
    Employe findByNom(String nom);
    int deleteByNom(String nom);

    List<Employe> findByEntiteAdminId(Long id);
    int deleteByEntiteAdminId(Long id);
    long countByEntiteAdminCode(String code);

    @Query("SELECT NEW Employe(item.id,item.nom) FROM Employe item")
    List<Employe> findAllOptimized();

}
