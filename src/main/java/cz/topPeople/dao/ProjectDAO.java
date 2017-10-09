package cz.topPeople.dao;


import cz.topPeople.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project,Integer>{
}
