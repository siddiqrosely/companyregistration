package com.mgt.ent.savingapp.service.impl;

import com.mgt.ent.savingapp.dto.AccountDto;
import com.mgt.ent.savingapp.entity.Account;
import com.mgt.ent.savingapp.exception.AccountException;
import com.mgt.ent.savingapp.mapper.AccountMapper;
import com.mgt.ent.savingapp.repository.AccountRepository;
import com.mgt.ent.savingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account "+id+" not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account "+id+" not exist. Deposit failed"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account saveAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public void deleteAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account "+id+" not exist. Deletion failed"));

        accountRepository.deleteById(id);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account "+id+" not exist. Withdraw failed"));

        double balance = account.getBalance();
        if(amount > balance){
            throw new AccountException("Account balance insufficient");
        }

        balance = balance - amount;
        account.setBalance(balance);
        Account saveAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account)))
                .collect(Collectors.toList());

    }


}
