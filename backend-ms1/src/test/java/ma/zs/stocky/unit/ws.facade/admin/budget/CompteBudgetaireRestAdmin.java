package ma.zs.stocky.unit.ws.facade.admin.budget;

import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.service.impl.admin.budget.CompteBudgetaireAdminServiceImpl;
import ma.zs.stocky.ws.converter.budget.CompteBudgetaireConverter;
import ma.zs.stocky.ws.dto.budget.CompteBudgetaireDto;
import ma.zs.stocky.ws.facade.admin.budget.CompteBudgetaireRestAdmin;
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
public class CompteBudgetaireRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private CompteBudgetaireAdminServiceImpl service;
    @Mock
    private CompteBudgetaireConverter converter;

    @InjectMocks
    private CompteBudgetaireRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCompteBudgetaireTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CompteBudgetaireDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CompteBudgetaireDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCompteBudgetaireTest() throws Exception {
        // Mock data
        CompteBudgetaireDto requestDto = new CompteBudgetaireDto();
        CompteBudgetaire entity = new CompteBudgetaire();
        CompteBudgetaire saved = new CompteBudgetaire();
        CompteBudgetaireDto savedDto = new CompteBudgetaireDto();

        // Mock the converter to return the compteBudgetaire object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved compteBudgetaire DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CompteBudgetaireDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CompteBudgetaireDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved compteBudgetaire DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getMontantMax(), responseBody.getMontantMax());
    }

}
