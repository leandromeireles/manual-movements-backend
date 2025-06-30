package com.api.movements.service;

import com.api.movements.dto.MovimentoManualDTO;
import com.api.movements.dto.MovimentoManualResponseDTO;

import java.util.List;

public interface MovimentoManualService {

    List<MovimentoManualResponseDTO> listarTodos();

    MovimentoManualResponseDTO salvar(MovimentoManualDTO dto);
}
