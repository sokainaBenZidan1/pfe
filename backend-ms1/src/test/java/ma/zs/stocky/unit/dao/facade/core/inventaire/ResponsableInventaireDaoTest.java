package ma.zs.stocky.unit.dao.facade.core.inventaire;

import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.dao.facade.core.inventaire.ResponsableInventaireDao;

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
public class ResponsableInventaireDaoTest {

@Autowired
    private ResponsableInventaireDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ResponsableInventaire entity = new ResponsableInventaire();
        entity.setId(id);
        underTest.save(entity);
        ResponsableInventaire loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ResponsableInventaire entity = new ResponsableInventaire();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ResponsableInventaire loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ResponsableInventaire> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ResponsableInventaire> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ResponsableInventaire given = constructSample(1);
        ResponsableInventaire saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ResponsableInventaire constructSample(int i) {
		ResponsableInventaire given = new ResponsableInventaire();
        given.setNom("nom-"+i);
        given.setPrenom("prenom-"+i);
        given.setLogin("login-"+i);
        given.setMdp("mdp-"+i);
        return given;
    }

}
