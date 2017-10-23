package cz.topPeople.dao;


import cz.topPeople.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateDAO extends JpaRepository<Candidate, Integer> {
    List<Candidate> findAllByPositionEquals(String position);

    @Query("select c from Candidate c join fetch c.coordinator co where c.id=:id")
    Candidate findCandidateWithCoordinatorById(@Param("id") int id);
}
