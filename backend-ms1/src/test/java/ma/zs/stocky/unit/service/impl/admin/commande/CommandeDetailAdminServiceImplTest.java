package ma.zs.stocky.unit.service.impl.admin.commande;

import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.dao.facade.core.commande.CommandeDetailDao;
import ma.zs.stocky.service.impl.admin.commande.CommandeDetailAdminServiceImpl;

import ma.zs.stocky.bean.core.commande.Commande ;
import ma.zs.stocky.bean.core.produit.Produit ;
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
class CommandeDetailAdminServiceImplTest {

    @Mock
    private CommandeDetailDao repository;
    private AutoCloseable autoCloseable;
    private CommandeDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CommandeDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCommandeDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCommandeDetail() {
        // Given
        CommandeDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCommandeDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCommandeDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example CommandeDetail ID to retrieve
        CommandeDetail expected = new CommandeDetail(); // You need to replace CommandeDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CommandeDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CommandeDetail constructSample(int i) {
		CommandeDetail given = new CommandeDetail();
        given.setId(id);
        given.setPrix(BigDecimal.TEN);
        given.setPrix(prix);
        given.setQte(BigDecimal.TEN);
        given.setQte(qte);
        given.setCommande(new Commande(1L));
        given.setCommande(commande);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        return given;
    }

}
