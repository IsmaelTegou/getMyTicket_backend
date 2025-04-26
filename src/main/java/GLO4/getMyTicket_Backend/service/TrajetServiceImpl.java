package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.TrajetRequestDTO;
import GLO4.getMyTicket_Backend.dto.TrajetResponseDTO;
import GLO4.getMyTicket_Backend.model.Trajet;
import GLO4.getMyTicket_Backend.repository.TrajetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrajetServiceImpl implements TrajetService {
    private final TrajetRepository trajetRepository;
    private final AgenceService agenceService;

    @Override
    public TrajetResponseDTO createTrajet(TrajetRequestDTO trajetRequestDTO) {
        Trajet trajet = Trajet.builder()
                .id(trajetRequestDTO.getId())
                .name(trajetRequestDTO.getName())
                .price(trajetRequestDTO.getPrice())
                .startAgence(agenceService.getAgenceById(trajetRequestDTO.getIdStartAgence()))
                .endAgence(agenceService.getAgenceById(trajetRequestDTO.getIdEndAgence()))
                .build();
        trajetRepository.save(trajet);

        return mapToDTO(trajet);
    }

    @Override
    public TrajetResponseDTO getTrajetById(Long id) {
        Trajet trajet = trajetRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Trajet with id " + id + " not found")
        );

        return mapToDTO(trajet);
    }

    @Override
    public Trajet findTrajetById(Long id) {
        return trajetRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Trajet with id " + id + " not found")
        );
    }

    @Override
    public List<TrajetResponseDTO> getAllTrajets() {
        return trajetRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public TrajetResponseDTO updateTrajet(Long id, TrajetRequestDTO trajetRequestDTO) {
        Trajet trajet = findTrajetById(id);
        trajet.setName(trajetRequestDTO.getName());
        trajet.setPrice(trajetRequestDTO.getPrice());
        trajet.setStartAgence(agenceService.getAgenceById(trajetRequestDTO.getIdStartAgence()));
        trajet.setEndAgence(agenceService.getAgenceById(trajetRequestDTO.getIdEndAgence()));

        trajetRepository.save(trajet);

        return mapToDTO(trajet);
    }

    @Override
    public void deleteTrajet(Long id) {
        Trajet trajet = findTrajetById(id);
        trajetRepository.delete(trajet);
    }

    private TrajetResponseDTO mapToDTO(Trajet trajet) {
        return TrajetResponseDTO.builder()
                .id(trajet.getId())
                .name(trajet.getName())
                .price(trajet.getPrice())
                .idStartAgence(trajet.getStartAgence().getId())
                .startAgenceName(trajet.getStartAgence().getName())
                .startAgenceCity(trajet.getStartAgence().getCity())
                .idEndAgence(trajet.getEndAgence().getId())
                .endAgenceName(trajet.getEndAgence().getName())
                .endAgenceCity(trajet.getEndAgence().getCity())
                .build();
    }
}
