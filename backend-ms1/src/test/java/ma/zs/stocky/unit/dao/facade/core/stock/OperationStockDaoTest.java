package ma.zs.stocky.unit.dao.facade.core.stock;

import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.dao.facade.core.stock.OperationStockDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.stock.Magasin ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class OperationStockDaoTest {

@Autowired
    private OperationStockDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        OperationStock entity = new OperationStock();
        entity.setRef(ref);
        underTest.save(entity);
        OperationStock loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        OperationStock entity = new OperationStock();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        OperationStock loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        OperationStock entity = new OperationStock();
        entity.setId(id);
        underTest.save(entity);
        OperationStock loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        OperationStock entity = new OperationStock();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        OperationStock loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<OperationStock> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<OperationStock> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        OperationStock given = constructSample(1);
        OperationStock saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private OperationStock constructSample(int i) {
		OperationStock given = new OperationStock();
        given.setRef("ref-"+i);
        given.setDateOS(LocalDateTime.now());
        given.setDiscription("discription-"+i);
        given.setMagasinSource(new Magasin(1L));
        given.setMagasinDest(new Magasin(1L));
        return given;
    }

}
