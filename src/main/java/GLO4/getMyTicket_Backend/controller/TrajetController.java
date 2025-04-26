package GLO4.getMyTicket_Backend.controller;

import GLO4.getMyTicket_Backend.dto.TrajetRequestDTO;
import GLO4.getMyTicket_Backend.dto.TrajetResponseDTO;
import GLO4.getMyTicket_Backend.service.TrajetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:53018")
@RestController
@RequestMapping("/trajets")
@RequiredArgsConstructor
public class TrajetController {
    private final TrajetService trajetService;

    @PostMapping
    public ResponseEntity<TrajetResponseDTO> createTrajet(@RequestBody TrajetRequestDTO trajetRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trajetService.createTrajet(trajetRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrajetResponseDTO> getTrajetById(@PathVariable Long id) {
        return ResponseEntity.ok(trajetService.getTrajetById(id));
    }

    @GetMapping
    public ResponseEntity<List<TrajetResponseDTO>> getAllTrajets() {
        return ResponseEntity.ok(trajetService.getAllTrajets());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrajetResponseDTO> updateTrajet(@PathVariable Long id, @RequestBody TrajetRequestDTO trajetRequestDTO) {
        return ResponseEntity.ok(trajetService.updateTrajet(id, trajetRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrajet(@PathVariable Long id) {
        trajetService.deleteTrajet(id);
        return ResponseEntity.noContent().build();
    }
}
