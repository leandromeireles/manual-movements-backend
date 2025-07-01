package com.api.movements.repository;

import com.api.movements.entity.ProdutoCosif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, String> {

    List<ProdutoCosif> findByProduto_CodProduto(String codProduto);
}