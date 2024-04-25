package ma.zs.stocky.unit.ws.facade.admin.livraison;

import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.service.impl.admin.livraison.LivraisonAdminServiceImpl;
import ma.zs.stocky.ws.converter.livraison.LivraisonConverter;
import ma.zs.stocky.ws.dto.livraison.LivraisonDto;
import ma.zs.stocky.ws.facade.admin.livraison.LivraisonRestAdmin;
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
public class LivraisonRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private LivraisonAdminServiceImpl service;
    @Mock
    private LivraisonConverter converter;

    @InjectMocks
    private LivraisonRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllLivraisonTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<LivraisonDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<LivraisonDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveLivraisonTest() throws Exception {
        // Mock data
        LivraisonDto requestDto = new LivraisonDto();
        Livraison entity = new Livraison();
        Livraison saved = new Livraison();
        LivraisonDto savedDto = new LivraisonDto();

        // Mock the converter to return the livraison object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved livraison DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<LivraisonDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        LivraisonDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved livraison DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getDatelivraison(), responseBody.getDatelivraison());
    }

}
