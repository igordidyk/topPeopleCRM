package cz.topPeople.dao;

import cz.topPeople.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ihor Didyk on 19.10.2017.
 */
public interface EducationDAO extends JpaRepository<Education,Integer> {
}
