package com.mgt.ent.savingapp.repository;

import com.mgt.ent.savingapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address, Long> {

}
