package ma.zs.stocky.unit.service.impl.admin.livraison;

import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.dao.facade.core.livraison.LivraisonDetailDao;
import ma.zs.stocky.service.impl.admin.livraison.LivraisonDetailAdminServiceImpl;

import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.bean.core.livraison.Livraison ;
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
class LivraisonDetailAdminServiceImplTest {

    @Mock
    private LivraisonDetailDao repository;
    private AutoCloseable autoCloseable;
    private LivraisonDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new LivraisonDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllLivraisonDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveLivraisonDetail() {
        // Given
        LivraisonDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteLivraisonDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetLivraisonDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example LivraisonDetail ID to retrieve
        LivraisonDetail expected = new LivraisonDetail(); // You need to replace LivraisonDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        LivraisonDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private LivraisonDetail constructSample(int i) {
		LivraisonDetail given = new LivraisonDetail();
        given.setId(id);
        given.setQte(BigDecimal.TEN);
        given.setQte(qte);
        given.setMagasin(new Magasin(1L));
        given.setMagasin(magasin);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        given.setLivraison(new Livraison(1L));
        given.setLivraison(livraison);
        return given;
    }

}
