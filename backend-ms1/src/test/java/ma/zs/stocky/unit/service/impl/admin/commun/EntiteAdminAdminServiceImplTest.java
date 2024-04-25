package ma.zs.stocky.unit.service.impl.admin.commun;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.dao.facade.core.commun.EntiteAdminDao;
import ma.zs.stocky.service.impl.admin.commun.EntiteAdminAdminServiceImpl;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
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
class EntiteAdminAdminServiceImplTest {

    @Mock
    private EntiteAdminDao repository;
    private AutoCloseable autoCloseable;
    private EntiteAdminAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EntiteAdminAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEntiteAdmin() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEntiteAdmin() {
        // Given
        EntiteAdmin toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEntiteAdmin() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEntiteAdminById() {
        // Given
        Long idToRetrieve = 1L; // Example EntiteAdmin ID to retrieve
        EntiteAdmin expected = new EntiteAdmin(); // You need to replace EntiteAdmin with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EntiteAdmin result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EntiteAdmin constructSample(int i) {
		EntiteAdmin given = new EntiteAdmin();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        List<Employe> employe = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Employe element = new Employe();
                                                element.setId((long)id);
                                                element.setNom("nom"+id);
                                                element.setPrenom("prenom"+id);
                                                element.setEntiteAdmin(new EntiteAdmin(Long.valueOf(3)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setEmploye(employe);
        return given;
    }

}
