package ma.zs.stocky.unit.service.impl.admin.inventaire;

import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.dao.facade.core.inventaire.InventaireDetailDao;
import ma.zs.stocky.service.impl.admin.inventaire.InventaireDetailAdminServiceImpl;

import ma.zs.stocky.bean.core.inventaire.Inventaire ;
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
class InventaireDetailAdminServiceImplTest {

    @Mock
    private InventaireDetailDao repository;
    private AutoCloseable autoCloseable;
    private InventaireDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new InventaireDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllInventaireDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveInventaireDetail() {
        // Given
        InventaireDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteInventaireDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetInventaireDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example InventaireDetail ID to retrieve
        InventaireDetail expected = new InventaireDetail(); // You need to replace InventaireDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        InventaireDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private InventaireDetail constructSample(int i) {
		InventaireDetail given = new InventaireDetail();
        given.setId(id);
        given.setQteCalculee(BigDecimal.TEN);
        given.setQteCalculee(qteCalculee);
        given.setQteStock(BigDecimal.TEN);
        given.setQteStock(qteStock);
        given.setEcart(BigDecimal.TEN);
        given.setEcart(ecart);
        given.setMagasin("magasin-"+i);
        given.setMagasin(magasin);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        given.setInventaire(new Inventaire(1L));
        given.setInventaire(inventaire);
        return given;
    }

}
