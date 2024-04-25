package ma.zs.stocky.unit.dao.facade.core.budget;

import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import ma.zs.stocky.dao.facade.core.budget.BudgetEntiteAdminDao;

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
import ma.zs.stocky.bean.core.budget.Budget ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BudgetEntiteAdminDaoTest {

@Autowired
    private BudgetEntiteAdminDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        BudgetEntiteAdmin entity = new BudgetEntiteAdmin();
        entity.setId(id);
        underTest.save(entity);
        BudgetEntiteAdmin loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        BudgetEntiteAdmin entity = new BudgetEntiteAdmin();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        BudgetEntiteAdmin loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<BudgetEntiteAdmin> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<BudgetEntiteAdmin> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        BudgetEntiteAdmin given = constructSample(1);
        BudgetEntiteAdmin saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private BudgetEntiteAdmin constructSample(int i) {
		BudgetEntiteAdmin given = new BudgetEntiteAdmin();
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setMontantEntite(BigDecimal.TEN);
        given.setMontantInvEntite(BigDecimal.TEN);
        given.setMontantFctEntite(BigDecimal.TEN);
        given.setBudget(new Budget(1L));
        return given;
    }

}
