package com.alberto.app.account.service;


import com.alberto.app.account.model.dto.AccountDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AccountService {

    void registerNewAccount(AccountDto accountDto) throws JsonProcessingException, InterruptedException;
    void updateAccountInformation(Long accountId, AccountDto accountDto);
    void deleteAccount(Long accountId);
}
