package com.mgt.ent.savingapp.mapper;

import com.mgt.ent.savingapp.dto.AccountDto;
import com.mgt.ent.savingapp.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountName(),
                accountDto.getBalance()
        );
        return  account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountName(),
                account.getBalance()
        );
        return accountDto;
    }
}
