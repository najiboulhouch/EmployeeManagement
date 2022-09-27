package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Fonction;

import java.util.List;


public interface FonctionService extends BaseService<Fonction> {

    public List<Fonction> findAllFonctions();
}
