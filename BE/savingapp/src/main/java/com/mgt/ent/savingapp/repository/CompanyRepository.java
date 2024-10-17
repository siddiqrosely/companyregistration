package com.mgt.ent.savingapp.repository;
import com.mgt.ent.savingapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
