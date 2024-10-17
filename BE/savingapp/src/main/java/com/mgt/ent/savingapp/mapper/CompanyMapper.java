package com.mgt.ent.savingapp.mapper;

import com.mgt.ent.savingapp.dto.AddressDto;
import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Company;
import com.mgt.ent.savingapp.entity.Address;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyMapper {

    public static Company mapToCompany(CompanyDto companyDto) {
        // Create the Company object
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setCompName(companyDto.getCompName());
        company.setCreateBy(companyDto.getCreateBy());

        // Map AddressDto list to Address entities and set the company reference
        List<Address> addresses = companyDto.getAddresses().stream()
                .map(addressDto -> {
                    Address address = new Address();
                    address.setAddType(addressDto.getAddType());
                    address.setAddress1(addressDto.getAddress1());
                    address.setAddress2(addressDto.getAddress2());
                    address.setAddress3(addressDto.getAddress3());
                    address.setPostcode(addressDto.getPostcode());
                    address.setCity(addressDto.getCity());
                    address.setState(addressDto.getState());
                    address.setCompany(company);  // Set the company in each address
                    return address;
                }).collect(Collectors.toList());

        // Set the list of addresses in the company
        company.setAddresses(addresses);

        return company;
    }


    public static CompanyDto mapToCompanyDto(Company company) {
        CompanyDto companyDto = new CompanyDto();

        companyDto.setId(company.getId());
        companyDto.setCompName(company.getCompName());
        companyDto.setCreateBy(company.getCreateBy());

        List<AddressDto> addressDtoList = company.getAddresses().stream()
                .map(addres -> {
                    AddressDto addressDto = new AddressDto();
                    addressDto.setAddType(addres.getAddType());
                    addressDto.setAddress1(addres.getAddress1());
                    addressDto.setAddress2(addres.getAddress2());
                    addressDto.setAddress3(addres.getAddress3());
                    addressDto.setPostcode(addres.getPostcode());
                    addressDto.setCity(addres.getCity());
                    addressDto.setState(addres.getState());
                    return addressDto;
                }).collect(Collectors.toList());
        companyDto.setAddresses(addressDtoList);

        return companyDto;

    }
}
