package ma.zs.stocky.unit.dao.facade.core.mandat;

import ma.zs.stocky.bean.core.mandat.Mandat;
import ma.zs.stocky.dao.facade.core.mandat.MandatDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.bean.core.mandat.Responsabilite ;
import ma.zs.stocky.bean.core.commun.Employe ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MandatDaoTest {

@Autowired
    private MandatDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Mandat entity = new Mandat();
        entity.setId(id);
        underTest.save(entity);
        Mandat loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Mandat entity = new Mandat();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Mandat loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Mandat> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Mandat> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Mandat given = constructSample(1);
        Mandat saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Mandat constructSample(int i) {
		Mandat given = new Mandat();
        given.setEmploye(new Employe(1L));
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setResponsabilite(new Responsabilite(1L));
        given.setEntiteAdmin(new EntiteAdmin(1L));
        return given;
    }

}
