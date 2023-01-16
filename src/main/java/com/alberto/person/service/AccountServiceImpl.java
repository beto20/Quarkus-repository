package com.alberto.person.service;

import com.alberto.person.model.dto.AccountDto;
import com.alberto.person.model.mapper.AccountMapper;
import com.alberto.person.repository.AccountRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    AccountRepository accountRepository;

    @Override
    public void registerNewAccount(AccountDto accountDto) {
        var accountEntity = AccountMapper.MAPPER.toEntity(accountDto);
        accountRepository.persist(accountEntity);
    }

    @Override
    public void updateAccountInformation(Long accountId, AccountDto accountDto) {
        var accountEntity = accountRepository.findById(accountId);

        accountEntity.setName(accountDto.getName());
        accountEntity.setLastName(accountDto.getLastName());
        accountEntity.setCountry(accountDto.getCountry());
        accountEntity.setProvince(accountDto.getProvince());
        accountEntity.setDistrict(accountDto.getDistrict());
        accountEntity.setEmail(accountDto.getEmail());

        accountRepository.persist(accountEntity);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
