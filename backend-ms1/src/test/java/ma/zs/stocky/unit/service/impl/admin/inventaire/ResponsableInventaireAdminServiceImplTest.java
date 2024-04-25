package ma.zs.stocky.unit.service.impl.admin.inventaire;

import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.dao.facade.core.inventaire.ResponsableInventaireDao;
import ma.zs.stocky.service.impl.admin.inventaire.ResponsableInventaireAdminServiceImpl;

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
class ResponsableInventaireAdminServiceImplTest {

    @Mock
    private ResponsableInventaireDao repository;
    private AutoCloseable autoCloseable;
    private ResponsableInventaireAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ResponsableInventaireAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllResponsableInventaire() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveResponsableInventaire() {
        // Given
        ResponsableInventaire toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteResponsableInventaire() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetResponsableInventaireById() {
        // Given
        Long idToRetrieve = 1L; // Example ResponsableInventaire ID to retrieve
        ResponsableInventaire expected = new ResponsableInventaire(); // You need to replace ResponsableInventaire with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ResponsableInventaire result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ResponsableInventaire constructSample(int i) {
		ResponsableInventaire given = new ResponsableInventaire();
        given.setId(id);
        given.setNom("nom-"+i);
        given.setNom(nom);
        given.setPrenom("prenom-"+i);
        given.setPrenom(prenom);
        given.setLogin("login-"+i);
        given.setLogin(login);
        given.setMdp("mdp-"+i);
        given.setMdp(mdp);
        return given;
    }

}
