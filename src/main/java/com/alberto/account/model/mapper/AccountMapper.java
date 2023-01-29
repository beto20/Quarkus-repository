package com.alberto.account.model.mapper;

import com.alberto.account.model.dto.AccountDto;
import com.alberto.account.model.dto.AccountRequestDto;
import com.alberto.account.model.entity.AccountEntity;
import com.alberto.person.model.entity.StudentEntity;
import com.alberto.person.model.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    StudentEntity toStudentEntity(AccountDto accountDto);
    TeacherEntity toTeacherEntity(AccountDto accountDto);
    AccountDto toDto(AccountRequestDto requestDto);
}
