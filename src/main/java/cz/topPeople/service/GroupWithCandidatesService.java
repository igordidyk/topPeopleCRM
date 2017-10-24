package cz.topPeople.service;


import cz.topPeople.entity.GroupWithCandidates;
import cz.topPeople.entity.Project;

import java.util.List;

public interface GroupWithCandidatesService {
    void save(GroupWithCandidates group);

    List<GroupWithCandidates> findAll();

    GroupWithCandidates findOne(int id);

    void delete(int id);

    void delete(GroupWithCandidates group);

    GroupWithCandidates findGroupWithCandidatesByNameGroupEquals(String name);

}
