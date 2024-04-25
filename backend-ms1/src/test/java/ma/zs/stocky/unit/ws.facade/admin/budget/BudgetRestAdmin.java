package ma.zs.stocky.unit.ws.facade.admin.budget;

import ma.zs.stocky.bean.core.budget.Budget;
import ma.zs.stocky.service.impl.admin.budget.BudgetAdminServiceImpl;
import ma.zs.stocky.ws.converter.budget.BudgetConverter;
import ma.zs.stocky.ws.dto.budget.BudgetDto;
import ma.zs.stocky.ws.facade.admin.budget.BudgetRestAdmin;
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
public class BudgetRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private BudgetAdminServiceImpl service;
    @Mock
    private BudgetConverter converter;

    @InjectMocks
    private BudgetRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllBudgetTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<BudgetDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<BudgetDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveBudgetTest() throws Exception {
        // Mock data
        BudgetDto requestDto = new BudgetDto();
        Budget entity = new Budget();
        Budget saved = new Budget();
        BudgetDto savedDto = new BudgetDto();

        // Mock the converter to return the budget object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved budget DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<BudgetDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        BudgetDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved budget DTO
        assertEquals(savedDto.getDateBudget(), responseBody.getDateBudget());
        assertEquals(savedDto.getMontant(), responseBody.getMontant());
        assertEquals(savedDto.getMontantInvestissement(), responseBody.getMontantInvestissement());
        assertEquals(savedDto.getMontantFonction(), responseBody.getMontantFonction());
    }

}
