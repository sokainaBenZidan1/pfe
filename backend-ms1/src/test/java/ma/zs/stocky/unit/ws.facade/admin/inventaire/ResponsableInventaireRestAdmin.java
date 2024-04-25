package ma.zs.stocky.unit.ws.facade.admin.inventaire;

import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.service.impl.admin.inventaire.ResponsableInventaireAdminServiceImpl;
import ma.zs.stocky.ws.converter.inventaire.ResponsableInventaireConverter;
import ma.zs.stocky.ws.dto.inventaire.ResponsableInventaireDto;
import ma.zs.stocky.ws.facade.admin.inventaire.ResponsableInventaireRestAdmin;
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
public class ResponsableInventaireRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private ResponsableInventaireAdminServiceImpl service;
    @Mock
    private ResponsableInventaireConverter converter;

    @InjectMocks
    private ResponsableInventaireRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllResponsableInventaireTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ResponsableInventaireDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ResponsableInventaireDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveResponsableInventaireTest() throws Exception {
        // Mock data
        ResponsableInventaireDto requestDto = new ResponsableInventaireDto();
        ResponsableInventaire entity = new ResponsableInventaire();
        ResponsableInventaire saved = new ResponsableInventaire();
        ResponsableInventaireDto savedDto = new ResponsableInventaireDto();

        // Mock the converter to return the responsableInventaire object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved responsableInventaire DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ResponsableInventaireDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ResponsableInventaireDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved responsableInventaire DTO
        assertEquals(savedDto.getNom(), responseBody.getNom());
        assertEquals(savedDto.getPrenom(), responseBody.getPrenom());
        assertEquals(savedDto.getLogin(), responseBody.getLogin());
        assertEquals(savedDto.getMdp(), responseBody.getMdp());
    }

}
