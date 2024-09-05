package com.example.jobportal.controller.company;

import java.util.List;

public interface CompanyInterface {

    Boolean createCompany(CompanyEntity company);
    Boolean deleteCompany(int id);
    Boolean updateCompany(CompanyEntity company);
    List<CompanyEntity> getAllCompany();
    CompanyEntity getCompany(int id);
}
