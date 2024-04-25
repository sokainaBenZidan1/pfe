package ma.zs.stocky.unit.service.impl.admin.stock;

import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.dao.facade.core.stock.OperationStockDetailDao;
import ma.zs.stocky.service.impl.admin.stock.OperationStockDetailAdminServiceImpl;

import ma.zs.stocky.bean.core.stock.OperationStock ;
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
class OperationStockDetailAdminServiceImplTest {

    @Mock
    private OperationStockDetailDao repository;
    private AutoCloseable autoCloseable;
    private OperationStockDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new OperationStockDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllOperationStockDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveOperationStockDetail() {
        // Given
        OperationStockDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteOperationStockDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetOperationStockDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example OperationStockDetail ID to retrieve
        OperationStockDetail expected = new OperationStockDetail(); // You need to replace OperationStockDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        OperationStockDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private OperationStockDetail constructSample(int i) {
		OperationStockDetail given = new OperationStockDetail();
        given.setId(id);
        given.setQte(BigDecimal.TEN);
        given.setQte(qte);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        given.setOperationStock(new OperationStock(1L));
        given.setOperationStock(operationStock);
        return given;
    }

}
