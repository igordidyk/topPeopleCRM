package cz.topPeople.service;



import cz.topPeople.entity.ContactPerson;

import java.util.List;

public interface ContactPersonService {


    void save(ContactPerson person);

    ContactPerson findOne(int id);

    List<ContactPerson> findAll();

    void delete(ContactPerson person);

    void delete(int id);

//    List<ContactPerson> findAllPersonsFromCompany( int id);


}
