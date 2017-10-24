package cz.topPeople.dao;

import cz.topPeople.entity.GroupWithCandidates;
import cz.topPeople.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupWithCandidatesDAO extends JpaRepository<GroupWithCandidates, Integer> {

    GroupWithCandidates findGroupWithCandidatesByNameGroupEquals(String name);
}
