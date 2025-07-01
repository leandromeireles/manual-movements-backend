package com.api.movements.controller;

import com.api.movements.dto.ProdutoCosifDTO;
import com.api.movements.service.ProdutoCosifService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CosifController.class)
class CosifControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoCosifService cosifService;

    @Test
    void deveListarTodosOsProdutoCosif() throws Exception {
        ProdutoCosifDTO cosifDto = new ProdutoCosifDTO("COSIF1", "PRD1", "001", "A");

        when(cosifService.listarTodos()).thenReturn(List.of(cosifDto));

        mockMvc.perform(get("/api/cosifs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codCosif").value("COSIF1"))
                .andExpect(jsonPath("$[0].classificacao").value("001"))
                .andExpect(jsonPath("$[0].status").value("A"));
    }
}

