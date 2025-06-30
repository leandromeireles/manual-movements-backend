package com.api.movements.mapper;

import com.api.movements.dto.MovimentoManualResponseDTO;
import com.api.movements.entity.MovimentoManual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimentoManualMapper {

    @Mapping(source = "produto.codProduto", target = "codProduto")
    @Mapping(source = "produto.descricao", target = "descProduto")
    @Mapping(source = "cosif.codCosif", target = "codCosif")
    MovimentoManualResponseDTO toDto(MovimentoManual movimento);

    List<MovimentoManualResponseDTO> toDtoList(List<MovimentoManual> movimentos);
}
