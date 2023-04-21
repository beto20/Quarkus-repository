package com.alberto.app.account.service;

import com.alberto.app.account.model.dto.AccountDto;
import com.alberto.app.account.pub.AccountAuditPublisher;
import com.alberto.app.account.repository.AccountRepository;
import com.alberto.core.account.model.domain.Role;
import com.alberto.core.account.model.entity.AccountEntity;
import com.alberto.core.audit.model.SubscriberMessageActions;
import com.alberto.core.audit.sub.AccountAuditSubscriber;
import com.alberto.core.person.model.entity.StudentEntity;
import com.alberto.core.person.model.entity.TeacherEntity;
import com.alberto.core.person.repository.StudentRepository;
import com.alberto.core.person.repository.TeacherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class AccountServiceImplTest {

    @InjectMock
    AccountRepository accountRepository;
    @InjectMock
    AccountAuditPublisher accountAuditPublisher;
    @InjectMock
    StudentRepository studentRepository;
    @InjectMock
    TeacherRepository teacherRepository;
    @InjectMock
    AccountAuditSubscriber accountAuditSubscriber;
    @Inject
    AccountServiceImpl accountServiceImpl;

    @BeforeEach
    public void setUp() {
        String connectionString = "test";
        String topicName = "test";
        String subName = "test";
    }

    @Test
    void testRegisterNewAccount_thenOk() throws JsonProcessingException, InterruptedException {
        Mockito.doNothing().when(studentRepository).persist(new StudentEntity());
        Mockito.doNothing().when(teacherRepository).persist(new TeacherEntity());
        Mockito.doNothing().when(accountAuditPublisher).publish(Mockito.any());

//        Mockito.when(accountAuditSubscriber.receiveMessages())
//                .thenReturn(SubscriberMessageActions.COMPLETE);

        var accountDto = new AccountDto();
        accountDto.setRole(Role.STUDENT);

        accountServiceImpl.registerNewAccount(accountDto);
    }

    @Test
    void testUpdateAccountInformation_thenOk() {
        var accountId = 1L;

        var entity = new AccountEntity();
        entity.id = 1L;
        entity.setRole(Role.STUDENT);
        entity.setName("mock");
        entity.setLastName("mock");
        entity.setCode("mock");
        entity.setEmail("mock");
        entity.setPassword("mock");
        entity.setCountry("mock");
        entity.setProvince("mock");
        entity.setDistrict("mock");
        entity.setActive(true);

        var accountDto = new AccountDto();
        accountDto.setRole(Role.STUDENT);
        accountDto.setName("mock");
        accountDto.setLastName("mock");
        accountDto.setCode("mock");
        accountDto.setEmail("mock");
        accountDto.setPassword("mock");
        accountDto.setCountry("mock");
        accountDto.setProvince("mock");
        accountDto.setDistrict("mock");
        accountDto.setActive(true);

        var thenAccountEntity = Mockito.when(accountRepository.findByIdOptional(Mockito.anyLong()))
                .thenReturn(Optional.of(entity));
        Mockito.doNothing().when(accountRepository).persist(entity);
        accountServiceImpl.updateAccountInformation(accountId, accountDto);

        assertNotNull(accountDto);
        assertNotNull(thenAccountEntity);
    }

    @Test
    void testDeleteAccount_thenOk() {
        var accountId = 1L;
        var thenReturn = Mockito.when(accountRepository.deleteById(Mockito.anyLong()))
                .thenReturn(true);
        accountServiceImpl.deleteAccount(accountId);

        assertNotNull(thenReturn);
    }

}
