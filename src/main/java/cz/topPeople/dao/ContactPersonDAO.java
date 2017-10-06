package cz.topPeople.dao;

import cz.topPeople.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonDAO extends JpaRepository<ContactPerson,Integer> {
}
