package ma.zs.stocky.unit.dao.facade.core.mandat;

import ma.zs.stocky.bean.core.mandat.Responsabilite;
import ma.zs.stocky.dao.facade.core.mandat.ResponsabiliteDao;

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
public class ResponsabiliteDaoTest {

@Autowired
    private ResponsabiliteDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Responsabilite entity = new Responsabilite();
        entity.setId(id);
        underTest.save(entity);
        Responsabilite loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Responsabilite entity = new Responsabilite();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Responsabilite loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Responsabilite> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Responsabilite> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Responsabilite given = constructSample(1);
        Responsabilite saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Responsabilite constructSample(int i) {
		Responsabilite given = new Responsabilite();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
