package ma.zs.stocky.unit.dao.facade.core.livraison;

import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.dao.facade.core.livraison.LivraisonDetailDao;

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
import ma.zs.stocky.bean.core.livraison.Livraison ;
import ma.zs.stocky.bean.core.produit.Produit ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LivraisonDetailDaoTest {

@Autowired
    private LivraisonDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        LivraisonDetail entity = new LivraisonDetail();
        entity.setId(id);
        underTest.save(entity);
        LivraisonDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        LivraisonDetail entity = new LivraisonDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        LivraisonDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<LivraisonDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<LivraisonDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        LivraisonDetail given = constructSample(1);
        LivraisonDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private LivraisonDetail constructSample(int i) {
		LivraisonDetail given = new LivraisonDetail();
        given.setQte(BigDecimal.TEN);
        given.setMagasin(new Magasin(1L));
        given.setProduit(new Produit(1L));
        given.setLivraison(new Livraison(1L));
        return given;
    }

}
