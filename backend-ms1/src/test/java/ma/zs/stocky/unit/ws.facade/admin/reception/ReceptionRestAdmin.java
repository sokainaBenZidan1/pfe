package ma.zs.stocky.unit.ws.facade.admin.reception;

import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.service.impl.admin.reception.ReceptionAdminServiceImpl;
import ma.zs.stocky.ws.converter.reception.ReceptionConverter;
import ma.zs.stocky.ws.dto.reception.ReceptionDto;
import ma.zs.stocky.ws.facade.admin.reception.ReceptionRestAdmin;
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
public class ReceptionRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private ReceptionAdminServiceImpl service;
    @Mock
    private ReceptionConverter converter;

    @InjectMocks
    private ReceptionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllReceptionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ReceptionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ReceptionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveReceptionTest() throws Exception {
        // Mock data
        ReceptionDto requestDto = new ReceptionDto();
        Reception entity = new Reception();
        Reception saved = new Reception();
        ReceptionDto savedDto = new ReceptionDto();

        // Mock the converter to return the reception object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved reception DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ReceptionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ReceptionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved reception DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getDateReception(), responseBody.getDateReception());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
