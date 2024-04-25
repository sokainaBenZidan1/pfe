package ma.zs.stocky.unit.dao.facade.core.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.Etat;
import ma.zs.stocky.dao.facade.core.expressionbesion.EtatDao;

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
public class EtatDaoTest {

@Autowired
    private EtatDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Etat entity = new Etat();
        entity.setCode(code);
        underTest.save(entity);
        Etat loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Etat entity = new Etat();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Etat loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Etat entity = new Etat();
        entity.setId(id);
        underTest.save(entity);
        Etat loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Etat entity = new Etat();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Etat loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Etat> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Etat> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Etat given = constructSample(1);
        Etat saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Etat constructSample(int i) {
		Etat given = new Etat();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
