package com.api.movements.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCosifDTO {
    private String codCosif;
    private String codProduto;
    private String classificacao;
    private String status;
}
