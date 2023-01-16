package com.alberto.person.facade;


import com.alberto.person.model.dto.AccountRequestDto;
import com.alberto.person.model.mapper.AccountMapper;
import com.alberto.person.service.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountFacade {

    @Inject
    AccountService accountService;

    public void registerNewAccount(AccountRequestDto requestDto) {
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
