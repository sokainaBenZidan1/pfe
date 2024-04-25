package ma.zs.stocky.unit.service.impl.admin.budget;

import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import ma.zs.stocky.dao.facade.core.budget.BudgetCompteBudgetaireDao;
import ma.zs.stocky.service.impl.admin.budget.BudgetCompteBudgetaireAdminServiceImpl;

import ma.zs.stocky.bean.core.budget.Budget ;
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
class BudgetCompteBudgetaireAdminServiceImplTest {

    @Mock
    private BudgetCompteBudgetaireDao repository;
    private AutoCloseable autoCloseable;
    private BudgetCompteBudgetaireAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new BudgetCompteBudgetaireAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllBudgetCompteBudgetaire() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveBudgetCompteBudgetaire() {
        // Given
        BudgetCompteBudgetaire toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteBudgetCompteBudgetaire() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetBudgetCompteBudgetaireById() {
        // Given
        Long idToRetrieve = 1L; // Example BudgetCompteBudgetaire ID to retrieve
        BudgetCompteBudgetaire expected = new BudgetCompteBudgetaire(); // You need to replace BudgetCompteBudgetaire with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        BudgetCompteBudgetaire result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private BudgetCompteBudgetaire constructSample(int i) {
		BudgetCompteBudgetaire given = new BudgetCompteBudgetaire();
        given.setId(id);
        given.setBudget(new Budget(1L));
        given.setBudget(budget);
        given.setCompteBudgetaire(new CompteBudgetaire(1L));
        given.setCompteBudgetaire(compteBudgetaire);
        given.setMontant(BigDecimal.TEN);
        given.setMontant(montant);
        return given;
    }

}
