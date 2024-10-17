package com.mgt.ent.savingapp.service.impl;

import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Company;
import com.mgt.ent.savingapp.mapper.CompanyMapper;
import com.mgt.ent.savingapp.repository.CompanyRepository;
import com.mgt.ent.savingapp.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private  CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }


    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = CompanyMapper.mapToCompany(companyDto);
        Company savedCompany = companyRepository.save(company);
        CompanyDto savedCompanyDto = CompanyMapper.mapToCompanyDto(savedCompany);
        return savedCompanyDto;
    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Company not exist"));

        System.out.println("company details : "+company.toString());
        CompanyDto companyDto = CompanyMapper.mapToCompanyDto(company);
        return companyDto;
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto) {

        Optional<Company> companyOptional = companyRepository.findById(companyDto.getId());
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setCompName(companyDto.getCompName());
            company.setCreateBy(companyDto.getCreateBy());
            Company updatedCompany = companyRepository.save(company);

            return CompanyMapper.mapToCompanyDto(updatedCompany);
        }else{
            throw new EntityNotFoundException("Company id not exist "+companyDto.getId());
        }

    }

    @Override
    public void deleteCompany(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            companyRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Company id is not exist "+id);
        }
    }


}
