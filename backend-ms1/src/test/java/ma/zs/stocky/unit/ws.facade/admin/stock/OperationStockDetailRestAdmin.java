package ma.zs.stocky.unit.ws.facade.admin.stock;

import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.service.impl.admin.stock.OperationStockDetailAdminServiceImpl;
import ma.zs.stocky.ws.converter.stock.OperationStockDetailConverter;
import ma.zs.stocky.ws.dto.stock.OperationStockDetailDto;
import ma.zs.stocky.ws.facade.admin.stock.OperationStockDetailRestAdmin;
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
public class OperationStockDetailRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private OperationStockDetailAdminServiceImpl service;
    @Mock
    private OperationStockDetailConverter converter;

    @InjectMocks
    private OperationStockDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllOperationStockDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<OperationStockDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<OperationStockDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveOperationStockDetailTest() throws Exception {
        // Mock data
        OperationStockDetailDto requestDto = new OperationStockDetailDto();
        OperationStockDetail entity = new OperationStockDetail();
        OperationStockDetail saved = new OperationStockDetail();
        OperationStockDetailDto savedDto = new OperationStockDetailDto();

        // Mock the converter to return the operationStockDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved operationStockDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<OperationStockDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        OperationStockDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved operationStockDetail DTO
        assertEquals(savedDto.getQte(), responseBody.getQte());
    }

}
