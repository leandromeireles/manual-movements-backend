package com.api.movements.config;

import com.api.movements.entity.Produto;
import com.api.movements.entity.ProdutoCosif;
import com.api.movements.repository.ProdutoCosifRepository;
import com.api.movements.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

            Produto p1 = Produto.builder()
                    .codProduto("PROD001")
                    .descricao("DESC 001")
                    .status("ATIVO")
                    .cosifs(new ArrayList<>())
                    .build();

            Produto p2 = Produto.builder()
                    .codProduto("PROD002")
                    .descricao("DESC 002")
                    .status("ATIVO")
                    .cosifs(new ArrayList<>())
                    .build();

            produtoRepository.saveAll(Arrays.asList(p1, p2));

            ProdutoCosif c1 = new ProdutoCosif("COSIF001", p1, "001", "ATIVO");
            ProdutoCosif c2 = new ProdutoCosif("COSIF002", p1, "002", "ATIVO");

            ProdutoCosif c3 = new ProdutoCosif("COSIF003", p2, "003", "ATIVO");
            ProdutoCosif c4 = new ProdutoCosif("COSIF004", p2, "004", "ATIVO");

            produtoCosifRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        }
    }
}

