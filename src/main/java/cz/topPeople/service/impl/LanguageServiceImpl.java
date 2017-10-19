package cz.topPeople.service.impl;

import cz.topPeople.dao.LanguageDAO;
import cz.topPeople.entity.Language;
import cz.topPeople.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageDAO languageDAO;


    @Override
    public void save(Language language) {
        languageDAO.save(language);
    }

    @Override
    public List<Language> findAll() {
        return languageDAO.findAll();
    }

    @Override
    public Language findOne(int id) {
        return languageDAO.findOne(id);
    }
}
