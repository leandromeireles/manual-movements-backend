package com.api.movements.service.impl;

import com.api.movements.entity.Produto;
import com.api.movements.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @Test
    void deveListarTodosOsProdutos() {
        Produto produto = Produto.builder()
                .codProduto("PRD1")
                .descricao("Produto Teste")
                .status("A")
                .build();

        when(produtoRepository.findAll()).thenReturn(List.of(produto));

        List<Produto> resultado = produtoService.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("PRD1", resultado.get(0).getCodProduto());
        assertEquals("Produto Teste", resultado.get(0).getDescricao());
        verify(produtoRepository, times(1)).findAll();
    }
}

