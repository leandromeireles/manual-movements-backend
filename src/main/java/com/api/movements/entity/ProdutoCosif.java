package com.api.movements.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUTO_COSIF")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoCosif {
    @Id
    @Column(name = "COD_COSIF")
    private String codCosif;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO")
    @JsonBackReference
    private Produto produto;

    @Column(name = "COD_CLASSIFICACAO")
    private String classificacao;

    @Column(name = "STA_STATUS")
    private String status;
}