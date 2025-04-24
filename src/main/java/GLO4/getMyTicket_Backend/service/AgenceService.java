package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.model.Agence;

import java.util.List;

public interface AgenceService {
    public Agence createAgence(Agence agence);
    public Agence getAgenceById(long id);
    public List<Agence> getAllAgences();
    public Agence updateAgence(Long id, Agence agence);
    public void deleteAgence(Long id);
}

