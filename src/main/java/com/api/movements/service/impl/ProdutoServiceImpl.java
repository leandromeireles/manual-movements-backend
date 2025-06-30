package com.api.movements.service.impl;

import com.api.movements.entity.Produto;
import com.api.movements.repository.ProdutoRepository;
import com.api.movements.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
}
