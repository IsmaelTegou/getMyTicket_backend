package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.TrajetRequestDTO;
import GLO4.getMyTicket_Backend.dto.TrajetResponseDTO;
import GLO4.getMyTicket_Backend.model.Trajet;

import java.util.List;

public interface TrajetService {
    public TrajetResponseDTO createTrajet(TrajetRequestDTO trajetRequestDTO);
    public TrajetResponseDTO getTrajetById(Long id);
    public Trajet findTrajetById(Long id);
    public List<TrajetResponseDTO> getAllTrajets();
    public TrajetResponseDTO updateTrajet(Long id, TrajetRequestDTO trajetRequestDTO);
    public void deleteTrajet(Long id);
}
