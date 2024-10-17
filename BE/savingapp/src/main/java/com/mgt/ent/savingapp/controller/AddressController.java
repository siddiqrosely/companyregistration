package com.mgt.ent.savingapp.controller;

import com.mgt.ent.savingapp.dto.AddressDto;
import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.entity.Address;
import com.mgt.ent.savingapp.entity.Company;
import com.mgt.ent.savingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping("/addAddress")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto, CompanyDto companyDto) {
        return new ResponseEntity<>(addressService.createAddress(addressDto, companyDto), HttpStatus.CREATED);
    }


    @GetMapping("/getAllAddress")
    public ResponseEntity<List<AddressDto>> getAllAddress(){

        List<AddressDto> addressDtoList = addressService.getAllAddress();
        return ResponseEntity.ok(addressDtoList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id) {
        AddressDto addressDto = addressService.getAddressByCompanyId(id);
        return ResponseEntity.ok(addressDto);
    }

    @PostMapping("/{id}/updateAddress")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Long id, @RequestBody Map<String, String> request) {
        AddressDto addressDto = new AddressDto(
                id,
                request.get("addType"),
                request.get("address1"),
                request.get("address2"),
                request.get("address3"),
                request.get("city"),
                request.get("postcode"),
                request.get("state")
        );

        AddressDto updateAddress = addressService.updateAddressById(addressDto);
        System.out.println("save updated address");
        return ResponseEntity.ok(updateAddress);
    }

    @PostMapping("/{id}/deleteAddress")
    public ResponseEntity<String> deleteAddressById(@PathVariable Long id){
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("Address deleted");
    }

}
