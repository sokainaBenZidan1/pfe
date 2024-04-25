package ma.zs.stocky.unit.service.impl.admin.mandat;

import ma.zs.stocky.bean.core.mandat.Mandat;
import ma.zs.stocky.dao.facade.core.mandat.MandatDao;
import ma.zs.stocky.service.impl.admin.mandat.MandatAdminServiceImpl;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.bean.core.mandat.Responsabilite ;
import ma.zs.stocky.bean.core.commun.Employe ;
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
class MandatAdminServiceImplTest {

    @Mock
    private MandatDao repository;
    private AutoCloseable autoCloseable;
    private MandatAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new MandatAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllMandat() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveMandat() {
        // Given
        Mandat toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteMandat() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetMandatById() {
        // Given
        Long idToRetrieve = 1L; // Example Mandat ID to retrieve
        Mandat expected = new Mandat(); // You need to replace Mandat with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Mandat result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Mandat constructSample(int i) {
		Mandat given = new Mandat();
        given.setId(id);
        given.setEmploye(new Employe(1L));
        given.setEmploye(employe);
        given.setDateDebut(LocalDateTime.now());
        given.setDateDebut(dateDebut);
        given.setDateFin(LocalDateTime.now());
        given.setDateFin(dateFin);
        given.setResponsabilite(new Responsabilite(1L));
        given.setResponsabilite(responsabilite);
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setEntiteAdmin(entiteAdmin);
        return given;
    }

}
