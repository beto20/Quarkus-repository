package com.alberto.core.audit.model.mapper;

import com.alberto.core.audit.model.document.AuditAccountDocument;
import com.alberto.core.audit.model.dto.AuditAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditMapper {
    AuditMapper MAPPER = Mappers.getMapper(AuditMapper.class);

    @Mapping(target = "idReference", source = "id")
    @Mapping(target = "id", ignore = true)
    AuditAccountDocument toResponseDocument(AuditAccountDto accountDto);
}
