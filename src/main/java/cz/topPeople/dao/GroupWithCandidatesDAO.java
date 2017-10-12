package cz.topPeople.dao;

import cz.topPeople.entity.GroupWithCandidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupWithCandidatesDAO extends JpaRepository<GroupWithCandidates,Integer>{
}
