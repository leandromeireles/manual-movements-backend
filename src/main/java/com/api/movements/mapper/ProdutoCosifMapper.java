package com.api.movements.mapper;

import com.api.movements.dto.ProdutoCosifDTO;
import com.api.movements.entity.ProdutoCosif;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoCosifMapper {
    ProdutoCosifDTO toDto(ProdutoCosif cosif);
    List<ProdutoCosifDTO> toDtoList(List<ProdutoCosif> cosifs);
}
