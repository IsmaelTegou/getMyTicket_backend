package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.model.Agence;
import GLO4.getMyTicket_Backend.repository.AgenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements AgenceService {
    private final AgenceRepository agenceRepository;

    @Override
    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence getAgenceById(long id) {
        return agenceRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Agence with id " + id + " not found")
        );
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence updateAgence(Long id, Agence agence) {
        Agence ag = getAgenceById(id);
        ag.setName(agence.getName());
        ag.setDenomination(agence.getDenomination());
        ag.setCity(agence.getCity());
        return agenceRepository.save(ag);
    }

    @Override
    public void deleteAgence(Long id) {
        Agence ag = getAgenceById(id);
        agenceRepository.delete(ag);
    }
}
