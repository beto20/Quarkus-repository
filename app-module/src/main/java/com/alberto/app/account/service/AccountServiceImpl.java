package com.alberto.app.account.service;

import com.alberto.app.account.model.dto.AccountDto;
import com.alberto.app.account.model.mapper.AccountMapper;
import com.alberto.app.account.pub.AccountAuditPublisher;
import com.alberto.core.account.model.domain.Role;
import com.alberto.core.account.model.entity.AccountEntity;
import com.alberto.core.account.repository.AccountRepository;
import com.alberto.core.audit.sub.AccountAuditSubscriber;
import com.alberto.core.person.repository.StudentRepository;
import com.alberto.core.person.repository.TeacherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    AccountRepository accountRepository;
    @Inject
    AccountAuditPublisher accountAuditPublisher;
    @Inject
    AccountAuditSubscriber accountAuditSubscriber;
    @Inject
    StudentRepository studentRepository;
    @Inject
    TeacherRepository teacherRepository;

    @Transactional
    @Override
    public void registerNewAccount(AccountDto accountDto) throws JsonProcessingException, InterruptedException {
        if (accountDto.getRole().equals(Role.TEACHER)){
            var teacherEntity = AccountMapper.MAPPER.toTeacherEntity(accountDto);
            teacherRepository.persist(teacherEntity);
        }
        if (accountDto.getRole().equals(Role.STUDENT)) {
            var studentEntity = AccountMapper.MAPPER.toStudentEntity(accountDto);
            studentRepository.persist(studentEntity);
        }
        accountAuditPublisher.publish(accountDto);
        accountAuditSubscriber.receiveMessages();
    }

    @Transactional
    @Override
    public void updateAccountInformation(Long accountId, AccountDto accountDto) {
        var accountEntity = accountRepository.findByIdOptional(accountId);

        if (accountEntity.isPresent()) {
            accountEntity.get().setName(accountDto.getName());
            accountEntity.get().setLastName(accountDto.getLastName());
            accountEntity.get().setCountry(accountDto.getCountry());
            accountEntity.get().setProvince(accountDto.getProvince());
            accountEntity.get().setDistrict(accountDto.getDistrict());
            accountEntity.get().setEmail(accountDto.getEmail());

            accountRepository.persist(accountEntity.get());
        }
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
