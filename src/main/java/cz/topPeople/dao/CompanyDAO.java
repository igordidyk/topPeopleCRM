package cz.topPeople.dao;

import cz.topPeople.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CompanyDAO extends JpaRepository<Company, Integer> {

}
