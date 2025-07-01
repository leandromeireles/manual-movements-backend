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
import com.api.movements.service.MovimentoManualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentoManualServiceImpl implements MovimentoManualService {

    private final MovimentoManualRepository repository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoCosifRepository cosifRepository;
    private final MovimentoManualMapper mapper;

    private static final String USUARIO_PADRAO = "TESTE";


    @Override
    public List<MovimentoManualResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MovimentoManualResponseDTO salvar(MovimentoManualDTO dto) {
        Produto produto = produtoRepository.findById(dto.getCodProduto()).orElseThrow();
        ProdutoCosif cosif = cosifRepository.findById(dto.getCodCosif()).orElseThrow();

        Integer ultimoNumero = repository
                .findMaxNumeroLancamentoByMesAndAno(dto.getMes(), dto.getAno())
                .orElse(0);

        BigDecimal valorComEscala = dto.getValor().setScale(2, RoundingMode.HALF_UP);
        MovimentoManual movimento = MovimentoManual.builder()
                .ano(dto.getAno())
                .mes(dto.getMes())
                .numeroLancamento(ultimoNumero + 1)
                .descricao(dto.getDescricao())
                .valor(valorComEscala)
                .usuario(USUARIO_PADRAO)
                .dataMovimento(LocalDateTime.now())
                .produto(produto)
                .cosif(cosif)
                .build();

        return mapper.toDto(repository.save(movimento));
    }
}
