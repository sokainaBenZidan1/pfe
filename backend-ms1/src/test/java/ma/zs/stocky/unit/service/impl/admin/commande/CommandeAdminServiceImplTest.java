package ma.zs.stocky.unit.service.impl.admin.commande;

import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.dao.facade.core.commande.CommandeDao;
import ma.zs.stocky.service.impl.admin.commande.CommandeAdminServiceImpl;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.bean.core.commande.Commande ;
import ma.zs.stocky.bean.core.commande.CommandeDetail ;
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
class CommandeAdminServiceImplTest {

    @Mock
    private CommandeDao repository;
    private AutoCloseable autoCloseable;
    private CommandeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CommandeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCommande() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCommande() {
        // Given
        Commande toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCommande() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCommandeById() {
        // Given
        Long idToRetrieve = 1L; // Example Commande ID to retrieve
        Commande expected = new Commande(); // You need to replace Commande with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Commande result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Commande constructSample(int i) {
		Commande given = new Commande();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setTotal(BigDecimal.TEN);
        given.setTotal(total);
        given.setTotalPaye(BigDecimal.TEN);
        given.setTotalPaye(totalPaye);
        given.setDateCommande(LocalDateTime.now());
        given.setDateCommande(dateCommande);
        List<CommandeDetail> commandeDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                CommandeDetail element = new CommandeDetail();
                                                element.setId((long)id);
                                                element.setPrix(new BigDecimal(1*10));
                                                element.setQte(new BigDecimal(2*10));
                                                element.setCommande(new Commande(Long.valueOf(3)));
                                                element.setProduit(new Produit(Long.valueOf(4)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setCommandeDetails(commandeDetails);
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setEntiteAdmin(entiteAdmin);
        return given;
    }

}
