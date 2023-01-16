package com.alberto.person.model.mapper;

import com.alberto.person.model.dto.AccountDto;
import com.alberto.person.model.dto.AccountRequestDto;
import com.alberto.person.model.entity.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    BaseEntity toEntity(AccountDto accountDto);
    AccountDto toDto(AccountRequestDto requestDto);
}
