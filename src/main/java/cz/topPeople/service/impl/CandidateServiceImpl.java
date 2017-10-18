package cz.topPeople.service.impl;

import cz.topPeople.dao.CandidateDAO;
import cz.topPeople.entity.Candidate;
import cz.topPeople.entity.Company;
import cz.topPeople.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDAO dao;


    @Override
    public void save(Candidate candidate) {
        dao.save(candidate);
    }

    @Override
    public Candidate findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<Candidate> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Candidate candidate) {
        dao.delete(candidate);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
