package ma.zs.stocky.unit.service.impl.admin.reception;

import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.dao.facade.core.reception.ReceptionDao;
import ma.zs.stocky.service.impl.admin.reception.ReceptionAdminServiceImpl;

import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.bean.core.commande.Commande ;
import ma.zs.stocky.bean.core.reception.Reception ;
import ma.zs.stocky.bean.core.produit.Produit ;
import ma.zs.stocky.bean.core.reception.ReceptionDetail ;
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
class ReceptionAdminServiceImplTest {

    @Mock
    private ReceptionDao repository;
    private AutoCloseable autoCloseable;
    private ReceptionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReceptionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReception() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReception() {
        // Given
        Reception toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReception() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReceptionById() {
        // Given
        Long idToRetrieve = 1L; // Example Reception ID to retrieve
        Reception expected = new Reception(); // You need to replace Reception with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Reception result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Reception constructSample(int i) {
		Reception given = new Reception();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setDateReception(LocalDateTime.now());
        given.setDateReception(dateReception);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setCommande(new Commande(1L));
        given.setCommande(commande);
        List<ReceptionDetail> receptionDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                ReceptionDetail element = new ReceptionDetail();
                                                element.setId((long)id);
                                                element.setQte(new BigDecimal(1*10));
                                                element.setMagasin(new Magasin(Long.valueOf(2)));
                                                element.setProduit(new Produit(Long.valueOf(3)));
                                                element.setReception(new Reception(Long.valueOf(4)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setReceptionDetails(receptionDetails);
        return given;
    }

}
