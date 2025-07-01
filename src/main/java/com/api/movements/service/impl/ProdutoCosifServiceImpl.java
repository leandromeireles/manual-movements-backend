package com.api.movements.service.impl;

import com.api.movements.dto.ProdutoCosifDTO;
import com.api.movements.entity.ProdutoCosif;
import com.api.movements.mapper.ProdutoCosifMapper;
import com.api.movements.repository.ProdutoCosifRepository;
import com.api.movements.service.ProdutoCosifService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoCosifServiceImpl implements ProdutoCosifService {

    private final ProdutoCosifMapper mapper;

    private final ProdutoCosifRepository repository;

    @Override
    public List<ProdutoCosifDTO> listarTodos() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<ProdutoCosifDTO> listarPorProduto(String codProduto) {
        return mapper.toDtoList(repository.findByProduto_CodProduto(codProduto));
    }
}