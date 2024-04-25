package ma.zs.stocky.unit.dao.facade.core.budget;

import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.dao.facade.core.budget.CompteBudgetaireDao;

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
public class CompteBudgetaireDaoTest {

@Autowired
    private CompteBudgetaireDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        CompteBudgetaire entity = new CompteBudgetaire();
        entity.setId(id);
        underTest.save(entity);
        CompteBudgetaire loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CompteBudgetaire entity = new CompteBudgetaire();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CompteBudgetaire loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CompteBudgetaire> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CompteBudgetaire> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CompteBudgetaire given = constructSample(1);
        CompteBudgetaire saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CompteBudgetaire constructSample(int i) {
		CompteBudgetaire given = new CompteBudgetaire();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        given.setMontantMax(BigDecimal.TEN);
        return given;
    }

}
