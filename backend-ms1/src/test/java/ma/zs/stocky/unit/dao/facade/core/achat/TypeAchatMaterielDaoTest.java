package ma.zs.stocky.unit.dao.facade.core.achat;

import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.dao.facade.core.achat.TypeAchatMaterielDao;

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
public class TypeAchatMaterielDaoTest {

@Autowired
    private TypeAchatMaterielDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeAchatMateriel entity = new TypeAchatMateriel();
        entity.setId(id);
        underTest.save(entity);
        TypeAchatMateriel loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeAchatMateriel entity = new TypeAchatMateriel();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeAchatMateriel loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeAchatMateriel> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeAchatMateriel> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeAchatMateriel given = constructSample(1);
        TypeAchatMateriel saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeAchatMateriel constructSample(int i) {
		TypeAchatMateriel given = new TypeAchatMateriel();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
