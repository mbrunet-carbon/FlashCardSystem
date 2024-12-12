package com.flashcardsystem.infrastructure.repository.mapper;

import com.flashcardsystem.domain.model.Box;
import com.flashcardsystem.infrastructure.repository.entity.BoxEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)

public interface BoxMapper {

    @Mapping(target = "cards", ignore= true)
    Box toBox(BoxEntity boxEntity);
}
