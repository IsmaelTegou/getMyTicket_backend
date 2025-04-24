package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.model.Horaire;
import GLO4.getMyTicket_Backend.repository.HoraireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoraireServiceImpl implements HoraireService {
    private final HoraireRepository horaireRepository;

    @Override
    public Horaire createHoraire(Horaire horaire) {
        return horaireRepository.save(horaire);
    }

    @Override
    public Horaire getHoraireById(Long id) {
        return horaireRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Horaire with id " + id + " not found")
        );
    }

    @Override
    public List<Horaire> getAllHoraire() {
        return horaireRepository.findAll();
    }

    @Override
    public Horaire updateHoraire(Long id, Horaire horaire) {
        Horaire h = getHoraireById(id);
        h.setStartTime(horaire.getStartTime());
        h.setFinishTime(horaire.getFinishTime());

        return horaireRepository.save(h);
    }

    @Override
    public void deleteHoraire(Long id) {
        Horaire h = getHoraireById(id);
        horaireRepository.delete(h);
    }
}
