package ma.zs.stocky.unit.service.impl.admin.achat;

import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.dao.facade.core.achat.TypeAchatMaterielDao;
import ma.zs.stocky.service.impl.admin.achat.TypeAchatMaterielAdminServiceImpl;

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
class TypeAchatMaterielAdminServiceImplTest {

    @Mock
    private TypeAchatMaterielDao repository;
    private AutoCloseable autoCloseable;
    private TypeAchatMaterielAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeAchatMaterielAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeAchatMateriel() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeAchatMateriel() {
        // Given
        TypeAchatMateriel toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeAchatMateriel() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeAchatMaterielById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeAchatMateriel ID to retrieve
        TypeAchatMateriel expected = new TypeAchatMateriel(); // You need to replace TypeAchatMateriel with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeAchatMateriel result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeAchatMateriel constructSample(int i) {
		TypeAchatMateriel given = new TypeAchatMateriel();
        given.setId(id);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setCode("code-"+i);
        given.setCode(code);
        return given;
    }

}
