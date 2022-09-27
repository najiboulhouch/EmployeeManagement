package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Fonction;
import net.najiboulhouch.gestionpersonnel.respositories.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonctionServiceImpl extends BaseServiceImpl<Fonction> implements FonctionService {

    @Autowired
    private FonctionRepository fonctionRepository;

    @Override
    public List<Fonction> findAllFonctions() {
        return fonctionRepository.findAll();
    }
}
