package com.mgt.ent.savingapp.service;

import com.mgt.ent.savingapp.dto.AddressDto;
import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Company;

import java.util.List;

public interface AddressService {

    AddressDto createAddress(AddressDto addressDto, CompanyDto companydto);

    AddressDto getAddressByCompanyId(Long id);

    AddressDto updateAddressById(AddressDto addressDto);

    void deleteAddressById(Long id);

    List<AddressDto> getAllAddress();

}
