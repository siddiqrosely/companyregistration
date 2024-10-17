package com.mgt.ent.savingapp.service.impl;

import com.mgt.ent.savingapp.dto.AddressDto;
import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Address;
import com.mgt.ent.savingapp.entity.Company;
import com.mgt.ent.savingapp.mapper.AddressMapper;
import com.mgt.ent.savingapp.mapper.CompanyMapper;
import com.mgt.ent.savingapp.repository.CompanyRepository;
import com.mgt.ent.savingapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegistrationService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto registerCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompName(companyDto.getCompName());
        company.setCreateBy(companyDto.getCreateBy());

        List<Address> addressList = companyDto.getAddresses().stream()
                .map(addressDto -> AddressMapper.mapToAddress(addressDto, companyDto)).collect(Collectors.toList());
        company.setAddresses(addressList);

        Company savedCompany = companyRepository.save(company);
        CompanyDto savedCompanyDto = CompanyMapper.mapToCompanyDto(savedCompany);

        return savedCompanyDto;
    }
}
