package ma.zs.stocky.unit.dao.facade.core.stock;

import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.dao.facade.core.stock.MagasinDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MagasinDaoTest {

@Autowired
    private MagasinDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Magasin entity = new Magasin();
        entity.setId(id);
        underTest.save(entity);
        Magasin loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Magasin entity = new Magasin();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Magasin loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Magasin> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Magasin> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Magasin given = constructSample(1);
        Magasin saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Magasin constructSample(int i) {
		Magasin given = new Magasin();
        given.setCode("code-"+i);
        given.setAdresse("adresse-"+i);
        return given;
    }

}
