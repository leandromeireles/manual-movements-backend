package com.api.movements.service.impl;

import com.api.movements.entity.Produto;
import com.api.movements.entity.ProdutoCosif;
import com.api.movements.repository.ProdutoCosifRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoCosifServiceImplTest {

    @Mock
    private ProdutoCosifRepository repository;

    @InjectMocks
    private ProdutoCosifServiceImpl service;

    @Test
    void deveListarTodosOsProdutosCosif() {
        Produto produto = Produto.builder()
                .codProduto("PRD1")
                .descricao("Produto Teste")
                .build();

        ProdutoCosif cosif = ProdutoCosif.builder()
                .codCosif("COSIF1")
                .produto(produto)
                .classificacao("001")
                .status("A")
                .build();

        when(repository.findAll()).thenReturn(List.of(cosif));

        List<ProdutoCosif> resultado = service.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("COSIF1", resultado.get(0).getCodCosif());
        verify(repository, times(1)).findAll();
    }
}

