package ma.zs.stocky.unit.ws.facade.admin.achat;

import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.service.impl.admin.achat.AchatMaterielDetailAdminServiceImpl;
import ma.zs.stocky.ws.converter.achat.AchatMaterielDetailConverter;
import ma.zs.stocky.ws.dto.achat.AchatMaterielDetailDto;
import ma.zs.stocky.ws.facade.admin.achat.AchatMaterielDetailRestAdmin;
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
public class AchatMaterielDetailRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private AchatMaterielDetailAdminServiceImpl service;
    @Mock
    private AchatMaterielDetailConverter converter;

    @InjectMocks
    private AchatMaterielDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllAchatMaterielDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<AchatMaterielDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<AchatMaterielDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveAchatMaterielDetailTest() throws Exception {
        // Mock data
        AchatMaterielDetailDto requestDto = new AchatMaterielDetailDto();
        AchatMaterielDetail entity = new AchatMaterielDetail();
        AchatMaterielDetail saved = new AchatMaterielDetail();
        AchatMaterielDetailDto savedDto = new AchatMaterielDetailDto();

        // Mock the converter to return the achatMaterielDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved achatMaterielDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<AchatMaterielDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        AchatMaterielDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved achatMaterielDetail DTO
        assertEquals(savedDto.getQteAchetee(), responseBody.getQteAchetee());
        assertEquals(savedDto.getQteRecue(), responseBody.getQteRecue());
        assertEquals(savedDto.getQteLivree(), responseBody.getQteLivree());
    }

}
