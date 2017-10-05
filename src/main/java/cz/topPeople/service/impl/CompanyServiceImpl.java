package cz.topPeople.service.impl;

import cz.topPeople.dao.CompanyDAO;
import cz.topPeople.entity.Company;
import cz.topPeople.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO dao;

    @Override
    public void save(Company company) {
        System.out.println("done");
        dao.save(company);
    }

    @Override
    public void update(Company company) {
        dao.save(company);
    }

    @Override
    public Company findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<Company> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Company company) {
        dao.delete(company);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }


}
