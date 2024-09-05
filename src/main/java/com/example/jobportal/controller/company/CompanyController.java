package com.example.jobportal.controller.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public ResponseEntity<List<CompanyEntity>> getAllCompanys(){
        List<CompanyEntity> companys=companyService.getAllCompany();
        if(companys.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companys,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable int id){
        CompanyEntity cp=companyService.getCompany(id);
        if(cp==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cp,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody CompanyEntity company){
        Boolean cp= companyService.createCompany(company);
        if(cp){
            return new ResponseEntity<>("Company Created Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error in  Creating Company Data",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCompany(@RequestBody CompanyEntity company){
        Boolean cp= companyService.updateCompany(company);
        if(cp){
            return new ResponseEntity<>("Company Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Error in Updating Company Details",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id){

        Boolean deletedEntity=companyService.deleteCompany(id);
        if(deletedEntity){
            return new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
        }

        return new ResponseEntity<>("Error in Deleting Company Details",HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
