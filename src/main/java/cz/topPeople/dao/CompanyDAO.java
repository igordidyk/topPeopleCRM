package cz.topPeople.dao;

import cz.topPeople.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyDAO extends JpaRepository<Company, Integer> {

}
