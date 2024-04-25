package ma.zs.stocky.unit.service.impl.admin.achat;

import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.dao.facade.core.achat.AchatMaterielDetailDao;
import ma.zs.stocky.service.impl.admin.achat.AchatMaterielDetailAdminServiceImpl;

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
class AchatMaterielDetailAdminServiceImplTest {

    @Mock
    private AchatMaterielDetailDao repository;
    private AutoCloseable autoCloseable;
    private AchatMaterielDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new AchatMaterielDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllAchatMaterielDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveAchatMaterielDetail() {
        // Given
        AchatMaterielDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteAchatMaterielDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetAchatMaterielDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example AchatMaterielDetail ID to retrieve
        AchatMaterielDetail expected = new AchatMaterielDetail(); // You need to replace AchatMaterielDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        AchatMaterielDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private AchatMaterielDetail constructSample(int i) {
		AchatMaterielDetail given = new AchatMaterielDetail();
        given.setId(id);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        given.setQteAchetee(BigDecimal.TEN);
        given.setQteAchetee(qteAchetee);
        given.setQteRecue(BigDecimal.TEN);
        given.setQteRecue(qteRecue);
        given.setQteLivree(BigDecimal.TEN);
        given.setQteLivree(qteLivree);
        given.setAchatMateriel(new AchatMateriel(1L));
        given.setAchatMateriel(achatMateriel);
        return given;
    }

}
