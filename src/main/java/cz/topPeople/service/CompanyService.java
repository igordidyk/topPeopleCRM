package cz.topPeople.service;



import cz.topPeople.entity.Company;

import java.util.List;

public interface CompanyService {
    void save(Company company);

    void update(Company company);

    Company findOne(int id);

    List<Company> findAll();

    void delete(Company company);

    void delete(int id);


}
