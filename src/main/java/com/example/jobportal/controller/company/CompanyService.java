package com.example.jobportal.controller.company;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyInterface {
    CompanyRepository companyRepository;

    CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Boolean createCompany(CompanyEntity company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteCompany(int id) {

        Optional<CompanyEntity> optional = companyRepository.findById(id);
        if (optional.isPresent()) {
            CompanyEntity company = optional.get();
            companyRepository.delete(company);
            return true;
        }

        return false;
    }

    @Override
    public Boolean updateCompany(CompanyEntity company) {
        Optional<CompanyEntity> optional = companyRepository.findById(company.getId());

        if (optional.isPresent()) {
            CompanyEntity company1 = optional.get();
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());
            company1.setReviews(company.getReviews());
            company1.setCompanyAddress(company.getCompanyAddress());
            company1.setType(company.getType());
            companyRepository.save(company1);
            return true;
        }
        return false;

    }

    @Override
    public List<CompanyEntity> getAllCompany() {
        List<CompanyEntity> companys = companyRepository.findAll();
        if (companys.isEmpty()) {
            return null;
        }
        return companys;
    }

    @Override
    public CompanyEntity getCompany(int id) {
        CompanyEntity company = companyRepository.findById(id).get();
        return company;
    }
}
