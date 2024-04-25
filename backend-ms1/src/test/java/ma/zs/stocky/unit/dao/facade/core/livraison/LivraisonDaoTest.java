package ma.zs.stocky.unit.dao.facade.core.livraison;

import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.dao.facade.core.livraison.LivraisonDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.reception.Reception ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LivraisonDaoTest {

@Autowired
    private LivraisonDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Livraison entity = new Livraison();
        entity.setRef(ref);
        underTest.save(entity);
        Livraison loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Livraison entity = new Livraison();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Livraison loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Livraison entity = new Livraison();
        entity.setId(id);
        underTest.save(entity);
        Livraison loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Livraison entity = new Livraison();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Livraison loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Livraison> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Livraison> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Livraison given = constructSample(1);
        Livraison saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Livraison constructSample(int i) {
		Livraison given = new Livraison();
        given.setRef("ref-"+i);
        given.setDatelivraison(LocalDateTime.now());
        given.setReception(new Reception(1L));
        return given;
    }

}
