package cz.topPeople.service.impl;

import cz.topPeople.dao.ProjectDAO;
import cz.topPeople.entity.Project;
import cz.topPeople.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectDAO projectDAO;


    @Override
    public void save(Project project) {
        projectDAO.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectDAO.findAll();
    }

    @Override
    public Project findOne(int id) {
        return projectDAO.findOne(id);
    }

    @Override
    public void delete(int id) {
        projectDAO.delete(id);
    }

    @Override
    public void delete(Project project) {
        projectDAO.delete(project);

    }
}
