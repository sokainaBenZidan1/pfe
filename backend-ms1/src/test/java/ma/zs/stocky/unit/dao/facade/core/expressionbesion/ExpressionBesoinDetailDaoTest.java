package ma.zs.stocky.unit.dao.facade.core.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.dao.facade.core.expressionbesion.ExpressionBesoinDetailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin ;
import ma.zs.stocky.bean.core.produit.Produit ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ExpressionBesoinDetailDaoTest {

@Autowired
    private ExpressionBesoinDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ExpressionBesoinDetail entity = new ExpressionBesoinDetail();
        entity.setId(id);
        underTest.save(entity);
        ExpressionBesoinDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ExpressionBesoinDetail entity = new ExpressionBesoinDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ExpressionBesoinDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ExpressionBesoinDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ExpressionBesoinDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ExpressionBesoinDetail given = constructSample(1);
        ExpressionBesoinDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ExpressionBesoinDetail constructSample(int i) {
		ExpressionBesoinDetail given = new ExpressionBesoinDetail();
        given.setQteDemandee(BigDecimal.TEN);
        given.setQteAccordee(BigDecimal.TEN);
        given.setQteLivre(BigDecimal.TEN);
        given.setExpressionBesoin(new ExpressionBesoin(1L));
        given.setProduit(new Produit(1L));
        return given;
    }

}
