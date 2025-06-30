package com.api.movements.controller;


import com.api.movements.dto.MovimentoManualDTO;
import com.api.movements.dto.MovimentoManualResponseDTO;
import com.api.movements.service.MovimentoManualService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovimentoManualController.class)
class MovimentoManualControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovimentoManualService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveListarMovimentos() throws Exception {
        MovimentoManualResponseDTO dto = MovimentoManualResponseDTO.builder()
                .ano(2025)
                .mes(6)
                .numeroLancamento(1)
                .codProduto("PRD1")
                .descProduto("Produto Teste")
                .codCosif("COSIF1")
                .descricao("Descrição")
                .valor(BigDecimal.valueOf(13500.000))
                .build();

        Mockito.when(service.listarTodos()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/movimentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codProduto").value("PRD1"))
                .andExpect(jsonPath("$[0].valor").value(13500.000));
    }

    @Test
    void deveCriarMovimento() throws Exception {
        MovimentoManualDTO input = new MovimentoManualDTO(6, 2025, "PRD1", "COSIF1", "Descrição", BigDecimal.valueOf(13500));
        MovimentoManualResponseDTO response = MovimentoManualResponseDTO.builder()
                .ano(2025)
                .mes(6)
                .numeroLancamento(1)
                .codProduto("PRD1")
                .descProduto("Produto Teste")
                .codCosif("COSIF1")
                .descricao("Descrição")
                .valor(BigDecimal.valueOf(13500.000))
                .build();

        Mockito.when(service.salvar(any(MovimentoManualDTO.class))).thenReturn(response);

        mockMvc.perform(post("/api/movimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codProduto").value("PRD1"))
                .andExpect(jsonPath("$.valor").value(13500.000));
    }
}
