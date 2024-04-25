package ma.zs.stocky.unit.ws.facade.admin.stock;

import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.service.impl.admin.stock.OperationStockAdminServiceImpl;
import ma.zs.stocky.ws.converter.stock.OperationStockConverter;
import ma.zs.stocky.ws.dto.stock.OperationStockDto;
import ma.zs.stocky.ws.facade.admin.stock.OperationStockRestAdmin;
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
public class OperationStockRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private OperationStockAdminServiceImpl service;
    @Mock
    private OperationStockConverter converter;

    @InjectMocks
    private OperationStockRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllOperationStockTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<OperationStockDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<OperationStockDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveOperationStockTest() throws Exception {
        // Mock data
        OperationStockDto requestDto = new OperationStockDto();
        OperationStock entity = new OperationStock();
        OperationStock saved = new OperationStock();
        OperationStockDto savedDto = new OperationStockDto();

        // Mock the converter to return the operationStock object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved operationStock DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<OperationStockDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        OperationStockDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved operationStock DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getDateOS(), responseBody.getDateOS());
        assertEquals(savedDto.getDiscription(), responseBody.getDiscription());
    }

}
