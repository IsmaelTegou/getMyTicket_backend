package GLO4.getMyTicket_Backend.controller;

import GLO4.getMyTicket_Backend.model.Horaire;
import GLO4.getMyTicket_Backend.service.HoraireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horaires")
@RequiredArgsConstructor
public class HoraireController {
    private final HoraireService horaireService;

    @PostMapping
    public ResponseEntity<Horaire> createHoraire(@RequestBody Horaire horaire) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horaireService.createHoraire(horaire));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horaire> getHoraireById(@PathVariable Long id) {
        return ResponseEntity.ok(horaireService.getHoraireById(id));
    }

    @GetMapping
    public ResponseEntity<List<Horaire>> getAllHoraires() {
        return ResponseEntity.ok(horaireService.getAllHoraire());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horaire> updateHoraire(@PathVariable Long id, @RequestBody Horaire horaire) {
        return ResponseEntity.ok(horaireService.updateHoraire(id, horaire));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoraire(@PathVariable Long id) {
        horaireService.deleteHoraire(id);
        return ResponseEntity.noContent().build();
    }
}
