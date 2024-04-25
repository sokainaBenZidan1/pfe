package ma.zs.stocky.unit.dao.facade.core.budget;

import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import ma.zs.stocky.dao.facade.core.budget.BudgetCompteBudgetaireDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.budget.Budget ;
import ma.zs.stocky.bean.core.budget.CompteBudgetaire ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BudgetCompteBudgetaireDaoTest {

@Autowired
    private BudgetCompteBudgetaireDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        BudgetCompteBudgetaire entity = new BudgetCompteBudgetaire();
        entity.setId(id);
        underTest.save(entity);
        BudgetCompteBudgetaire loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        BudgetCompteBudgetaire entity = new BudgetCompteBudgetaire();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        BudgetCompteBudgetaire loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<BudgetCompteBudgetaire> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<BudgetCompteBudgetaire> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        BudgetCompteBudgetaire given = constructSample(1);
        BudgetCompteBudgetaire saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private BudgetCompteBudgetaire constructSample(int i) {
		BudgetCompteBudgetaire given = new BudgetCompteBudgetaire();
        given.setBudget(new Budget(1L));
        given.setCompteBudgetaire(new CompteBudgetaire(1L));
        given.setMontant(BigDecimal.TEN);
        return given;
    }

}
