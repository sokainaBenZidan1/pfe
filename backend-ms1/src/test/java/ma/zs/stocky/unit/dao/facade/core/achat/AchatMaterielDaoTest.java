package ma.zs.stocky.unit.dao.facade.core.achat;

import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.dao.facade.core.achat.AchatMaterielDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.achat.TypeAchatMateriel ;
import ma.zs.stocky.bean.core.budget.Budget ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AchatMaterielDaoTest {

@Autowired
    private AchatMaterielDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        AchatMateriel entity = new AchatMateriel();
        entity.setId(id);
        underTest.save(entity);
        AchatMateriel loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        AchatMateriel entity = new AchatMateriel();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        AchatMateriel loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<AchatMateriel> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<AchatMateriel> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        AchatMateriel given = constructSample(1);
        AchatMateriel saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private AchatMateriel constructSample(int i) {
		AchatMateriel given = new AchatMateriel();
        given.setBudget(new Budget(1L));
        given.setMontantTotal(BigDecimal.TEN);
        given.setDateAchat(LocalDateTime.now());
        given.setTypeAchatMateriel(new TypeAchatMateriel(1L));
        return given;
    }

}
