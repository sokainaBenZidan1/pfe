package ma.zs.stocky.unit.dao.facade.core.inventaire;

import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.dao.facade.core.inventaire.InventaireDetailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.inventaire.Inventaire ;
import ma.zs.stocky.bean.core.produit.Produit ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class InventaireDetailDaoTest {

@Autowired
    private InventaireDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        InventaireDetail entity = new InventaireDetail();
        entity.setId(id);
        underTest.save(entity);
        InventaireDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        InventaireDetail entity = new InventaireDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        InventaireDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<InventaireDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<InventaireDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        InventaireDetail given = constructSample(1);
        InventaireDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private InventaireDetail constructSample(int i) {
		InventaireDetail given = new InventaireDetail();
        given.setQteCalculee(BigDecimal.TEN);
        given.setQteStock(BigDecimal.TEN);
        given.setEcart(BigDecimal.TEN);
        given.setMagasin("magasin-"+i);
        given.setProduit(new Produit(1L));
        given.setInventaire(new Inventaire(1L));
        return given;
    }

}
