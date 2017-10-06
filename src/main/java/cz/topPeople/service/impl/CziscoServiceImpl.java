package cz.topPeople.service.impl;

import cz.topPeople.dao.CziscoDAO;
import cz.topPeople.entity.CZ_ISCO;
import cz.topPeople.service.CziscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CziscoServiceImpl implements CziscoService{

    @Autowired
    private CziscoDAO iscoDao;
    @Override
    public void save(CZ_ISCO isco) {
        iscoDao.save(isco);
    }

    @Override
    public CZ_ISCO findOne(int id) {
        return iscoDao.findOne(id);
    }

    @Override
    public List<CZ_ISCO> findAll() {
        return iscoDao.findAll();
    }

}
