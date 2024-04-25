package ma.zs.stocky.unit.dao.facade.core.commun;

import ma.zs.stocky.bean.core.commun.Employe;
import ma.zs.stocky.dao.facade.core.commun.EmployeDao;

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
public class EmployeDaoTest {

@Autowired
    private EmployeDao underTest;

    @Test
    void shouldFindByNom(){
        String nom = "nom-1";
        Employe entity = new Employe();
        entity.setNom(nom);
        underTest.save(entity);
        Employe loaded = underTest.findByNom(nom);
        assertThat(loaded.getNom()).isEqualTo(nom);
    }

    @Test
    void shouldDeleteByNom() {
        String nom = "nom-1";
        Employe entity = new Employe();
        entity.setNom(nom);
        underTest.save(entity);

        int result = underTest.deleteByNom(nom);

        Employe loaded = underTest.findByNom(nom);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Employe entity = new Employe();
        entity.setId(id);
        underTest.save(entity);
        Employe loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Employe entity = new Employe();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Employe loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Employe> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Employe> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Employe given = constructSample(1);
        Employe saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Employe constructSample(int i) {
		Employe given = new Employe();
        given.setNom("nom-"+i);
        given.setPrenom("prenom-"+i);
        given.setEntiteAdmin(new EntiteAdmin(1L));
        return given;
    }

}
