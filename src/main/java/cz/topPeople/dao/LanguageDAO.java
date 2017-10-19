package cz.topPeople.dao;

import cz.topPeople.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LanguageDAO extends JpaRepository<Language,Integer> {
}
