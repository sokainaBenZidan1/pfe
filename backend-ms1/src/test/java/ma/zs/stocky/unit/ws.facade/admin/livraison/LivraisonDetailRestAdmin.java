package ma.zs.stocky.unit.ws.facade.admin.livraison;

import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.service.impl.admin.livraison.LivraisonDetailAdminServiceImpl;
import ma.zs.stocky.ws.converter.livraison.LivraisonDetailConverter;
import ma.zs.stocky.ws.dto.livraison.LivraisonDetailDto;
import ma.zs.stocky.ws.facade.admin.livraison.LivraisonDetailRestAdmin;
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
public class LivraisonDetailRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private LivraisonDetailAdminServiceImpl service;
    @Mock
    private LivraisonDetailConverter converter;

    @InjectMocks
    private LivraisonDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllLivraisonDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<LivraisonDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<LivraisonDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveLivraisonDetailTest() throws Exception {
        // Mock data
        LivraisonDetailDto requestDto = new LivraisonDetailDto();
        LivraisonDetail entity = new LivraisonDetail();
        LivraisonDetail saved = new LivraisonDetail();
        LivraisonDetailDto savedDto = new LivraisonDetailDto();

        // Mock the converter to return the livraisonDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved livraisonDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<LivraisonDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        LivraisonDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved livraisonDetail DTO
        assertEquals(savedDto.getQte(), responseBody.getQte());
    }

}
