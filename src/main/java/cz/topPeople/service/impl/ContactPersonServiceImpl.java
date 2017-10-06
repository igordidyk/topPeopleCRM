package cz.topPeople.service.impl;

import cz.topPeople.dao.ContactPersonDAO;
import cz.topPeople.entity.ContactPerson;
import cz.topPeople.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactPersonServiceImpl implements ContactPersonService {
    @Autowired
    private ContactPersonDAO personDAO;

    @Override
    public void save(ContactPerson person) {
        personDAO.save(person);
    }

    @Override
    public ContactPerson findOne(int id) {
        return personDAO.findOne(id);
    }

    @Override
    public List<ContactPerson> findAll() {
        return personDAO.findAll();
    }

    @Override
    public void delete(ContactPerson person) {
        personDAO.delete(person);
    }

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }

}
