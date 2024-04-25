package ma.zs.stocky.unit.dao.facade.core.produit;

import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.dao.facade.core.produit.CategorieProduitDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.budget.CompteBudgetaire ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CategorieProduitDaoTest {

@Autowired
    private CategorieProduitDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        CategorieProduit entity = new CategorieProduit();
        entity.setId(id);
        underTest.save(entity);
        CategorieProduit loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategorieProduit entity = new CategorieProduit();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategorieProduit loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategorieProduit> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategorieProduit> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategorieProduit given = constructSample(1);
        CategorieProduit saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategorieProduit constructSample(int i) {
		CategorieProduit given = new CategorieProduit();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        given.setCompteBudgetaire(new CompteBudgetaire(1L));
        return given;
    }

}
