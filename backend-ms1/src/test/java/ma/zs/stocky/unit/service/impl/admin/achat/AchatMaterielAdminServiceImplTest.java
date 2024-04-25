package ma.zs.stocky.unit.service.impl.admin.achat;

import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.dao.facade.core.achat.AchatMaterielDao;
import ma.zs.stocky.service.impl.admin.achat.AchatMaterielAdminServiceImpl;

import ma.zs.stocky.bean.core.achat.TypeAchatMateriel ;
import ma.zs.stocky.bean.core.budget.Budget ;
import ma.zs.stocky.bean.core.achat.AchatMaterielDetail ;
import ma.zs.stocky.bean.core.produit.Produit ;
import ma.zs.stocky.bean.core.achat.AchatMateriel ;
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
class AchatMaterielAdminServiceImplTest {

    @Mock
    private AchatMaterielDao repository;
    private AutoCloseable autoCloseable;
    private AchatMaterielAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new AchatMaterielAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllAchatMateriel() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveAchatMateriel() {
        // Given
        AchatMateriel toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteAchatMateriel() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetAchatMaterielById() {
        // Given
        Long idToRetrieve = 1L; // Example AchatMateriel ID to retrieve
        AchatMateriel expected = new AchatMateriel(); // You need to replace AchatMateriel with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        AchatMateriel result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private AchatMateriel constructSample(int i) {
		AchatMateriel given = new AchatMateriel();
        given.setId(id);
        given.setBudget(new Budget(1L));
        given.setBudget(budget);
        given.setMontantTotal(BigDecimal.TEN);
        given.setMontantTotal(montantTotal);
        given.setDateAchat(LocalDateTime.now());
        given.setDateAchat(dateAchat);
        given.setTypeAchatMateriel(new TypeAchatMateriel(1L));
        given.setTypeAchatMateriel(typeAchatMateriel);
        List<AchatMaterielDetail> achatMaterielDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                AchatMaterielDetail element = new AchatMaterielDetail();
                                                element.setId((long)id);
                                                element.setProduit(new Produit(Long.valueOf(1)));
                                                element.setQteAchetee(new BigDecimal(2*10));
                                                element.setQteRecue(new BigDecimal(3*10));
                                                element.setQteLivree(new BigDecimal(4*10));
                                                element.setAchatMateriel(new AchatMateriel(Long.valueOf(5)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setAchatMaterielDetails(achatMaterielDetails);
        return given;
    }

}
