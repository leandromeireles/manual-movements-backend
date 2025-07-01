package com.api.movements.controller;

import com.api.movements.dto.ProdutoCosifDTO;
import com.api.movements.service.ProdutoCosifService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cosifs")
@RequiredArgsConstructor
public class CosifController {

    private final ProdutoCosifService cosifService;

    @GetMapping
    public List<ProdutoCosifDTO> listarTodos() {
        return cosifService.listarTodos();
    }

    @GetMapping("/produto/{codProduto}")
    public List<ProdutoCosifDTO> listarPorProduto(@PathVariable String codProduto) {
        return cosifService.listarPorProduto(codProduto);
    }
}