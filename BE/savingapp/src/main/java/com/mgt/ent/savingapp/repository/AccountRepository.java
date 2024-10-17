package com.mgt.ent.savingapp.repository;

import com.mgt.ent.savingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
