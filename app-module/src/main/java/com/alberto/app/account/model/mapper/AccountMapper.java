package com.alberto.app.account.model.mapper;

import com.alberto.app.account.model.dto.AccountDto;
import com.alberto.app.account.model.dto.AccountRequestDto;
import com.alberto.app.person.model.entity.StudentEntity;
import com.alberto.app.person.model.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    StudentEntity toStudentEntity(AccountDto accountDto);
    TeacherEntity toTeacherEntity(AccountDto accountDto);
    AccountDto toDto(AccountRequestDto requestDto);
}
