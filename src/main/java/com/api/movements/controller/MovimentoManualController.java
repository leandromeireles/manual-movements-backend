package com.api.movements.controller;

import com.api.movements.dto.MovimentoManualDTO;
import com.api.movements.dto.MovimentoManualResponseDTO;
import com.api.movements.service.MovimentoManualService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimentos")
@RequiredArgsConstructor
public class MovimentoManualController {

    private final MovimentoManualService service;

    @GetMapping
    public List<MovimentoManualResponseDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public MovimentoManualResponseDTO criar(@RequestBody MovimentoManualDTO dto) {
        return service.salvar(dto);
    }
}