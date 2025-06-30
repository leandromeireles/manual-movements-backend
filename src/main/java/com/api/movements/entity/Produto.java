package com.api.movements.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    @Id
    @Column(name = "COD_PRODUTO")
    private String codProduto;

    @Column(name = "DES_PRODUTO")
    private String descricao;

    @Column(name = "STA_STATUS")
    private String status;
}