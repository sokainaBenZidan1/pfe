package ma.zs.stocky.unit.ws.facade.admin.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.service.impl.admin.expressionbesion.ExpressionBesoinDetailAdminServiceImpl;
import ma.zs.stocky.ws.converter.expressionbesion.ExpressionBesoinDetailConverter;
import ma.zs.stocky.ws.dto.expressionbesion.ExpressionBesoinDetailDto;
import ma.zs.stocky.ws.facade.admin.expressionbesion.ExpressionBesoinDetailRestAdmin;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExpressionBesoinDetailRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private ExpressionBesoinDetailAdminServiceImpl service;
    @Mock
    private ExpressionBesoinDetailConverter converter;

    @InjectMocks
    private ExpressionBesoinDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllExpressionBesoinDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ExpressionBesoinDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ExpressionBesoinDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveExpressionBesoinDetailTest() throws Exception {
        // Mock data
        ExpressionBesoinDetailDto requestDto = new ExpressionBesoinDetailDto();
        ExpressionBesoinDetail entity = new ExpressionBesoinDetail();
        ExpressionBesoinDetail saved = new ExpressionBesoinDetail();
        ExpressionBesoinDetailDto savedDto = new ExpressionBesoinDetailDto();

        // Mock the converter to return the expressionBesoinDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved expressionBesoinDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ExpressionBesoinDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ExpressionBesoinDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved expressionBesoinDetail DTO
        assertEquals(savedDto.getQteDemandee(), responseBody.getQteDemandee());
        assertEquals(savedDto.getQteAccordee(), responseBody.getQteAccordee());
        assertEquals(savedDto.getQteLivre(), responseBody.getQteLivre());
    }

}
