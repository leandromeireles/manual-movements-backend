package com.api.movements.service;

import com.api.movements.dto.ProdutoCosifDTO;

import java.util.List;

public interface ProdutoCosifService {

    List<ProdutoCosifDTO> listarTodos();
    List<ProdutoCosifDTO> listarPorProduto(String codProduto);
}