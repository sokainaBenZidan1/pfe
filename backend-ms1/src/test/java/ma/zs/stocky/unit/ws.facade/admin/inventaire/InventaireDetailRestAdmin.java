package ma.zs.stocky.unit.ws.facade.admin.inventaire;

import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.service.impl.admin.inventaire.InventaireDetailAdminServiceImpl;
import ma.zs.stocky.ws.converter.inventaire.InventaireDetailConverter;
import ma.zs.stocky.ws.dto.inventaire.InventaireDetailDto;
import ma.zs.stocky.ws.facade.admin.inventaire.InventaireDetailRestAdmin;
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
public class InventaireDetailRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private InventaireDetailAdminServiceImpl service;
    @Mock
    private InventaireDetailConverter converter;

    @InjectMocks
    private InventaireDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllInventaireDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<InventaireDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<InventaireDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveInventaireDetailTest() throws Exception {
        // Mock data
        InventaireDetailDto requestDto = new InventaireDetailDto();
        InventaireDetail entity = new InventaireDetail();
        InventaireDetail saved = new InventaireDetail();
        InventaireDetailDto savedDto = new InventaireDetailDto();

        // Mock the converter to return the inventaireDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved inventaireDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<InventaireDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        InventaireDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved inventaireDetail DTO
        assertEquals(savedDto.getQteCalculee(), responseBody.getQteCalculee());
        assertEquals(savedDto.getQteStock(), responseBody.getQteStock());
        assertEquals(savedDto.getEcart(), responseBody.getEcart());
        assertEquals(savedDto.getMagasin(), responseBody.getMagasin());
    }

}
