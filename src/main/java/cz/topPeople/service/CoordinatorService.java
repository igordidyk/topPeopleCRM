package cz.topPeople.service;


import cz.topPeople.entity.Coordinator;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoordinatorService {
    void save(Coordinator coordinator);
    Coordinator findOne(int id);
    List<Coordinator> findAll();
    void delete(Coordinator coordinator);
    void delete(int id);
    void update(Coordinator coordinator);

    Coordinator findByName(String name);
}
