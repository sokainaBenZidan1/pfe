package ma.zs.stocky.unit.ws.facade.admin.produit;

import ma.zs.stocky.bean.core.produit.CategorieProduit;
import ma.zs.stocky.service.impl.admin.produit.CategorieProduitAdminServiceImpl;
import ma.zs.stocky.ws.converter.produit.CategorieProduitConverter;
import ma.zs.stocky.ws.dto.produit.CategorieProduitDto;
import ma.zs.stocky.ws.facade.admin.produit.CategorieProduitRestAdmin;
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
public class CategorieProduitRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private CategorieProduitAdminServiceImpl service;
    @Mock
    private CategorieProduitConverter converter;

    @InjectMocks
    private CategorieProduitRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategorieProduitTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategorieProduitDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategorieProduitDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategorieProduitTest() throws Exception {
        // Mock data
        CategorieProduitDto requestDto = new CategorieProduitDto();
        CategorieProduit entity = new CategorieProduit();
        CategorieProduit saved = new CategorieProduit();
        CategorieProduitDto savedDto = new CategorieProduitDto();

        // Mock the converter to return the categorieProduit object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categorieProduit DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategorieProduitDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategorieProduitDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categorieProduit DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getCode(), responseBody.getCode());
    }

}
