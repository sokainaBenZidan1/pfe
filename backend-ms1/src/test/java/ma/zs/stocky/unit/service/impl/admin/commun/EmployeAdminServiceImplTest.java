package ma.zs.stocky.unit.service.impl.admin.commun;

import ma.zs.stocky.bean.core.commun.Employe;
import ma.zs.stocky.dao.facade.core.commun.EmployeDao;
import ma.zs.stocky.service.impl.admin.commun.EmployeAdminServiceImpl;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
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
class EmployeAdminServiceImplTest {

    @Mock
    private EmployeDao repository;
    private AutoCloseable autoCloseable;
    private EmployeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmployeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEmploye() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEmploye() {
        // Given
        Employe toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEmploye() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEmployeById() {
        // Given
        Long idToRetrieve = 1L; // Example Employe ID to retrieve
        Employe expected = new Employe(); // You need to replace Employe with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Employe result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Employe constructSample(int i) {
		Employe given = new Employe();
        given.setId(id);
        given.setNom("nom-"+i);
        given.setNom(nom);
        given.setPrenom("prenom-"+i);
        given.setPrenom(prenom);
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setEntiteAdmin(entiteAdmin);
        return given;
    }

}
