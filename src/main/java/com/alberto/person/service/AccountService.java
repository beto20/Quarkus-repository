package com.alberto.person.service;


import com.alberto.person.model.dto.AccountDto;

public interface AccountService {

    void registerNewAccount(AccountDto accountDto);
    void updateAccountInformation(Long accountId, AccountDto accountDto);
    void deleteAccount(Long accountId);
}
