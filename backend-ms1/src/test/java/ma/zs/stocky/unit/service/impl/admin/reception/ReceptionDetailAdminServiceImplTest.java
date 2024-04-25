package ma.zs.stocky.unit.service.impl.admin.reception;

import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.dao.facade.core.reception.ReceptionDetailDao;
import ma.zs.stocky.service.impl.admin.reception.ReceptionDetailAdminServiceImpl;

import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.bean.core.reception.Reception ;
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
class ReceptionDetailAdminServiceImplTest {

    @Mock
    private ReceptionDetailDao repository;
    private AutoCloseable autoCloseable;
    private ReceptionDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReceptionDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReceptionDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReceptionDetail() {
        // Given
        ReceptionDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReceptionDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReceptionDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example ReceptionDetail ID to retrieve
        ReceptionDetail expected = new ReceptionDetail(); // You need to replace ReceptionDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ReceptionDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ReceptionDetail constructSample(int i) {
		ReceptionDetail given = new ReceptionDetail();
        given.setId(id);
        given.setQte(BigDecimal.TEN);
        given.setQte(qte);
        given.setMagasin(new Magasin(1L));
        given.setMagasin(magasin);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        given.setReception(new Reception(1L));
        given.setReception(reception);
        return given;
    }

}
