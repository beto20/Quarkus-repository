package com.alberto.account.service;


import com.alberto.account.model.dto.AccountDto;

public interface AccountService {

    void registerNewAccount(AccountDto accountDto);
    void updateAccountInformation(Long accountId, AccountDto accountDto);
    void deleteAccount(Long accountId);
}
