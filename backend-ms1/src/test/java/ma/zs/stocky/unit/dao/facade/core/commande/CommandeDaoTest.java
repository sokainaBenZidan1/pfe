package ma.zs.stocky.unit.dao.facade.core.commande;

import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.dao.facade.core.commande.CommandeDao;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CommandeDaoTest {

@Autowired
    private CommandeDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Commande entity = new Commande();
        entity.setRef(ref);
        underTest.save(entity);
        Commande loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Commande entity = new Commande();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Commande loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Commande entity = new Commande();
        entity.setId(id);
        underTest.save(entity);
        Commande loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Commande entity = new Commande();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Commande loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Commande> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Commande> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Commande given = constructSample(1);
        Commande saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Commande constructSample(int i) {
		Commande given = new Commande();
        given.setRef("ref-"+i);
        given.setTotal(BigDecimal.TEN);
        given.setTotalPaye(BigDecimal.TEN);
        given.setDateCommande(LocalDateTime.now());
        given.setEntiteAdmin(new EntiteAdmin(1L));
        return given;
    }

}
