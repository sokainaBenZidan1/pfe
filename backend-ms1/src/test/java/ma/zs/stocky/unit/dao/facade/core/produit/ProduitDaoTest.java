package ma.zs.stocky.unit.dao.facade.core.produit;

import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.dao.facade.core.produit.ProduitDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.produit.CategorieProduit ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProduitDaoTest {

@Autowired
    private ProduitDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Produit entity = new Produit();
        entity.setCode(code);
        underTest.save(entity);
        Produit loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Produit entity = new Produit();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Produit loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Produit entity = new Produit();
        entity.setId(id);
        underTest.save(entity);
        Produit loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Produit entity = new Produit();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Produit loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Produit> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Produit> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Produit given = constructSample(1);
        Produit saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Produit constructSample(int i) {
		Produit given = new Produit();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setCategorieProduit(new CategorieProduit(1L));
        return given;
    }

}
