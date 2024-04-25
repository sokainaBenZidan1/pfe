package ma.zs.stocky.unit.dao.facade.core.reception;

import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.dao.facade.core.reception.ReceptionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.commande.Commande ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReceptionDaoTest {

@Autowired
    private ReceptionDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Reception entity = new Reception();
        entity.setRef(ref);
        underTest.save(entity);
        Reception loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Reception entity = new Reception();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Reception loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Reception entity = new Reception();
        entity.setId(id);
        underTest.save(entity);
        Reception loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Reception entity = new Reception();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Reception loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Reception> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Reception> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Reception given = constructSample(1);
        Reception saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Reception constructSample(int i) {
		Reception given = new Reception();
        given.setRef("ref-"+i);
        given.setDateReception(LocalDateTime.now());
        given.setLibelle("libelle-"+i);
        given.setCommande(new Commande(1L));
        return given;
    }

}
