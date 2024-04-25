package ma.zs.stocky.unit.service.impl.admin.produit;

import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.dao.facade.core.produit.CategorieProduitDao;
import ma.zs.stocky.service.impl.admin.produit.CategorieProduitAdminServiceImpl;

import ma.zs.stocky.bean.core.budget.CompteBudgetaire ;
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
class CategorieProduitAdminServiceImplTest {

    @Mock
    private CategorieProduitDao repository;
    private AutoCloseable autoCloseable;
    private CategorieProduitAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategorieProduitAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategorieProduit() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategorieProduit() {
        // Given
        CategorieProduit toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategorieProduit() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategorieProduitById() {
        // Given
        Long idToRetrieve = 1L; // Example CategorieProduit ID to retrieve
        CategorieProduit expected = new CategorieProduit(); // You need to replace CategorieProduit with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategorieProduit result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategorieProduit constructSample(int i) {
		CategorieProduit given = new CategorieProduit();
        given.setId(id);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setCompteBudgetaire(new CompteBudgetaire(1L));
        given.setCompteBudgetaire(compteBudgetaire);
        return given;
    }

}
