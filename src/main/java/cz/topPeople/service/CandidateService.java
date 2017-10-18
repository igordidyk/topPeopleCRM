package cz.topPeople.service;

import cz.topPeople.entity.Candidate;
import cz.topPeople.entity.Company;

import java.util.List;

public interface CandidateService {

    void save(Candidate candidate);

    Candidate findOne(int id);

    List<Candidate> findAll();

    void delete(Candidate candidate);

    void delete(int id);


}
