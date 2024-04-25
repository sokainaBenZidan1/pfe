package ma.zs.stocky.unit.dao.facade.core.stock;

import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.dao.facade.core.stock.OperationStockDetailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.stock.OperationStock ;
import ma.zs.stocky.bean.core.produit.Produit ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class OperationStockDetailDaoTest {

@Autowired
    private OperationStockDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        OperationStockDetail entity = new OperationStockDetail();
        entity.setId(id);
        underTest.save(entity);
        OperationStockDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        OperationStockDetail entity = new OperationStockDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        OperationStockDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<OperationStockDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<OperationStockDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        OperationStockDetail given = constructSample(1);
        OperationStockDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private OperationStockDetail constructSample(int i) {
		OperationStockDetail given = new OperationStockDetail();
        given.setQte(BigDecimal.TEN);
        given.setProduit(new Produit(1L));
        given.setOperationStock(new OperationStock(1L));
        return given;
    }

}
