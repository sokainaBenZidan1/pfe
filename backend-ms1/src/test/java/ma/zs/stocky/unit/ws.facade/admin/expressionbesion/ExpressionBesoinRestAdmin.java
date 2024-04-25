package ma.zs.stocky.unit.ws.facade.admin.expressionbesion;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoin;
import ma.zs.stocky.service.impl.admin.expressionbesion.ExpressionBesoinAdminServiceImpl;
import ma.zs.stocky.ws.converter.expressionbesion.ExpressionBesoinConverter;
import ma.zs.stocky.ws.dto.expressionbesion.ExpressionBesoinDto;
import ma.zs.stocky.ws.facade.admin.expressionbesion.ExpressionBesoinRestAdmin;
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
public class ExpressionBesoinRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private ExpressionBesoinAdminServiceImpl service;
    @Mock
    private ExpressionBesoinConverter converter;

    @InjectMocks
    private ExpressionBesoinRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllExpressionBesoinTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ExpressionBesoinDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ExpressionBesoinDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveExpressionBesoinTest() throws Exception {
        // Mock data
        ExpressionBesoinDto requestDto = new ExpressionBesoinDto();
        ExpressionBesoin entity = new ExpressionBesoin();
        ExpressionBesoin saved = new ExpressionBesoin();
        ExpressionBesoinDto savedDto = new ExpressionBesoinDto();

        // Mock the converter to return the expressionBesoin object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved expressionBesoin DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ExpressionBesoinDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ExpressionBesoinDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved expressionBesoin DTO
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getDateExpression(), responseBody.getDateExpression());
    }

}
