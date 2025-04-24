package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.model.Horaire;

import java.util.List;

public interface HoraireService {
    public Horaire createHoraire(Horaire horaire);
    public Horaire getHoraireById(Long id);
    public List<Horaire> getAllHoraire();
    public Horaire updateHoraire(Long id, Horaire horaire);
    public void deleteHoraire(Long id);
}
