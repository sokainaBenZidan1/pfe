package ma.zs.stocky.unit.dao.facade.core.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.dao.facade.core.expressionbesion.ExpressionBesoinDao;

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
import ma.zs.stocky.bean.core.expressionbesion.Etat ;
import ma.zs.stocky.bean.core.commun.Employe ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ExpressionBesoinDaoTest {

@Autowired
    private ExpressionBesoinDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ExpressionBesoin entity = new ExpressionBesoin();
        entity.setId(id);
        underTest.save(entity);
        ExpressionBesoin loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ExpressionBesoin entity = new ExpressionBesoin();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ExpressionBesoin loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ExpressionBesoin> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ExpressionBesoin> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ExpressionBesoin given = constructSample(1);
        ExpressionBesoin saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ExpressionBesoin constructSample(int i) {
		ExpressionBesoin given = new ExpressionBesoin();
        given.setEmploye(new Employe(1L));
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setDescription("description-"+i);
        given.setDateExpression(LocalDateTime.now());
        given.setEtat(new Etat(1L));
        return given;
    }

}
