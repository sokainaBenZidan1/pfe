package ma.zs.stocky.unit.service.impl.admin.inventaire;

import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.dao.facade.core.inventaire.InventaireDao;
import ma.zs.stocky.service.impl.admin.inventaire.InventaireAdminServiceImpl;

import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire ;
import ma.zs.stocky.bean.core.inventaire.InventaireDetail ;
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
class InventaireAdminServiceImplTest {

    @Mock
    private InventaireDao repository;
    private AutoCloseable autoCloseable;
    private InventaireAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new InventaireAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllInventaire() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveInventaire() {
        // Given
        Inventaire toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteInventaire() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetInventaireById() {
        // Given
        Long idToRetrieve = 1L; // Example Inventaire ID to retrieve
        Inventaire expected = new Inventaire(); // You need to replace Inventaire with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Inventaire result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Inventaire constructSample(int i) {
		Inventaire given = new Inventaire();
        given.setId(id);
        given.setDateDebut(LocalDateTime.now());
        given.setDateDebut(dateDebut);
        given.setDateFin(LocalDateTime.now());
        given.setDateFin(dateFin);
        given.setResponsableInv(new ResponsableInventaire(1L));
        given.setResponsableInv(responsableInv);
        List<InventaireDetail> inventaireDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                InventaireDetail element = new InventaireDetail();
                                                element.setId((long)id);
                                                element.setQteCalculee(new BigDecimal(1*10));
                                                element.setQteStock(new BigDecimal(2*10));
                                                element.setEcart(new BigDecimal(3*10));
                                                element.setMagasin("magasin"+id);
                                                element.setProduit(new Produit(Long.valueOf(5)));
                                                element.setInventaire(new Inventaire(Long.valueOf(6)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setInventaireDetails(inventaireDetails);
        return given;
    }

}
