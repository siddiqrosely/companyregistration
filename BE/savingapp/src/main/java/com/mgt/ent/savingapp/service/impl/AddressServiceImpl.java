package com.mgt.ent.savingapp.service.impl;

import com.mgt.ent.savingapp.dto.AddressDto;
import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Address;
import com.mgt.ent.savingapp.entity.Company;
import com.mgt.ent.savingapp.mapper.AddressMapper;
import com.mgt.ent.savingapp.repository.AddressRepository;
import com.mgt.ent.savingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto, CompanyDto companyDto) {

        Address address = AddressMapper.mapToAddress(addressDto, companyDto);
        Address saveAddress = addressRepository.save(address);
        AddressDto saveAddressDto = AddressMapper.mapToAddressDto(saveAddress);
        return saveAddressDto;
    }

    @Override
    public AddressDto getAddressByCompanyId(Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Address not exist"));
        System.out.println(address.toString());
        AddressDto addressDto = AddressMapper.mapToAddressDto(address);
        return addressDto;
    }

    @Override
    public AddressDto updateAddressById(AddressDto addressDto) {

        Optional<Address> optionalAddress = addressRepository.findById(addressDto.getId());
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            address.setAddType(addressDto.getAddType());
            address.setAddress1(addressDto.getAddress1());
            address.setAddress2(addressDto.getAddress2());
            address.setAddress3(addressDto.getAddress3());
            address.setCity(addressDto.getCity());
            address.setPostcode(addressDto.getPostcode());
            address.setState(addressDto.getState());

            System.out.println("update address : "+address.toString());

            Address updatedAddress = addressRepository.save(address);
            return AddressMapper.mapToAddressDto(updatedAddress);

        }else{
            throw new RuntimeException("Address not exist");
        }
    }

    @Override
    public void deleteAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()){
            addressRepository.deleteById(id);
        }else {
            throw new RuntimeException("Address not exist");
        }
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();

        List<AddressDto> addressDtoList = addressList.stream().map((address -> AddressMapper.mapToAddressDto(address)))
                .collect(Collectors.toList());

        return addressDtoList;
    }
}
