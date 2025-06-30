package com.api.movements.config;

import com.api.movements.entity.Produto;
import com.api.movements.entity.ProdutoCosif;
import com.api.movements.repository.ProdutoCosifRepository;
import com.api.movements.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoCosifRepository produtoCosifRepository;

    @Override
    public void run(String... args) throws Exception {
        if (produtoRepository.count() == 0) {
            Produto p1 = new Produto("PROD001", "DESC 001", "ATIVO");
            Produto p2 = new Produto("PROD002", "DESC 003", "ATIVO");
            produtoRepository.saveAll(Arrays.asList(p1, p2));

            ProdutoCosif c1 = new ProdutoCosif("COSIF001", p1, "001", "ATIVO");
            ProdutoCosif c2 = new ProdutoCosif("COSIF002", p2, "002", "ATIVO");
            produtoCosifRepository.saveAll(Arrays.asList(c1, c2));
        }
    }
}
