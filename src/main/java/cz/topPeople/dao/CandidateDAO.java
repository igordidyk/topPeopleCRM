package cz.topPeople.dao;


import cz.topPeople.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDAO extends JpaRepository<Candidate,Integer> {
}
