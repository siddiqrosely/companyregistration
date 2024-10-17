package com.mgt.ent.savingapp.mapper;

import com.mgt.ent.savingapp.dto.AddressDto;
import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Address;
import com.mgt.ent.savingapp.entity.Company;

public class AddressMapper {

    public static Address mapToAddress(AddressDto addressDto, CompanyDto companyDto){

        Company company = new Company();
        company.setId(companyDto.getId());
        company.setCompName(companyDto.getCompName());
        company.setCreateBy(companyDto.getCreateBy());


        Address address = new Address();
        address.setId(addressDto.getId());
        address.setAddType(address.getAddType());
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setAddress3(addressDto.getAddress3());
        address.setPostcode(addressDto.getPostcode());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCompany(company);
        return address;
    }
    public static AddressDto mapToAddressDto(Address address){
        AddressDto addressDto = new AddressDto(
                address.getId(),
                address.getAddType(),
                address.getAddress1(),
                address.getAddress2(),
                address.getAddress3(),
                address.getCity(),
                address.getPostcode(),
                address.getState()
        );
        return addressDto;
    }

}
