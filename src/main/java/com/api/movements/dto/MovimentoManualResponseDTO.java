package com.api.movements.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MovimentoManualResponseDTO {
    private Integer mes;
    private Integer ano;
    private Integer numeroLancamento;
    private String descricao;
    private BigDecimal valor;
    private String codProduto;
    private String descProduto;
    private String codCosif;
}
