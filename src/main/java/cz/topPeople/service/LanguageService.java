package cz.topPeople.service;


import cz.topPeople.entity.Language;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface LanguageService {
    void save(Language language);

    List<Language> findAll();

    Language findOne(int id);
}
