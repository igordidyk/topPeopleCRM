package cz.topPeople.dao;


import cz.topPeople.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateDAO extends JpaRepository<Candidate, Integer> {}
