package cz.topPeople.service;

import cz.topPeople.entity.Candidate;
import cz.topPeople.entity.Company;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface CandidateService {

    void save(Candidate candidate);

    void save(Collection<Candidate> candidates);

    Candidate findOne(int id);

    List<Candidate> findAll();

    void delete(Candidate candidate);

    void delete(int id);

    List<Candidate> findAll(Collection<Integer> listId);

    List<Candidate> findAllByPositionEquals(String position);

    Candidate findCandidateWithCoordinatorById(@Param("id") int id);

    Candidate findByLanguages( int id);
}
