package com.api.movements.service.impl;

import com.api.movements.dto.MovimentoManualDTO;
import com.api.movements.dto.MovimentoManualResponseDTO;
import com.api.movements.entity.MovimentoManual;
import com.api.movements.entity.Produto;
import com.api.movements.entity.ProdutoCosif;
import com.api.movements.mapper.MovimentoManualMapper;
import com.api.movements.repository.MovimentoManualRepository;
import com.api.movements.repository.ProdutoCosifRepository;
import com.api.movements.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovimentoManualServiceImplTest {

    @Mock
    private MovimentoManualRepository repository;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoCosifRepository cosifRepository;

    @Mock
    private MovimentoManualMapper mapper;

    @InjectMocks
    private MovimentoManualServiceImpl service;

    @Test
    void deveSalvarMovimentoComSucesso() {
        // Arrange
        Produto produto = Produto.builder()
                .codProduto("PRD1")
                .descricao("Produto Teste")
                .build();

        ProdutoCosif cosif = ProdutoCosif.builder()
                .codCosif("COSIF1")
                .produto(produto)
                .build();

        MovimentoManualDTO dto = new MovimentoManualDTO(
                6,
                2025,
                "PRD1",
                "COSIF1",
                "Teste de descrição",
                new BigDecimal("13500.000")
        );

        MovimentoManual movimentoSalvo = MovimentoManual.builder()
                .ano(2025)
                .mes(6)
                .numeroLancamento(1)
                .descricao("Teste de descrição")
                .valor(new BigDecimal("13500.000"))
                .usuario("TESTE")
                .dataMovimento(LocalDateTime.now())
                .produto(produto)
                .cosif(cosif)
                .build();

        MovimentoManualResponseDTO responseDTO = MovimentoManualResponseDTO.builder()
                .ano(2025)
                .mes(6)
                .numeroLancamento(1)
                .descricao("Teste de descrição")
                .valor(new BigDecimal("13500.000"))
                .codProduto("PRD1")
                .descProduto("Produto Teste")
                .codCosif("COSIF1")
                .build();

        when(produtoRepository.findById("PRD1")).thenReturn(Optional.of(produto));
        when(cosifRepository.findById("COSIF1")).thenReturn(Optional.of(cosif));
        when(repository.findMaxNumeroLancamentoByMesAndAno(6, 2025)).thenReturn(Optional.of(0));
        when(repository.save(any(MovimentoManual.class))).thenReturn(movimentoSalvo);
        when(mapper.toDto(any(MovimentoManual.class))).thenReturn(responseDTO);

        // Act
        MovimentoManualResponseDTO resultado = service.salvar(dto);

        // Assert
        assertNotNull(resultado);
        assertEquals("PRD1", resultado.getCodProduto());
        assertEquals("Produto Teste", resultado.getDescProduto());
        assertEquals("COSIF1", resultado.getCodCosif());
        assertEquals(new BigDecimal("13500.000"), resultado.getValor());
        assertEquals(6, resultado.getMes());
        assertEquals(2025, resultado.getAno());
        verify(repository, times(1)).save(any(MovimentoManual.class));
    }
}
