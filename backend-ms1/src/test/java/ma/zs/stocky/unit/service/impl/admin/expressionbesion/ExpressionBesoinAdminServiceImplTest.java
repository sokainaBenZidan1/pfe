package ma.zs.stocky.unit.service.impl.admin.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.dao.facade.core.expressionbesion.ExpressionBesoinDao;
import ma.zs.stocky.service.impl.admin.expressionbesion.ExpressionBesoinAdminServiceImpl;

import ma.zs.stocky.bean.core.commun.EntiteAdmin ;
import ma.zs.stocky.bean.core.expressionbesion.Etat ;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail ;
import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin ;
import ma.zs.stocky.bean.core.commun.Employe ;
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
class ExpressionBesoinAdminServiceImplTest {

    @Mock
    private ExpressionBesoinDao repository;
    private AutoCloseable autoCloseable;
    private ExpressionBesoinAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ExpressionBesoinAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllExpressionBesoin() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveExpressionBesoin() {
        // Given
        ExpressionBesoin toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteExpressionBesoin() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetExpressionBesoinById() {
        // Given
        Long idToRetrieve = 1L; // Example ExpressionBesoin ID to retrieve
        ExpressionBesoin expected = new ExpressionBesoin(); // You need to replace ExpressionBesoin with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ExpressionBesoin result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ExpressionBesoin constructSample(int i) {
		ExpressionBesoin given = new ExpressionBesoin();
        given.setId(id);
        given.setEmploye(new Employe(1L));
        given.setEmploye(employe);
        given.setEntiteAdmin(new EntiteAdmin(1L));
        given.setEntiteAdmin(entiteAdmin);
        given.setDescription("description-"+i);
        given.setDescription(description);
        given.setDateExpression(LocalDateTime.now());
        given.setDateExpression(dateExpression);
        List<ExpressionBesoinDetail> expressionBesoinDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                ExpressionBesoinDetail element = new ExpressionBesoinDetail();
                                                element.setId((long)id);
                                                element.setQteDemandee(new BigDecimal(1*10));
                                                element.setQteAccordee(new BigDecimal(2*10));
                                                element.setQteLivre(new BigDecimal(3*10));
                                                element.setExpressionBesoin(new ExpressionBesoin(Long.valueOf(4)));
                                                element.setProduit(new Produit(Long.valueOf(5)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setExpressionBesoinDetails(expressionBesoinDetails);
        given.setEtat(new Etat(1L));
        given.setEtat(etat);
        return given;
    }

}
