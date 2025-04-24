package GLO4.getMyTicket_Backend.controller;

import GLO4.getMyTicket_Backend.model.Agence;
import GLO4.getMyTicket_Backend.service.AgenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final AgenceService agenceService;

    @PostMapping
    public ResponseEntity<Agence> createAgence(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.createAgence(agence));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
        return ResponseEntity.ok(agenceService.getAgenceById(id));
    }

    @GetMapping
    public ResponseEntity<List<Agence>> getAgences() {
        return ResponseEntity.ok(agenceService.getAllAgences());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        return ResponseEntity.ok(agenceService.updateAgence(id, agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }
}
