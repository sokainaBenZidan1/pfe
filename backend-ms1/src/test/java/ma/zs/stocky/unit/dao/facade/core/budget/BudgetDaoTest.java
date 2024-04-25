package ma.zs.stocky.unit.dao.facade.core.budget;

import ma.zs.stocky.bean.core.budget.Budget;
import ma.zs.stocky.dao.facade.core.budget.BudgetDao;

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
public class BudgetDaoTest {

@Autowired
    private BudgetDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Budget entity = new Budget();
        entity.setId(id);
        underTest.save(entity);
        Budget loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Budget entity = new Budget();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Budget loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Budget> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Budget> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Budget given = constructSample(1);
        Budget saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Budget constructSample(int i) {
		Budget given = new Budget();
        given.setDateBudget(LocalDateTime.now());
        given.setMontant(BigDecimal.TEN);
        given.setMontantInvestissement(BigDecimal.TEN);
        given.setMontantFonction(BigDecimal.TEN);
        return given;
    }

}
