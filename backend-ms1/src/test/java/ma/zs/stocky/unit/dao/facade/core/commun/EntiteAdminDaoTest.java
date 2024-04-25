package ma.zs.stocky.unit.dao.facade.core.commun;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.dao.facade.core.commun.EntiteAdminDao;

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
public class EntiteAdminDaoTest {

@Autowired
    private EntiteAdminDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        EntiteAdmin entity = new EntiteAdmin();
        entity.setCode(code);
        underTest.save(entity);
        EntiteAdmin loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        EntiteAdmin entity = new EntiteAdmin();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        EntiteAdmin loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        EntiteAdmin entity = new EntiteAdmin();
        entity.setId(id);
        underTest.save(entity);
        EntiteAdmin loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EntiteAdmin entity = new EntiteAdmin();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EntiteAdmin loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EntiteAdmin> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EntiteAdmin> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EntiteAdmin given = constructSample(1);
        EntiteAdmin saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EntiteAdmin constructSample(int i) {
		EntiteAdmin given = new EntiteAdmin();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
