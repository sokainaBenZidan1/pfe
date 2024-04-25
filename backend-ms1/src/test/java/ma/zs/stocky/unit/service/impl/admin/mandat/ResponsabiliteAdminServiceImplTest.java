package ma.zs.stocky.unit.service.impl.admin.mandat;

import ma.zs.stocky.bean.core.mandat.Responsabilite;
import ma.zs.stocky.dao.facade.core.mandat.ResponsabiliteDao;
import ma.zs.stocky.service.impl.admin.mandat.ResponsabiliteAdminServiceImpl;

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
class ResponsabiliteAdminServiceImplTest {

    @Mock
    private ResponsabiliteDao repository;
    private AutoCloseable autoCloseable;
    private ResponsabiliteAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ResponsabiliteAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllResponsabilite() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveResponsabilite() {
        // Given
        Responsabilite toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteResponsabilite() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetResponsabiliteById() {
        // Given
        Long idToRetrieve = 1L; // Example Responsabilite ID to retrieve
        Responsabilite expected = new Responsabilite(); // You need to replace Responsabilite with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Responsabilite result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Responsabilite constructSample(int i) {
		Responsabilite given = new Responsabilite();
        given.setId(id);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setCode("code-"+i);
        given.setCode(code);
        return given;
    }

}
