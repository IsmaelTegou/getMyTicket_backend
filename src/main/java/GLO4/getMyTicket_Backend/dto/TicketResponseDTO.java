package GLO4.getMyTicket_Backend.dto;

import GLO4.getMyTicket_Backend.model.Horaire;
import GLO4.getMyTicket_Backend.model.Trajet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDTO {
    private Long id;
    private Trajet trajet;
    private String numBus;
    private Horaire horaire;
    private String numCNIClient;
    private String nomClient;
    private String prenomClient;
}
