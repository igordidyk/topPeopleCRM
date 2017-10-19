package cz.topPeople.service.impl;

import cz.topPeople.dao.CoordinatorDAO;
import cz.topPeople.entity.Coordinator;
import cz.topPeople.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CoordinatorServiceImpl implements CoordinatorService,UserDetailsService{
    @Autowired
    private CoordinatorDAO coordinatorDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(Coordinator coordinator) {
        coordinator.setPassword(passwordEncoder.encode(coordinator.getPassword()));
        coordinatorDAO.save(coordinator);
    }

    @Override
    public Coordinator findOne(int id) {
        return coordinatorDAO.findOne(id);
    }

    @Override
    public List<Coordinator> findAll() {
        return coordinatorDAO.findAll();
    }

    @Override
    public void delete(Coordinator coordinator) {
        coordinatorDAO.delete(coordinator);
    }

    @Override
    public void delete(int id) {
        coordinatorDAO.delete(id);
    }

    @Override
    public void update(Coordinator coordinator) {
        coordinatorDAO.save(coordinator);
    }


    @Override
    public Coordinator findByName(String name) {
        return coordinatorDAO.findByUserName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByName(username);
    }
}
