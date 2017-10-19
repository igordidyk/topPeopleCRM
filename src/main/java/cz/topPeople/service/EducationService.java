package cz.topPeople.service;

import cz.topPeople.entity.Education;
import java.util.List;

public interface EducationService {

    void save(Education education);

    List<Education> findAll();

    Education findOne(int id);
}
