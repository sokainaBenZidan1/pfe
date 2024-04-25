package ma.zs.stocky.unit.service.impl.admin.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.dao.facade.core.expressionbesion.ExpressionBesoinDetailDao;
import ma.zs.stocky.service.impl.admin.expressionbesion.ExpressionBesoinDetailAdminServiceImpl;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin ;
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
class ExpressionBesoinDetailAdminServiceImplTest {

    @Mock
    private ExpressionBesoinDetailDao repository;
    private AutoCloseable autoCloseable;
    private ExpressionBesoinDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ExpressionBesoinDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllExpressionBesoinDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveExpressionBesoinDetail() {
        // Given
        ExpressionBesoinDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteExpressionBesoinDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetExpressionBesoinDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example ExpressionBesoinDetail ID to retrieve
        ExpressionBesoinDetail expected = new ExpressionBesoinDetail(); // You need to replace ExpressionBesoinDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ExpressionBesoinDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ExpressionBesoinDetail constructSample(int i) {
		ExpressionBesoinDetail given = new ExpressionBesoinDetail();
        given.setId(id);
        given.setQteDemandee(BigDecimal.TEN);
        given.setQteDemandee(qteDemandee);
        given.setQteAccordee(BigDecimal.TEN);
        given.setQteAccordee(qteAccordee);
        given.setQteLivre(BigDecimal.TEN);
        given.setQteLivre(qteLivre);
        given.setExpressionBesoin(new ExpressionBesoin(1L));
        given.setExpressionBesoin(expressionBesoin);
        given.setProduit(new Produit(1L));
        given.setProduit(produit);
        return given;
    }

}
