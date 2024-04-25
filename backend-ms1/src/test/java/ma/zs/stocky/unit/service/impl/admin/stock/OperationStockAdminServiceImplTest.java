package ma.zs.stocky.unit.service.impl.admin.stock;

import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.dao.facade.core.stock.OperationStockDao;
import ma.zs.stocky.service.impl.admin.stock.OperationStockAdminServiceImpl;

import ma.zs.stocky.bean.core.stock.Magasin ;
import ma.zs.stocky.bean.core.stock.OperationStock ;
import ma.zs.stocky.bean.core.stock.OperationStockDetail ;
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
class OperationStockAdminServiceImplTest {

    @Mock
    private OperationStockDao repository;
    private AutoCloseable autoCloseable;
    private OperationStockAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new OperationStockAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllOperationStock() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveOperationStock() {
        // Given
        OperationStock toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteOperationStock() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetOperationStockById() {
        // Given
        Long idToRetrieve = 1L; // Example OperationStock ID to retrieve
        OperationStock expected = new OperationStock(); // You need to replace OperationStock with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        OperationStock result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private OperationStock constructSample(int i) {
		OperationStock given = new OperationStock();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setDateOS(LocalDateTime.now());
        given.setDateOS(dateOS);
        given.setDiscription("discription-"+i);
        given.setDiscription(discription);
        given.setMagasinSource(new Magasin(1L));
        given.setMagasinSource(magasinSource);
        given.setMagasinDest(new Magasin(1L));
        given.setMagasinDest(magasinDest);
        List<OperationStockDetail> operationStockDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                OperationStockDetail element = new OperationStockDetail();
                                                element.setId((long)id);
                                                element.setQte(new BigDecimal(1*10));
                                                element.setProduit(new Produit(Long.valueOf(2)));
                                                element.setOperationStock(new OperationStock(Long.valueOf(3)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setOperationStockDetails(operationStockDetails);
        return given;
    }

}
