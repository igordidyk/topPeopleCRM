package cz.topPeople.service.impl;

import cz.topPeople.dao.GroupWithCandidatesDAO;
import cz.topPeople.entity.GroupWithCandidates;
import cz.topPeople.service.GroupWithCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupWithCandidatesServiceImpl implements GroupWithCandidatesService {

    @Autowired
    private GroupWithCandidatesDAO groupDAO;

    @Override
    public void save(GroupWithCandidates group) {
        groupDAO.save(group);
    }

    @Override
    public List<GroupWithCandidates> findAll() {
        return groupDAO.findAll();
    }

    @Override
    public GroupWithCandidates findOne(int id) {
        return groupDAO.findOne(id);
    }

    @Override
    public void delete(int id) {
        groupDAO.delete(id);
    }

    @Override
    public void delete(GroupWithCandidates group) {
        groupDAO.delete(group);

    }
}
