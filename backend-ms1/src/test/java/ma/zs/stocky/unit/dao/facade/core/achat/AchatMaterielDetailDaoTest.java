package ma.zs.stocky.unit.dao.facade.core.achat;

import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.dao.facade.core.achat.AchatMaterielDetailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.produit.Produit ;
import ma.zs.stocky.bean.core.achat.AchatMateriel ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AchatMaterielDetailDaoTest {

@Autowired
    private AchatMaterielDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        AchatMaterielDetail entity = new AchatMaterielDetail();
        entity.setId(id);
        underTest.save(entity);
        AchatMaterielDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        AchatMaterielDetail entity = new AchatMaterielDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        AchatMaterielDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<AchatMaterielDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<AchatMaterielDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        AchatMaterielDetail given = constructSample(1);
        AchatMaterielDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private AchatMaterielDetail constructSample(int i) {
		AchatMaterielDetail given = new AchatMaterielDetail();
        given.setProduit(new Produit(1L));
        given.setQteAchetee(BigDecimal.TEN);
        given.setQteRecue(BigDecimal.TEN);
        given.setQteLivree(BigDecimal.TEN);
        given.setAchatMateriel(new AchatMateriel(1L));
        return given;
    }

}
