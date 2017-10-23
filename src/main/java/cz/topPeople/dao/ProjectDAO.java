package cz.topPeople.dao;


import cz.topPeople.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectDAO extends JpaRepository<Project,Integer>{

    @Query("from Project p join fetch p.company c where c.id=:id ")
    List<Project> findAllProjectsOfCompany(@Param("id") int id);

    @Query("select p from Project p left outer join fetch p.groups g where p.id=:id")
    Project findProjectWithGroupsById(@Param("id")int id);
}
