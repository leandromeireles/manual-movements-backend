package com.api.movements.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProdutoCosif> cosifs;
}