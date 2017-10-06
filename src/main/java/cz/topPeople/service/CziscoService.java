package cz.topPeople.service;



import cz.topPeople.entity.CZ_ISCO;

import java.util.List;

public interface CziscoService {

    void save(CZ_ISCO isco);

    CZ_ISCO findOne(int id);

    List<CZ_ISCO> findAll();


}
