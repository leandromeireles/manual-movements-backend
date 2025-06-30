package com.api.movements.controller;

import com.api.movements.entity.Produto;
import com.api.movements.service.ProdutoService;
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

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Test
    void deveListarTodosProdutos() throws Exception {
        Produto produto = Produto.builder()
                .codProduto("PRD1")
                .descricao("Produto Teste")
                .status("A")
                .build();

        when(produtoService.listarTodos()).thenReturn(List.of(produto));

        mockMvc.perform(get("/api/produtos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codProduto").value("PRD1"))
                .andExpect(jsonPath("$[0].descricao").value("Produto Teste"))
                .andExpect(jsonPath("$[0].status").value("A"));
    }
}
