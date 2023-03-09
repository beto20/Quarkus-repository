package com.alberto.app.account.facade;


import com.alberto.app.account.model.dto.AccountRequestDto;
import com.alberto.app.account.model.mapper.AccountMapper;
import com.alberto.app.account.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountFacade {

    @Inject
    AccountService accountService;

    public void registerNewAccount(AccountRequestDto requestDto) throws JsonProcessingException, InterruptedException {
        var accountDto = AccountMapper.MAPPER.toDto(requestDto);
        accountService.registerNewAccount(accountDto);
    }

    public void updateAccountInformation(Long accountId, AccountRequestDto requestDto) {
        var accountDto = AccountMapper.MAPPER.toDto(requestDto);
        accountService.updateAccountInformation(accountId, accountDto);
    }

    public void deleteAccount(Long accountId) {
        accountService.deleteAccount(accountId);
    }
}
