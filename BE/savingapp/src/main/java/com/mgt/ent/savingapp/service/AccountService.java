package com.mgt.ent.savingapp.service;


import com.mgt.ent.savingapp.dto.AccountDto;
import com.mgt.ent.savingapp.dto.CompanyDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    void deleteAccountById(Long id);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

}
