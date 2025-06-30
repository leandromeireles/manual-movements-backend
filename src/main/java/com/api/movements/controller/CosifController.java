package com.api.movements.controller;

import com.api.movements.entity.ProdutoCosif;
import com.api.movements.service.ProdutoCosifService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cosifs")
@RequiredArgsConstructor
public class CosifController {

    private final ProdutoCosifService cosifService;

    @GetMapping
    public List<ProdutoCosif> listarTodos() {
        return cosifService.listarTodos();
    }
}