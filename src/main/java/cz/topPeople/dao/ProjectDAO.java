package cz.topPeople.dao;


import cz.topPeople.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectDAO extends JpaRepository<Project,Integer>{
//    @Query("from Project p where c.id=:id")
    @Query("from Company c join fetch c.projects where c.id=:id")
    List<Project> findAllProjectsOfCompany(int id);
}
