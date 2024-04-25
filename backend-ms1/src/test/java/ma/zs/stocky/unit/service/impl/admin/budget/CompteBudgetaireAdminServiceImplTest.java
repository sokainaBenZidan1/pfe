package ma.zs.stocky.unit.service.impl.admin.budget;

import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.dao.facade.core.budget.CompteBudgetaireDao;
import ma.zs.stocky.service.impl.admin.budget.CompteBudgetaireAdminServiceImpl;

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
class CompteBudgetaireAdminServiceImplTest {

    @Mock
    private CompteBudgetaireDao repository;
    private AutoCloseable autoCloseable;
    private CompteBudgetaireAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CompteBudgetaireAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCompteBudgetaire() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCompteBudgetaire() {
        // Given
        CompteBudgetaire toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCompteBudgetaire() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCompteBudgetaireById() {
        // Given
        Long idToRetrieve = 1L; // Example CompteBudgetaire ID to retrieve
        CompteBudgetaire expected = new CompteBudgetaire(); // You need to replace CompteBudgetaire with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CompteBudgetaire result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CompteBudgetaire constructSample(int i) {
		CompteBudgetaire given = new CompteBudgetaire();
        given.setId(id);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setMontantMax(BigDecimal.TEN);
        given.setMontantMax(montantMax);
        return given;
    }

}
