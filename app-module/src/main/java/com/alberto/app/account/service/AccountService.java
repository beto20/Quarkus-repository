package com.alberto.app.account.service;


import com.alberto.app.account.model.dto.AccountDto;

public interface AccountService {

    void registerNewAccount(AccountDto accountDto);
    void updateAccountInformation(Long accountId, AccountDto accountDto);
    void deleteAccount(Long accountId);
}
