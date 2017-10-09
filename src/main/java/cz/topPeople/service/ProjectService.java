package cz.topPeople.service;


import cz.topPeople.entity.Project;

import java.util.List;

public interface ProjectService {
    void save(Project project);

    List<Project> findAll();

    Project findOne(int id);

    void delete(int id);

    void delete(Project project);
}
