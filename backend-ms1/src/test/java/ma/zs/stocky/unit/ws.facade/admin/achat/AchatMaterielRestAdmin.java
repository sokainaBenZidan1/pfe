package ma.zs.stocky.unit.ws.facade.admin.achat;

import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.service.impl.admin.achat.AchatMaterielAdminServiceImpl;
import ma.zs.stocky.ws.converter.achat.AchatMaterielConverter;
import ma.zs.stocky.ws.dto.achat.AchatMaterielDto;
import ma.zs.stocky.ws.facade.admin.achat.AchatMaterielRestAdmin;
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
public class AchatMaterielRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private AchatMaterielAdminServiceImpl service;
    @Mock
    private AchatMaterielConverter converter;

    @InjectMocks
    private AchatMaterielRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllAchatMaterielTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<AchatMaterielDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<AchatMaterielDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveAchatMaterielTest() throws Exception {
        // Mock data
        AchatMaterielDto requestDto = new AchatMaterielDto();
        AchatMateriel entity = new AchatMateriel();
        AchatMateriel saved = new AchatMateriel();
        AchatMaterielDto savedDto = new AchatMaterielDto();

        // Mock the converter to return the achatMateriel object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved achatMateriel DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<AchatMaterielDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        AchatMaterielDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved achatMateriel DTO
        assertEquals(savedDto.getMontantTotal(), responseBody.getMontantTotal());
        assertEquals(savedDto.getDateAchat(), responseBody.getDateAchat());
    }

}
