package ma.zs.stocky.unit.service.impl.admin.produit;

import ma.zs.stocky.bean.core.produit.Produit;
import ma.zs.stocky.dao.facade.core.produit.ProduitDao;
import ma.zs.stocky.service.impl.admin.produit.ProduitAdminServiceImpl;

import ma.zs.stocky.bean.core.produit.CategorieProduit ;
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
class ProduitAdminServiceImplTest {

    @Mock
    private ProduitDao repository;
    private AutoCloseable autoCloseable;
    private ProduitAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProduitAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllProduit() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveProduit() {
        // Given
        Produit toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteProduit() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetProduitById() {
        // Given
        Long idToRetrieve = 1L; // Example Produit ID to retrieve
        Produit expected = new Produit(); // You need to replace Produit with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Produit result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Produit constructSample(int i) {
		Produit given = new Produit();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setCategorieProduit(new CategorieProduit(1L));
        given.setCategorieProduit(categorieProduit);
        return given;
    }

}
