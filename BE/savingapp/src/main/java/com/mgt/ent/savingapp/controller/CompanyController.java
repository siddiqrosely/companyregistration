package com.mgt.ent.savingapp.controller;

import com.mgt.ent.savingapp.dto.CompanyDto;
import com.mgt.ent.savingapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto){
        return new ResponseEntity<>(companyService.createCompany(companyDto), HttpStatus.CREATED);

    }

    @GetMapping("/{id}/getcompany")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id){
        CompanyDto companyDto = companyService.getCompanyById(id);
        return ResponseEntity.ok(companyDto);
    }

    @PostMapping("{id}/updatecompany")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable  Long id, @RequestBody Map<String, String> request){

        CompanyDto sourceDto = new CompanyDto(
                id,
                request.get("compName"),
                request.get("createBy")
        );

        CompanyDto companyDto = companyService.updateCompany(sourceDto);
        return ResponseEntity.ok(companyDto);
    }

    @PostMapping("/{id}/deletecompany")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Company id "+id+" deleted.");
    }



}
