package com.mgt.ent.savingapp.service;

import com.mgt.ent.savingapp.dto.CompanyDto;

public interface CompanyService {

        CompanyDto createCompany(CompanyDto companyDto);

        CompanyDto getCompanyById(Long id);

        CompanyDto updateCompany(CompanyDto companyDto);
        void deleteCompany(Long id);

}
