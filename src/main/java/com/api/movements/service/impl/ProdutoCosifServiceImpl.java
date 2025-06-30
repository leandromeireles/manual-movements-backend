package com.api.movements.service.impl;

import com.api.movements.entity.ProdutoCosif;
import com.api.movements.repository.ProdutoCosifRepository;
import com.api.movements.service.ProdutoCosifService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoCosifServiceImpl implements ProdutoCosifService {

    @Autowired
    private ProdutoCosifRepository repository;

    public List<ProdutoCosif> listarTodos() {
        return repository.findAll();
    }
}