
package com.api.movements.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimentoManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DAT_MES", nullable = false)
    private Integer mes;

    @Column(name = "DAT_ANO", nullable = false)
    private Integer ano;

    @Column(name = "NUM_LANCAMENTO", nullable = false)
    private Integer numeroLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_COSIF", nullable = false)
    private ProdutoCosif cosif;

    @Column(name = "DES_DESCRICAO", nullable = false, length = 50)
    private String descricao;

    @Column(name = "DAT_MOVIMENTO", nullable = false)
    private LocalDateTime dataMovimento;

    @Column(name = "COD_USUARIO", nullable = false)
    private String usuario;

    @Column(name = "VAL_VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

}
