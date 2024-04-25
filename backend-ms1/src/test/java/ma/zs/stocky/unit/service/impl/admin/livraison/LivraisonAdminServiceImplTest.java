package ma.zs.stocky.unit.service.impl.admin.livraison;

import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.dao.facade.core.livraison.LivraisonDao;
import ma.zs.stocky.service.impl.admin.livraison.LivraisonAdminServiceImpl;

import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.bean.core.reception.Reception ;
import ma.zs.stocky.bean.core.livraison.Livraison ;
import ma.zs.stocky.bean.core.livraison.LivraisonDetail ;
import ma.zs.stocky.bean.core.produit.Produit ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class LivraisonAdminServiceImplTest {

    @Mock
    private LivraisonDao repository;
    private AutoCloseable autoCloseable;
    private LivraisonAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new LivraisonAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllLivraison() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveLivraison() {
        // Given
        Livraison toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteLivraison() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetLivraisonById() {
        // Given
        Long idToRetrieve = 1L; // Example Livraison ID to retrieve
        Livraison expected = new Livraison(); // You need to replace Livraison with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Livraison result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Livraison constructSample(int i) {
		Livraison given = new Livraison();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setDatelivraison(LocalDateTime.now());
        given.setDatelivraison(datelivraison);
        given.setReception(new Reception(1L));
        given.setReception(reception);
        List<LivraisonDetail> livraisonDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                LivraisonDetail element = new LivraisonDetail();
                                                element.setId((long)id);
                                                element.setQte(new BigDecimal(1*10));
                                                element.setMagasin(new Magasin(Long.valueOf(2)));
                                                element.setProduit(new Produit(Long.valueOf(3)));
                                                element.setLivraison(new Livraison(Long.valueOf(4)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setLivraisonDetails(livraisonDetails);
        return given;
    }

}
