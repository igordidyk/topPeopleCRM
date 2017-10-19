package cz.topPeople.service.impl;

import cz.topPeople.dao.EducationDAO;
import cz.topPeople.entity.Education;
import cz.topPeople.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationDAO educationDAO;

    @Override
    public void save(Education education) {
        educationDAO.save(education);
    }

    @Override
    public List<Education> findAll() {
        return educationDAO.findAll();
    }

    @Override
    public Education findOne(int id) {
        return educationDAO.findOne(id);
    }
}
