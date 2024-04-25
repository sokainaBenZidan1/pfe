package ma.zs.stocky.unit.ws.facade.admin.achat;

import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.service.impl.admin.achat.TypeAchatMaterielAdminServiceImpl;
import ma.zs.stocky.ws.converter.achat.TypeAchatMaterielConverter;
import ma.zs.stocky.ws.dto.achat.TypeAchatMaterielDto;
import ma.zs.stocky.ws.facade.admin.achat.TypeAchatMaterielRestAdmin;
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
public class TypeAchatMaterielRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private TypeAchatMaterielAdminServiceImpl service;
    @Mock
    private TypeAchatMaterielConverter converter;

    @InjectMocks
    private TypeAchatMaterielRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTypeAchatMaterielTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TypeAchatMaterielDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TypeAchatMaterielDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTypeAchatMaterielTest() throws Exception {
        // Mock data
        TypeAchatMaterielDto requestDto = new TypeAchatMaterielDto();
        TypeAchatMateriel entity = new TypeAchatMateriel();
        TypeAchatMateriel saved = new TypeAchatMateriel();
        TypeAchatMaterielDto savedDto = new TypeAchatMaterielDto();

        // Mock the converter to return the typeAchatMateriel object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved typeAchatMateriel DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TypeAchatMaterielDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TypeAchatMaterielDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved typeAchatMateriel DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getCode(), responseBody.getCode());
    }

}
