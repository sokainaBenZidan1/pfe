package ma.zs.stocky.unit.dao.facade.core.inventaire;

import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.dao.facade.core.inventaire.InventaireDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class InventaireDaoTest {

@Autowired
    private InventaireDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Inventaire entity = new Inventaire();
        entity.setId(id);
        underTest.save(entity);
        Inventaire loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Inventaire entity = new Inventaire();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Inventaire loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Inventaire> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Inventaire> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Inventaire given = constructSample(1);
        Inventaire saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Inventaire constructSample(int i) {
		Inventaire given = new Inventaire();
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setResponsableInv(new ResponsableInventaire(1L));
        return given;
    }

}
