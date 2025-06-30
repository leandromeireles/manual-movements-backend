package com.api.movements.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoManualDTO {
    private Integer mes;
    private Integer ano;
    private String codProduto;
    private String codCosif;
    private String descricao;
    private BigDecimal valor;
}