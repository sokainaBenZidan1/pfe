package ma.zs.stocky.unit.dao.facade.core.reception;

import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.dao.facade.core.reception.ReceptionDetailDao;

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
import ma.zs.stocky.bean.core.reception.Reception ;
import ma.zs.stocky.bean.core.produit.Produit ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReceptionDetailDaoTest {

@Autowired
    private ReceptionDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ReceptionDetail entity = new ReceptionDetail();
        entity.setId(id);
        underTest.save(entity);
        ReceptionDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ReceptionDetail entity = new ReceptionDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ReceptionDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ReceptionDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ReceptionDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ReceptionDetail given = constructSample(1);
        ReceptionDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ReceptionDetail constructSample(int i) {
		ReceptionDetail given = new ReceptionDetail();
        given.setQte(BigDecimal.TEN);
        given.setMagasin(new Magasin(1L));
        given.setProduit(new Produit(1L));
        given.setReception(new Reception(1L));
        return given;
    }

}
