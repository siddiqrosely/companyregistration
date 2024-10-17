package com.mgt.ent.savingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String addType;
    private String address1;
    private String address2;
    private String address3;
    private String postcode;
    private String city;
    private String state;

}
