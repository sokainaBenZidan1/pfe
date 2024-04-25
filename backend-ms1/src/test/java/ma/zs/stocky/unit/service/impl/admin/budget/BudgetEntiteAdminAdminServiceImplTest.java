package ma.zs.stocky.unit.service.impl.admin.budget;

import ma.zs.stocky.bean.core.budget.BudgetEntiteAdmin;
import ma.zs.stocky.dao.facade.core.budget.BudgetEntiteAdminDao;
import ma.zs.stocky.service.impl.admin.budget.BudgetEntiteAdminAdminServiceImpl;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.bean.core.budget.Budget ;
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
class BudgetEntiteAdminAdminServiceImplTest {

    @Mock
    private BudgetEntiteAdminDao repository;
    private AutoCloseable autoCloseable;
    private BudgetEntiteAdminAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new BudgetEntiteAdminAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllBudgetEntiteAdmin() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveBudgetEntiteAdmin() {
        // Given
        BudgetEntiteAdmin toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteBudgetEntiteAdmin() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetBudgetEntiteAdminById() {
        // Given
        Long idToRetrieve = 1L; // Example BudgetEntiteAdmin ID to retrieve
        BudgetEntiteAdmin expected = new BudgetEntiteAdmin(); // You need to replace BudgetEntiteAdmin with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        BudgetEntiteAdmin result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private BudgetEntiteAdmin constructSample(int i) {
		BudgetEntiteAdmin given = new BudgetEntiteAdmin();
        given.setId(id);
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setEntiteAdmin(entiteAdmin);
        given.setMontantEntite(BigDecimal.TEN);
        given.setMontantEntite(montantEntite);
        given.setMontantInvEntite(BigDecimal.TEN);
        given.setMontantInvEntite(montantInvEntite);
        given.setMontantFctEntite(BigDecimal.TEN);
        given.setMontantFctEntite(montantFctEntite);
        given.setBudget(new Budget(1L));
        given.setBudget(budget);
        return given;
    }

}
